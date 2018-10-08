package com.geekcattle.controller.console;

import com.geekcattle.service.console.DistribService;
import com.geekcattle.service.console.ReceiptService;
import com.geekcattle.service.console.TransferService;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ReturnUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/28.
 */
@Controller
@RequestMapping("/console/view")
public class ViewShowController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private DistribService distribService;

    @Autowired
    private TransferService transferService;

    @RequiresPermissions("view:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/view/index";
    }

    @RequestMapping(value = "/statisticsDate",method = RequestMethod.GET)
    @ResponseBody
    public ModelMap statisticsDate(HttpServletRequest request) {

        String startStr = request.getParameter("startStr");
        String endStr = request.getParameter("endStr");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(startStr == null){
            //获取前月的第一天
            Calendar   cal_1=Calendar.getInstance();//获取当前日期
//            cal_1.add(Calendar.MONTH, -1);
            cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
             startStr = format.format(cal_1.getTime());
        }
        if(endStr == null){
            endStr = format.format(new Date());
        }
        //获取当月天日期
        String[] categories = DateUtil.getCategories( startStr,  endStr);
        HashMap<String,String> keyMap = new HashMap<String,String>();
        keyMap.put("beginDate",startStr);
        keyMap.put("endDate",endStr);
        int[] receiptData = receiptService.getReceiptData(keyMap);
        int[] distribData = distribService.getDistribData(keyMap);
        int[] transferInfoData = transferService.getTransferInfoData(keyMap);;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("categories",categories);
        map.put("receiptData",receiptData);
        map.put("distribData",distribData);
        map.put("transferInfoData",transferInfoData);
        return ReturnUtil.Success("加载成功", map, null);
    }



}
