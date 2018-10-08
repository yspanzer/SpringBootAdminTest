/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.controller.console;

import com.geekcattle.model.console.*;
import com.geekcattle.service.console.*;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ReturnUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.geekcattle.core.shiro.AdminShiroUtil.getUserInfo;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:58
 */
@Controller
@RequestMapping("/console/distribrecovery")
public class DistribRecoveryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DistribReceiptService distribReceiptService;


    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/distribrecovery/index";
    }


    @RequestMapping(value = "/selectRecoveryed", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectRecoveryed(DistribReceipt distribReceipt) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",distribReceipt.getOffset());
        params.put("limit",distribReceipt.getLimit());
        List<DistribReceipt> distribReceiptList = distribReceiptService.selectRecoveryed(distribReceipt);
        map.put("pageInfo", new PageInfo<DistribReceipt>(distribReceiptList));
        map.put("queryParam", distribReceiptList);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequestMapping(value = "/selectUnRecovery", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectUnRecovery(DistribReceipt distribReceipt) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",distribReceipt.getOffset());
        params.put("limit",distribReceipt.getLimit());
        List<DistribReceipt> distribReceiptList = distribReceiptService.selectUnRecovery(distribReceipt);
        map.put("pageInfo", new PageInfo<DistribReceipt>(distribReceiptList));
        map.put("queryParam", distribReceiptList);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequestMapping(value = "/selectRecoveryedTR", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectRecoveryedTR(TransferReceipt transferReceipt) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",transferReceipt.getOffset());
        params.put("limit",transferReceipt.getLimit());
        List<TransferReceipt> transferReceiptList = distribReceiptService.selectRecoveryedTR(transferReceipt);
        map.put("pageInfo", new PageInfo<TransferReceipt>(transferReceiptList));
        map.put("queryParam", transferReceiptList);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequestMapping(value = "/selectUnRecoveryTR", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectUnRecoveryTR(TransferReceipt transferReceipt) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",transferReceipt.getOffset());
        params.put("limit",transferReceipt.getLimit());
        List<TransferReceipt> transferReceiptList = distribReceiptService.selectUnRecoveryTR(transferReceipt);
        map.put("pageInfo", new PageInfo<TransferReceipt>(transferReceiptList));
        map.put("queryParam", transferReceiptList);
        return ReturnUtil.Success("加载成功", map, null);
    }


}
