package com.geekcattle.controller.console;

import com.geekcattle.model.console.Distrib;
import com.geekcattle.model.console.Receipt;
import com.geekcattle.model.console.TransferInfo;
import com.geekcattle.service.console.TransferService;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ExcelUtil;
import com.geekcattle.util.ReturnUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/console/transfer","/api/member/transfer"})
public class TransferController {

    @Autowired
    private TransferService transferService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping("/index")
    public String index(){
        return "console/transfer/index";
    }


    @RequestMapping("/getAllTransferInfoWithNoDone")
    @ResponseBody
    public Object getAllTransferInfoWithNoDone(TransferInfo transferInfo){
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",transferInfo.getOffset());
        params.put("limit",transferInfo.getLimit());

        List<TransferInfo> transferInfoList = transferService.getAllTransferInfoWithNoDone(transferInfo);
        //System.out.println("");
        map.put("pageInfo", new PageInfo<TransferInfo>(transferInfoList));
        return ReturnUtil.Success("加载成功", map, null);
    }

    @RequestMapping("/selectUnRecovery")
    @ResponseBody
    public Object selectUnRecovery(TransferInfo transferInfo){
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        transferInfo.setLimit(99999);
        params.put("offset",transferInfo.getOffset());
        params.put("limit",transferInfo.getLimit());

        List<TransferInfo> transferInfoList = transferService.selectUnRecovery(transferInfo);
        //System.out.println("");
        map.put("pageInfo", new PageInfo<TransferInfo>(transferInfoList));
        map.put("transferInfoList",transferInfoList);
        return ReturnUtil.Success("加载成功", map, null);
    }

    @RequestMapping("/getAllTransferInfoeWithDone")
    @ResponseBody
    public Object getAllTransferInfoeWithDone(TransferInfo transferInfo){
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",transferInfo.getOffset());
        params.put("limit",transferInfo.getLimit());

        List<TransferInfo> transferInfoList = transferService.getAllTransferInfoeWithDone(transferInfo);
        //System.out.println("");
        map.put("pageInfo", new PageInfo<TransferInfo>(transferInfoList));
        return ReturnUtil.Success("加载成功", map, null);
    }

    @RequestMapping("/form")
    public String form(){
        return "console/transfer/form";
    }


    @Transactional
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public ModelMap save(@Valid TransferInfo transferInfo, BindingResult result) {
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
                transferInfo.setRecovery(0);//回收默认值
                transferService.insert(transferInfo);
            } else {
                TransferInfo transferInfoNew = transferService.getById(transferInfo.getId());
                transferInfoNew.setTransferman(transferInfo.getTransferman());
                transferInfoNew.setFetchGoodsMan(transferInfo.getFetchGoodsMan());
                transferInfoNew.setDataMan(transferInfo.getDataMan());
                transferInfoNew.setCheckMan(transferInfo.getCheckMan());
                transferInfoNew.setRecheckMan(transferInfo.getRecheckMan());
                transferInfoNew.setPackMan(transferInfo.getPackMan());
                transferInfoNew.setDeliveryMan(transferInfo.getDeliveryMan());
                //transferInfo.setState(transferInfo.getState()+1);
                //distrib.setStatus(0);
                transferService.update(transferInfoNew);
            }
            return ReturnUtil.Success("调货单生成成功", null, "/console/transfer/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("调货单生成失败", null, null);
        }
    }

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    @ResponseBody
    public void excel(HttpServletResponse response, TransferInfo transferInfo) throws Exception {
        //根据参数查询数据集
        transferInfo.setLimit(999);
        List<TransferInfo> transferInfoList = transferService.getAllTransferInfoWithNoDone(transferInfo);

        String dateNow = getDate();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "调货信息表");
        map.put("total", transferInfoList.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "调货单据导出模板.xls", new FileOutputStream("D:/未完成调货导出"+dateNow+".xls"),
                transferInfoList, TransferInfo.class, true);
        /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/未完成调货导出"+dateNow+".xls"),
                transferInfoList, TransferInfo.class, true);*/
    }


    @RequestMapping(value = "/excel2", method = RequestMethod.GET)
    @ResponseBody
    public void excel2(HttpServletResponse response,TransferInfo transferInfo) throws Exception {
        //根据参数查询数据集
        transferInfo.setLimit(999);
        List<TransferInfo> transferInfoList = transferService.getAllTransferInfoeWithDone(transferInfo);

        String dateNow = getDate();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "调货信息表");
        map.put("total", transferInfoList.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "调货单据导出模板.xls", new FileOutputStream("D:/已完成调货导出"+dateNow+".xls"),
                transferInfoList, TransferInfo.class, true);
        /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/已完成调货导出"+dateNow+".xls"),
                transferInfoList, TransferInfo.class, true);*/
    }


    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    @RequestMapping(value = "/formlayer", method = {RequestMethod.GET})
    public String fromlayer(TransferInfo transferInfo, Model model) {

        if (transferInfo.getId() != null) {
            transferInfo = transferService.getById(transferInfo.getId());
            if (transferInfo != null) {
                transferInfo.setModifytime(DateUtil.getSysTime());
            }
        }
        model.addAttribute("transferInfo", transferInfo);
        return "/console/transfer/formlayer";
    }

}
