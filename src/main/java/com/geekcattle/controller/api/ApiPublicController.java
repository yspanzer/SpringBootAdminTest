package com.geekcattle.controller.api;

import com.geekcattle.controller.BaseController;
import com.geekcattle.core.LoginEnum;
import com.geekcattle.core.jwt.AccessToken;
import com.geekcattle.core.jwt.JwtConfig;
import com.geekcattle.core.jwt.JwtUtil;
import com.geekcattle.core.shiro.CustomerAuthenticationToken;
import com.geekcattle.model.Region;
import com.geekcattle.model.console.*;
import com.geekcattle.model.valid.ValidAdmin;
import com.geekcattle.service.console.*;
import com.geekcattle.service.member.MemberService;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ReturnUtil;
import com.geekcattle.util.UuidUtil;
import io.jsonwebtoken.Claims;
import javafx.geometry.Pos;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/oauth")
public class ApiPublicController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private DistribService distribService;
    @Autowired
    private TransferService transferService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeNewService employeeNewService;
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/admintoken", method = RequestMethod.POST)
    public ModelMap doAdminLogin(@Valid ValidAdmin validAdmin, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return ReturnUtil.Error("用户名或密码为空", null, null);
        }
        String username = validAdmin.getUsername();
        CustomerAuthenticationToken token = new CustomerAuthenticationToken(validAdmin.getUsername(), validAdmin.getPassword(), false);
        token.setLoginType(LoginEnum.ADMIN.toString());

        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        //用shiro进行登录验证
        authLoginByUserToken(currentUser, token, username);


        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("loginType", LoginEnum.ADMIN.toString());
            String sessionId = session.getId().toString();
            Admin admin = (Admin) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();

            String accessToken = jwtUtil.createJWT(admin, sessionId, jwtConfig.getSecret());
            logger.debug("token:-------->" + accessToken);
            //返回accessToken
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setAccessToken(accessToken);
            accessTokenEntity.setExpiresIn(jwtConfig.getExpiration());
            accessTokenEntity.setTokenType(jwtConfig.getTokenHead());
            String userName = "";
            if (admin != null) {
                EmployeeNew employee = employeeNewService.getEmployeeByUserId(admin.getUid());
                if (employee != null) {
                    userName = employee.getEmpName();
                }
            }

            accessTokenEntity.setUserName(userName);

            logger.info("用户[" + username + "]登录认证通过");
            return ReturnUtil.Success("登录成功", accessTokenEntity);
        } else {
            token.clear();
            return ReturnUtil.Error("登录失败");
        }
    }

    /**
     * 市场人员用微信 生成收货单一部分字段
     *
     * @return
     */
    @RequestMapping(value = "/receiptSave", method = RequestMethod.POST)
    public Object createReceiptBySaler(Receipt receipt, BindingResult result) {


        try {

            receiptService.insert(receipt);
            //回写对应配送单据的回收状态
            String distribNo = receipt.getDistribno();
            reWriteDistribState(distribNo);
            //回写对应调回单据的回收状态
            String transferNo = receipt.getTransferno();
            reWriteTransferState(transferNo);

            return ReturnUtil.Success("收货单生成成功", null);
        } catch (Exception e) {
            return ReturnUtil.Error("收货单生成失败", null);
        }


    }

    @ResponseBody
    @RequestMapping(value = "/receiptSaveWithRegion", method = RequestMethod.POST)
    public Object createReceiptBySalerWithRegion(Receipt receipt, BindingResult result,HttpServletRequest request) {
        try {
            if(isMaketDepartment(request)){
//                int regionID = receiptService.getRegionByUser(getUid(request));
                int regionID = 0;
                EmployeeNew employeeNew = getEmployeeByUser(request);
                if(employeeNew != null){
                    regionID = employeeNew.getRegionID();
                }
                receipt.setRegionID(regionID);
            }else{
                receipt.setRegionID(0);
            }
            receiptService.insert(receipt);
            //回写对应配送单据的回收状态
            String distribNo = receipt.getDistribno();
            reWriteDistribState(distribNo);
            //回写对应调回单据的回收状态
            String transferNo = receipt.getTransferno();
            reWriteTransferState(transferNo);

            return ReturnUtil.Success("收货单生成成功", null);
        } catch (Exception e) {
            return ReturnUtil.Error("收货单生成失败", null);
        }
    }

    /**
     * 获取收货单列表
     *
     * @param receipt
     * @return
     */
    @RequestMapping("/getAllReceiptList")
    public Object getAllReceiptList(Receipt receipt) {

        List<Receipt> receipts = receiptService.getPageList(receipt);

        return ReturnUtil.Success("加载成功", receipts, null);

    }


    /**
     * 根据新需求取到 收货列表
     * 根据市场人员所在的区域 取到所在区域的收货列表
     */
    @RequestMapping("/getAllReceiptsByRegion")
    public Object getAllReceiptsByRegion(Receipt receipt,HttpServletRequest request) {

        List<Receipt> receipts = new ArrayList<>();
        if (isMaketDepartment(request)) {//判断是否是市场部的
            receipts = receiptService.getAllReceiptsByRegionID(receipt,getUid(request));
        } else {
            receipts = receiptService.getPageList(receipt);
        }
        return ReturnUtil.Success("加载成功", receipts, null);

    }

    private boolean isMaketDepartment(HttpServletRequest request) {

        EmployeeNew employee = getEmployeeByUser(request);
        if (employee != null && employee.getDeptID() == 4) {
            return true;
        }
        return false;

    }

    private EmployeeNew getEmployeeByUser(HttpServletRequest request) {
//        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        EmployeeNew employeeNew = employeeNewService.getEmployeeByUserId(getUid(request));
        return employeeNew;
    }

    private String getUid(HttpServletRequest request){
        String token = request.getParameter("token");
        String userId = "";
        if ((token != null) && (token.length() > 7)) {
            Claims claims = jwtUtil.parseJWT(token, jwtConfig.getSecret());
            if (claims != null) {
                 userId = (String) claims.get("jti");
            }
        }

        return userId;

    }


    /**
     * 根据ID 获取收货单详情页面
     *
     * @param receipt
     * @return
     */
    @RequestMapping("/getReceiptDetail")
    public Object getReceiptDetail(Receipt receipt) {
        try {
            if (receipt.getId() != null) {
                receipt = receiptService.getById(receipt.getId());
                if (receipt != null) {
                    receipt.setUpdatedat(DateUtil.getSysTime());
                }
                return ReturnUtil.Success("加载成功", receipt, null);
            }
            return ReturnUtil.Error("沒有相关的ID", receipt, null);
        } catch (Exception e) {
            return ReturnUtil.Error("获取收货单详情失败", receipt, null);
        }

    }


    @Transactional
    @RequestMapping(value = "/apiReceiptSave", method = {RequestMethod.POST})
    @ResponseBody
    public ModelMap apiReceiptSave(Receipt receipt, BindingResult result) {

        try {
            if (receipt.getId() == null) {
                receipt.setUid(UuidUtil.getUUID());
                receipt.setCreatedat(DateUtil.getSysTime());
                receipt.setUpdatedat(DateUtil.getSysTime());
                receipt.setState(1);
                receiptService.insert(receipt);
                //回写对应配送单据的回收状态
                if (receipt.getDistribno() != null) {
                    Distrib distrib = new Distrib();
                    distrib.setDistribNum(receipt.getDistribno());
                    List<Distrib> distribList = distribService.selectUnRecovery(distrib);
                    if (distribList.size() > 0) {
                        Distrib distribnew = distribList.get(0);
                        distribnew.setRecovery(1);
                        distribService.save(distribnew);
                    }
                }
                //回写对应调回单据的回收状态
                if (receipt.getTransferno() != null) {
                    TransferInfo transferInfo = new TransferInfo();
                    transferInfo.setBizno(receipt.getTransferno());
                    List<TransferInfo> transferInfoList = transferService.selectUnRecovery(transferInfo);
                    if (transferInfoList.size() > 0) {
                        TransferInfo transferInfoNew = transferInfoList.get(0);
                        transferInfoNew.setRecovery(1);
                        transferService.save(transferInfoNew);
                    }
                }
            } else {

                Receipt receiptNew = receiptService.getById(receipt.getId());
                if (receipt.getReceiptNum() != null) {
                    receiptNew.setReceiptNum(receipt.getReceiptNum());
                }
                if (receipt.getReceiptMan() != null) {
                    receiptNew.setReceiptMan(receipt.getReceiptMan());
                }
                if (receipt.getAccepBackMan() != null) {
                    receiptNew.setAccepBackMan(receipt.getAccepBackMan());
                }
                if (receipt.getAccepCheckMan() != null) {
                    receiptNew.setAccepCheckMan(receipt.getAccepCheckMan());
                }
                if (receipt.getAccepReMan() != null) {
                    receiptNew.setAccepReMan(receipt.getAccepReMan());
                }
                if (receipt.getTallyMan() != null) {
                    receiptNew.setTallyMan(receipt.getTallyMan());
                }
                receiptService.update(receiptNew);

            }
            return ReturnUtil.Success("操作成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败", null, null);
        }
    }


    /**
     * 获取配送单列表
     *
     * @param distrib
     * @return
     */
    @RequestMapping(value = "/getAllDistribList", method = RequestMethod.POST)
    public Object getAllDistribList(Distrib distrib, HttpServletRequest request) {
        List<Distrib> Lists = distribService.getPageList(distrib);
        return ReturnUtil.Success("加载成功", Lists, null);
    }


    @RequestMapping(value = "/getAllDistribsByRegionID", method = RequestMethod.POST)
    public Object getAllDistribsByRegionID(Distrib distrib, HttpServletRequest request) {
        List<Distrib> distribs = new ArrayList<>();
        if (isMaketDepartment(request)) {
            distribs = distribService.getAllDistribsByRegionID(distrib,getUid(request));
        } else {
            distribs = distribService.getPageList(distrib);
        }
        return ReturnUtil.Success("加载成功", distribs, null);
    }

    /**
     * 根据ID 获取配送单详情页面
     *
     * @param distrib
     * @return
     */
    @RequestMapping("/getDistribDetail")
    public Object getDistribDetail(Distrib distrib) {
        try {
            if (distrib.getUid() != null) {
                distrib = distribService.getById(distrib.getUid());
                if (distrib != null) {
                    distrib.setUpdatedat(DateUtil.getCurrentTime());
                }
                return ReturnUtil.Success("加载成功", distrib, null);
            }
            return ReturnUtil.Error("沒有相关的ID", distrib, null);
        } catch (Exception e) {
            return ReturnUtil.Error("获取配送单详情失败", distrib, null);
        }

    }


    @RequestMapping("/formlayer")
    public Object fromlayer(Distrib distrib) {
        String checkRoleId = "";
        try {
            if (!StringUtils.isEmpty(distrib.getUid())) {
                distrib = distribService.getById(distrib.getUid());
                if (!"null".equals(distrib)) {
                    distrib.setUpdatedat(DateUtil.getCurrentTime());
                }
                return ReturnUtil.Success("加载成功", distrib, null);
            } else {
                return ReturnUtil.Error("沒有相关的ID", distrib, null);
            }
        } catch (Exception e) {
            return ReturnUtil.Error("获取配送单失败", distrib, null);
        }
    }


    @Transactional
    @RequestMapping(value = "/distribSave")
    @ResponseBody
    public Object save(Distrib distrib,HttpServletRequest request) {
        try {
            int regionID = 0;
            EmployeeNew employeeNew = getEmployeeByUser(request);
            if(employeeNew != null){
               if(employeeNew.getRegionID() != null){
                   regionID = employeeNew.getRegionID();
               }
            }
            distrib.setRegionId(regionID);
            distribService.appDistribSave(distrib);
            return ReturnUtil.Success("配送单生成成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("配送单生成失败", null, null);
        }
    }


    private Distrib timeEmptyToNull(Distrib distrib) {


        if ("".equals(distrib.getShipmentTime())) {
            distrib.setShipmentTime(null);
        }
        if ("".equals(distrib.getOrderBegin())) {
            distrib.setOrderBegin(null);
        }
        if ("".equals(distrib.getOrderEnd())) {
            distrib.setOrderEnd(null);
        }
        if ("".equals(distrib.getPickBegin())) {
            distrib.setPickBegin(null);
        }
        ;
        if ("".equals(distrib.getPickEnd())) {
            distrib.setPickEnd(null);
        }
        ;
        if ("".equals(distrib.getDataBegin())) {
            distrib.setDataBegin(null);
        }
        ;
        if ("".equals(distrib.getDataEnd())) {
            distrib.setDataEnd(null);
        }
        ;
        if ("".equals(distrib.getDistribCheckBegin())) {
            distrib.setDistribCheckBegin(null);
        }
        ;
        if ("".equals(distrib.getDistribCheckEnd())) {
            distrib.setDistribCheckEnd(null);
        }
        ;
        if ("".equals(distrib.getDistribPackBegin())) {
            distrib.setDistribPackBegin(null);
        }
        ;
        if ("".equals(distrib.getDistribPackEnd())) {
            distrib.setDistribPackEnd(null);
        }
        ;
        if ("".equals(distrib.getDistribBegin())) {
            distrib.setDistribBegin(null);
        }
        ;
        if ("".equals(distrib.getDistribEnd())) {
            distrib.setDistribEnd(null);
        }
        ;
        if ("".equals(distrib.getSendoutTime())) {
            distrib.setSendoutTime(null);
        }
        ;
        if ("".equals(distrib.getArrivalTime())) {
            distrib.setArrivalTime(null);
        }
        ;

        if ("".equals(distrib.getCreatedat())) {
            distrib.setCreatedat(null);
        }
        ;

        return distrib;
    }


    /**
     * 回写对应配送单据的回收状态
     */
    private void reWriteDistribState(String no) {
        if (StringUtils.isNotEmpty(no)) {
            Distrib distrib = new Distrib();
            distrib.setDistribNum(no);
            List<Distrib> distribList = distribService.selectUnRecovery(distrib);
            if (distribList.size() > 0) {
                Distrib distribnew = distribList.get(0);
                distribnew.setRecovery(1);
                distribService.save(distribnew);
            }
        }
    }


    /**
     * 获取调货单列表
     *
     * @param transferInfo
     * @return
     */
    @RequestMapping("/getAllTransferInfoList")
    public Object getAllTransferInfoList(TransferInfo transferInfo) {
        List<TransferInfo> Lists = transferService.getAllTransferInfoWithNoDone(transferInfo);
        return ReturnUtil.Success("加载成功", Lists, null);
    }

    /**
     * 根据最新的需求  市场人员需要根据
     *
     * @param transferInfo
     * @return
     */
    @RequestMapping("/getAllTransferInfoByRegionID")
    public Object getAllTransferInfoByRegionID(TransferInfo transferInfo,HttpServletRequest request) {

        List<TransferInfo> transferInfos = transferService.getAllTransferInfoByRegionID(transferInfo,getUid(request));
        return ReturnUtil.Success("加载成功", transferInfos, null);
    }


    /**
     * 根据ID 获取调货单详情页面
     *
     * @param transferInfo
     * @return
     */
    @RequestMapping("/getTransferInfoDetail")
    public Object getTransferInfoDetail(TransferInfo transferInfo) {
        try {
            if (transferInfo.getId() != null) {
                transferInfo = transferService.getById(transferInfo.getId());

                return ReturnUtil.Success("加载成功", transferInfo, null);
            }
            return ReturnUtil.Error("沒有相关的ID", transferInfo, null);
        } catch (Exception e) {
            return ReturnUtil.Error("获取调货单详情失败", transferInfo, null);
        }

    }

    @Transactional
    @RequestMapping(value = "/transferInfoSave", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(@Valid TransferInfo transferInfo, BindingResult result) {
        if (result.hasErrors()) {
//            for (ObjectError er : result.getAllErrors()) return ReturnUtil.Error(er.getDefaultMessage(), null, null);
            ReturnUtil.Error("调货流程生成失败", null, null);
        }
        try {
            if (transferInfo.getId() == null) {
                transferInfo.setUid(UuidUtil.getUUID());
                transferInfo.setCreatetime(DateUtil.getSysTime());
                transferInfo.setModifytime(DateUtil.getSysTime());
                transferInfo.setState(1);
                transferService.insert(transferInfo);
            } else {
                transferService.appUpdate(transferInfo);
            }
            return ReturnUtil.Success("调货单生成成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("调货单生成失败", null, null);
        }
    }

    @RequestMapping(value = "/getAllEmpsByDept")
    @ResponseBody
    public Object getAllEmpsByDept(Integer type) {
        Map<String, Object> map = new HashMap<>();
        List<EmployeeNew> employeeNewList = employeeNewService.getAllEmpsByDepartment(type);
        map.put("emplist", employeeNewList);
        return ReturnUtil.Success("加载成功", map, null);
    }

    /**
     * 回写对应调货单据的回收状态
     */
    private void reWriteTransferState(String no) {
        if (StringUtils.isNotEmpty(no)) {
            TransferInfo transferInfo = new TransferInfo();
            transferInfo.setBizno(no);
            List<TransferInfo> transferInfoList = transferService.selectUnRecovery(transferInfo);
            if (transferInfoList.size() > 0) {
                TransferInfo transferInfoNew = transferInfoList.get(0);
                transferInfoNew.setRecovery(1);
                transferService.save(transferInfoNew);
            }
        }
    }

    private void authLoginByUserToken(Subject user, UsernamePasswordToken token, String username) {

        try {
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
            user.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
        } catch (AuthenticationException ae) {
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
        }
    }

}
