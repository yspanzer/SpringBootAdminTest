/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.controller.console;

import com.geekcattle.core.shiro.AdminShiroUtil;
import com.geekcattle.model.console.*;
import com.geekcattle.service.console.*;
import com.geekcattle.util.*;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.geekcattle.core.shiro.AdminShiroUtil.getUserInfo;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:58
 */
@Controller
@RequestMapping("/console/receipt")
public class ReceiptController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


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


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequiresPermissions("receipt:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/receipt/index";
    }

//    @RequiresPermissions("receipt:edit")
    @RequestMapping(value = "/form", method = {RequestMethod.GET})
    public String from(Receipt receipt, Model model) {

        if (receipt.getId() != null) {
            receipt = receiptService.getById(receipt.getId());
            if (receipt != null) {
                receipt.setUpdatedat(DateUtil.getSysTime());
            }
        }
        model.addAttribute("receipt", receipt);
        return "/console/receipt/form";
    }


    @RequiresPermissions("receipt:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Receipt receipt) {
        ModelMap map = new ModelMap();
        List<Receipt> Lists = receiptService.getPageList(receipt);
        map.put("pageInfo", new PageInfo<Receipt>(Lists));
        map.put("queryParam", receipt);
        return ReturnUtil.Success("加载成功", map, null);
    }


//    @RequiresPermissions("receipt:index")
    @RequestMapping(value = "/listrole", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap listRole(Receipt receipt) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        List<Integer> list = new ArrayList<>();
        Admin admin = getUserInfo();
        List<Role> rolelist = roleService.selectRoleListByAdminId(admin.getUid());

        for (Role role : rolelist) {
            if (role.getRoleName().equals("收货数据录入")){
                list.add(1);
            }
            if (role.getRoleName().equals("配送接货")){
                list.add(1);
            }
            if (role.getRoleName().equals("采购仓储验退")){
                list.add(2);
            }
            if (role.getRoleName().equals("采购仓储验核")){
                list.add(3);
            }
            if (role.getRoleName().equals("采购数据验退")){
                list.add(4);
            }
            if (role.getRoleName().equals("仓储上架")){
                list.add(5);
                list.add(6);
                //list.add(7);
            }
        }

        params.put("list",list);
        List<Receipt> Lists = receiptService.getPageListByRole(params);
        map.put("pageInfo", new PageInfo<Receipt>(Lists));
        map.put("queryParam", receipt);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @Transactional
//    @RequiresPermissions("receipt:save")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public ModelMap save( Receipt receipt, BindingResult result) {

        try {
//            if (StringUtils.isEmpty(receipt.getUid())) {
            if (receipt.getId() == null) {
                receipt.setUid(UuidUtil.getUUID());
                receipt.setCreatedat(DateUtil.getSysTime());
                receipt.setUpdatedat(DateUtil.getSysTime());
                receipt.setState(1);
                receiptService.insert(receipt);
                //回写对应配送单据的回收状态
                if(receipt.getDistribno() != null){
                    Distrib distrib = new Distrib();
                    distrib.setDistribNum(receipt.getDistribno());
                    List<Distrib> distribList = distribService.selectUnRecovery(distrib);
                    if(distribList.size() > 0){
                    Distrib distribnew = distribList.get(0);
                    distribnew.setRecovery(1);
                    distribService.save(distribnew);}
                }
                //回写对应调回单据的回收状态
                if(receipt.getTransferno() != null){
                    TransferInfo transferInfo = new TransferInfo();
                    transferInfo.setBizno(receipt.getTransferno());
                    List<TransferInfo> transferInfoList = transferService.selectUnRecovery(transferInfo);
                    if(transferInfoList.size()>0){
                    TransferInfo transferInfoNew = transferInfoList.get(0);
                    transferInfoNew.setRecovery(1);
                    transferService.save(transferInfoNew);
                    }
                }
            } else {

                Receipt receiptNew = receiptService.getById(receipt.getId());
                receiptNew.setReceiptNum(receipt.getReceiptNum());
                receiptNew.setReceiptMan(receipt.getReceiptMan());
                receiptNew.setAccepBackMan(receipt.getAccepBackMan());
                receiptNew.setAccepCheckMan(receipt.getAccepCheckMan());
                receiptNew.setAccepReMan(receipt.getAccepReMan());
                receiptNew.setTallyMan(receipt.getTallyMan());
                receiptService.update(receiptNew);
             /* receiptNew.setReceiptTimeBegin(DateUtil.getSysTime());//收货开始时间
                receiptNew.setUpdatedat(DateUtil.getSysTime());
                receiptNew.setState(receiptNew.getState()+1);
                receiptService.save(receiptNew);*/
            }
            return ReturnUtil.Success("操作成功", null, "/console/receipt/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败", null, null);
        }
    }


    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    @ResponseBody
    public void excel(HttpServletResponse response, Receipt receipt) throws Exception {
        //根据参数查询数据集
        List<Receipt> receiptList = receiptService.getAllReceipts(receipt);

        String dateNow = getDate();

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "收货信息表");
        map.put("total", receiptList.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "收货单据导出模板.xls", new FileOutputStream("D:/未完成收货导出"+dateNow+".xls"),
                receiptList, Receipt.class, true);
        /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/未完成收货导出"+dateNow+".xls"),
                receiptList, Receipt.class, true);*/
    }


    @RequestMapping(value = "/excel2", method = RequestMethod.GET)
    @ResponseBody
    public void excel2(HttpServletResponse response,Receipt receipt) throws Exception {
        //根据参数查询数据集
        List<Receipt> receiptList = receiptService.getAllReceiptsWithFullState(receipt);

        String dateNow = getDate();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "收货信息表");
        map.put("total", receiptList.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "收货单据导出模板.xls", new FileOutputStream("D:/已完成收货导出"+dateNow+".xls"),
                receiptList, Receipt.class, true);


        /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/已完成收货导出"+dateNow+".xls"),
                receiptList, Receipt.class, true);*/
    }


    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    //todo 以下都是我写的新的方法

    @RequestMapping(value = "/getAllReceipts", method = {RequestMethod.GET})
    @ResponseBody
    public Object getAllReceipts(Receipt receipt) {
        Map<String,Object> map = new HashMap<>();
        List<Receipt> receiptList = receiptService.getAllReceipts(receipt);
        System.out.println("");
        map.put("pageInfo", new PageInfo<Receipt>(receiptList));
        return ReturnUtil.Success("加载成功", map, null);
    }
    @RequestMapping(value = "/getAllReceiptsWithFullState", method = {RequestMethod.GET})
    @ResponseBody
    public Object getAllReceiptsWithFullState(Receipt receipt) {
        Map<String,Object> map = new HashMap<>();
        List<Receipt> receiptList = receiptService.getAllReceiptsWithFullState(receipt);
        System.out.println("");
        map.put("pageInfo", new PageInfo<Receipt>(receiptList));
        return ReturnUtil.Success("加载成功", map, null);
    }

    @RequestMapping(value = "/formlayer", method = {RequestMethod.GET})
    public String fromlayer(Receipt receipt, Model model) {

        if (receipt.getId() != null) {
            receipt = receiptService.getById(receipt.getId());
            if (receipt != null) {
                receipt.setUpdatedat(DateUtil.getSysTime());
            }
        }
        model.addAttribute("receipt", receipt);
        return "/console/receipt/formlayer";
    }


}
