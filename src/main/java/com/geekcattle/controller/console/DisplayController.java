/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.controller.console;

import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.model.console.Role;
import com.geekcattle.service.console.AdminRoleService;
import com.geekcattle.service.console.DistribService;
import com.geekcattle.service.console.RoleService;
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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.geekcattle.core.shiro.AdminShiroUtil.getUserInfo;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:58
 */
@Controller
@RequestMapping("/console/display")
public class DisplayController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DistribService displayService;

    @RequiresPermissions("display:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/display/show";
    }

    @RequiresPermissions("display:edit")
    @RequestMapping(value = "/form", method = {RequestMethod.GET})
    public String from(Distrib display, Model model) {
        String checkRoleId = "";
        if (!StringUtils.isEmpty(display.getUid())) {
            display = displayService.getById(display.getUid());
            if (!"null".equals(display)) {
                display.setUpdatedat(DateUtil.getCurrentTime());
            }
        }else {
        }
        model.addAttribute("display", display);
        return "/console/display/form";
    }

/*    private List<Distrib> getDistribList() {
        ModelMap map = new ModelMap();
        List<Distrib> DistribList = displayService.getFromAll();
        return DistribList;
    }*/

    @RequiresPermissions("display:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Distrib display) {
        ModelMap map = new ModelMap();
        List<Distrib> Lists = displayService.getPageList(display);
        map.put("pageInfo", new PageInfo<Distrib>(Lists));
        map.put("queryParam", display);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequiresPermissions("display:index")
    @RequestMapping(value = "/listrole", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap listRole(Distrib display) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        List<Integer> list = new ArrayList<>();
        Admin admin = getUserInfo();
        List<Role> rolelist = roleService.selectRoleListByAdminId(admin.getUid());

        for (Role role : rolelist) {
            if (role.getRoleName().equals("配送单据录入")){
                list.add(1);
            }
            if (role.getRoleName().equals("数据部数据")){
                list.add(1);
            }
            if (role.getRoleName().equals("仓储配货复核")){
                list.add(2);
            }
            if (role.getRoleName().equals("配送物流数据")){
                list.add(3);
                list.add(4);
                list.add(5);
            }
        }

        params.put("list",list);
        List<Distrib> Lists = displayService.getPageListByRole(display);
        map.put("pageInfo", new PageInfo<Distrib>(Lists));
        map.put("queryParam", display);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @Transactional
    @RequiresPermissions("display:save")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody

    public ModelMap save(@Valid Distrib display, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError er : result.getAllErrors()) return ReturnUtil.Error(er.getDefaultMessage(), null, null);
        }
        try {
            if (StringUtils.isEmpty(display.getUid())) {
                display.setUid(UuidUtil.getUUID());
                display.setCreatedat(DateUtil.getCurrentTime());
                display.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(display);
                display.setState(1);
                displayService.insert(display);
            } else {
                display.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(display);
                display.setState(display.getState()+1);
                displayService.save(display);
            }
            return ReturnUtil.Success("操作成功", null, "/console/display/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败", null, null);
        }
    }



    @RequiresPermissions("display:delete")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap delete(String[] ids) {
        try {
            if (ids != null) {
                if (StringUtils.isNotBlank(ids.toString())) {
                    for (String id : ids) {
                        //adminRoleService.deleteAdminId(id);
                        displayService.deleteById(id);
                    }
                }
                return ReturnUtil.Success("删除成功", null, null);
            } else {
                return ReturnUtil.Error("删除失败", null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("删除失败", null, null);
        }
    }

    public Distrib timeEmptyToNull(Distrib display){
        if(display.getShipmentTime().isEmpty()){
            display.setShipmentTime(null);
        };
        if(display.getOrderBegin().isEmpty()){
            display.setOrderBegin(null);
        };
        if(display.getOrderEnd().isEmpty()){
            display.setOrderEnd(null);
        };
        if(display.getDataBegin().isEmpty()){
            display.setDataBegin(null);
        };
        if(display.getDataEnd().isEmpty()){
            display.setDataEnd(null);
        };
        if(display.getDistribCheckBegin().isEmpty()){
            display.setDistribCheckBegin(null);
        };
        if(display.getDistribCheckEnd().isEmpty()){
            display.setDistribCheckEnd(null);
        };
        if(display.getDistribBegin().isEmpty()){
            display.setDistribBegin(null);
        };
        if(display.getDistribEnd().isEmpty()){
            display.setDistribEnd(null);
        };
        if(display.getSendoutTime().isEmpty()){
            display.setSendoutTime(null);
        };

        return display;
    };

}
