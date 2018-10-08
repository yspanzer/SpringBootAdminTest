/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.controller.console;

import com.geekcattle.constant.Constant;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.model.console.Role;
import com.geekcattle.service.console.AdminRoleService;
import com.geekcattle.service.console.DistribService;
import com.geekcattle.service.console.EmployeeNewService;
import com.geekcattle.service.console.RoleService;
import com.geekcattle.util.*;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.geekcattle.core.shiro.AdminShiroUtil.getUserInfo;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:58
 */
@Controller
@RequestMapping("/console/distrib")
public class DistribController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DistribService distribService;
    @Autowired
    private EmployeeNewService employeeNewService;


//    @RequiresPermissions("distrib:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/distrib/index";
    }

    @RequiresPermissions("distrib:edit")
    @RequestMapping(value = "/form", method = {RequestMethod.GET})
    public String from(Distrib distrib, Model model) {
        String checkRoleId = "";
        if (!StringUtils.isEmpty(distrib.getUid())) {
            distrib = distribService.getById(distrib.getUid());
            if (!"null".equals(distrib)) {
                distrib.setUpdatedat(DateUtil.getCurrentTime());
            }
        }else {
        }
        model.addAttribute("distrib", distrib);
        return "/console/distrib/form";
    }


    @RequiresPermissions("distrib:edit")
    @RequestMapping(value = "/formlayer", method = {RequestMethod.GET})
    public String fromlayer(Distrib distrib, Model model) {
        String checkRoleId = "";
        if (!StringUtils.isEmpty(distrib.getUid())) {
            distrib = distribService.getById(distrib.getUid());
            if (!"null".equals(distrib)) {
                distrib.setUpdatedat(DateUtil.getCurrentTime());
            }
        }else {
        }
        model.addAttribute("distrib", distrib);
        return "/console/distrib/formlayer";
    }

/*    private List<Distrib> getDistribList() {
        ModelMap map = new ModelMap();
        List<Distrib> DistribList = distribService

        .getFromAll();
        return DistribList;
    }*/

//    @RequiresPermissions("distrib:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Distrib distrib) {
        ModelMap map = new ModelMap();
        List<Distrib> Lists = distribService.getPageList(distrib);
        map.put("pageInfo", new PageInfo<Distrib>(Lists));
        map.put("queryParam", distrib);
        return ReturnUtil.Success("加载成功", map, null);
    }


//    @RequiresPermissions("distrib:index")
    @RequestMapping(value = "/listrole", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap listRole(Distrib distrib) {

        int id = employeeNewService.getEmployIdByName("");
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        List<Integer> list = new ArrayList<>();
        Admin admin = getUserInfo();
        List<Role> rolelist = roleService.selectRoleListByAdminId(admin.getUid());

/*       if(rolelist != null){
           for (Role role : rolelist) {
               if (role.getRoleName().equals(Constant.ROLE_DISTRIBUTE_ENTER)){
                   // 1-13都是单据的状态量
                   list.add(1);
                   list.add(2);
                   list.add(3);
                   list.add(4);
                   list.add(5);
                   list.add(6);
                   list.add(7);
                   list.add(8);
                   list.add(9);
                   list.add(10);
                   list.add(11);
                   list.add(12);
                   list.add(13);//结束状态
               }
            *//*if (role.getRoleName().equals("数据部数据")){
                list.add(1);
            }
            if (role.getRoleName().equals("仓储配货复核")){
                list.add(2);
            }
            if (role.getRoleName().equals("配送物流数据")){
                list.add(3);
                list.add(4);
                //list.add(5);
            }*//*
           }
       }*/
       //todo 这段是假数据
  /*      if(list.size()==0){
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(7);
            list.add(8);
            list.add(9);
            list.add(10);
            list.add(11);
            list.add(12);
            list.add(13);
        }
        params.put("list",list);*/
        params.put("offset",distrib.getOffset());
        params.put("limit",distrib.getLimit());



        List<Distrib> Lists = distribService.getPageListByRole(distrib);
        map.put("pageInfo", new PageInfo<Distrib>(Lists));
        map.put("queryParam", distrib);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequestMapping(value = "/getAllDistribs", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap getAllDistribs(Distrib distrib) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",distrib.getOffset());
        params.put("limit",distrib.getLimit());
        List<Distrib> Lists = distribService.getAllDistribs(distrib);
        map.put("pageInfo", new PageInfo<Distrib>(Lists));
        map.put("queryParam", distrib);
        return ReturnUtil.Success("加载成功", map, null);
    }

    @RequestMapping(value = "/selectRecoveryed", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectRecoveryed(Distrib distrib) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        params.put("offset",distrib.getOffset());
        params.put("limit",distrib.getLimit());
        List<Distrib> distribLists = distribService.selectRecoveryed(distrib);
        map.put("pageInfo", new PageInfo<Distrib>(distribLists));
        map.put("queryParam", distribLists);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @RequestMapping(value = "/selectUnRecovery", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap selectUnRecovery(Distrib distrib) {
        HashMap<String,Object> params = new HashMap<>();
        ModelMap map = new ModelMap();
        distrib.setLimit(99999);
        params.put("offset",distrib.getOffset());
        params.put("limit",distrib.getLimit());
        List<Distrib> distribLists = distribService.selectUnRecovery(distrib);
        map.put("pageInfo", new PageInfo<Distrib>(distribLists));
        map.put("queryParam", distribLists);
        return ReturnUtil.Success("加载成功", map, null);
    }


    @Transactional
//    @RequiresPermissions("distrib:save")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public ModelMap save(@Valid Distrib distrib, BindingResult result) {
        if (result.hasErrors()) {
//            for (ObjectError er : result.getAllErrors()) return ReturnUtil.Error(er.getDefaultMessage(), null, null);
            ReturnUtil.Error("配送流程生成失败", null, null);
        }
        try {
            if (StringUtils.isEmpty(distrib.getUid())) {
                distrib.setUid(UuidUtil.getUUID());
                distrib.setCreatedat(DateUtil.getCurrentTime());
                distrib.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(distrib);
                distrib.setState(1);
                distrib.setStatus(0);
                distrib.setRecovery(0);//回收默认值
                distribService.insert(distrib);
            } else {
                distrib.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(distrib);
                distrib.setState(distrib.getState()+1);
                distrib.setStatus(0);
                distribService.save(distrib);
            }
            return ReturnUtil.Success("配送单生成成功", null, "/console/distrib/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("配送单生成失败", null, null);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteRow(String uid){
        String msg = "删除成功";
        boolean success = true;
        Map<String,Object> map = new HashMap<>();
        Admin admin = getUserInfo();
        if(admin != null){
            if(!admin.getUsername().equals("admin")){
                msg = "你没有权限删除";
                success = false;
                map.put("success",success);
                map.put("msg",msg);
                return map;
            }
        }

        try {
            distribService.deleteRow(uid);
        } catch (Exception e) {
            msg = "删除失败";
            success = false;
            e.printStackTrace();
        }
        map.put("success",success);
        map.put("msg",msg);
        return map;
    }




    @RequiresPermissions("distrib:delete")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap delete(String[] ids) {
        try {
            if (ids != null) {
                if (StringUtils.isNotBlank(ids.toString())) {
                    for (String id : ids) {
                        //adminRoleService.deleteAdminId(id);
                        distribService.deleteById(id);
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


        @RequestMapping(value = "/excel", method = RequestMethod.GET)
        @ResponseBody
        public void excel(HttpServletResponse response,Distrib distrib) throws Exception {
            //根据参数查询数据集
            distrib.setLimit(999);
            List<Distrib> Lists = distribService.getPageListByRole(distrib);

            String dateNow = getDate();

            Map<String, String> map = new HashMap<String, String>();
            map.put("title", "配送信息表");
            map.put("total", Lists.size()+" 条");
            map.put("date", getDate());

            ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "配送单据导出模板.xls", new FileOutputStream("D:/未完成配送导出"+dateNow+".xls"),
                    Lists, Distrib.class, true);

            /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/未完成配送导出"+dateNow+".xls"),
                    Lists, Distrib.class, true);*/
        }


        @RequestMapping(value = "/excel2", method = RequestMethod.GET)
        @ResponseBody
        public void excel2(HttpServletResponse response,Distrib distrib) throws Exception {
            //根据参数查询数据集
            distrib.setLimit(999);
            List<Distrib> Lists = distribService.getAllDistribs(distrib);
                    //distribService.getPageListByRole(distrib);

            String dateNow = getDate();

            Map<String, String> map = new HashMap<String, String>();
            map.put("title", "配送信息表");
            map.put("total", Lists.size()+" 条");
            map.put("date", getDate());

            ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "配送单据导出模板.xls", new FileOutputStream("D:/已完成配送导出"+dateNow+".xls"),
                    Lists, Distrib.class, true);
            /*ExcelUtil.getInstance().exportObj2Excel(new FileOutputStream("D:/已完成配送导出"+dateNow+".xls"),
                    Lists, Distrib.class, true);*/
        }


        private String getDate() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format(new Date());
        }


    private Distrib timeEmptyToNull(Distrib distrib){


        if("".equals(distrib.getShipmentTime())){
            distrib.setShipmentTime(null);
        }
        if("".equals(distrib.getOrderBegin())){
            distrib.setOrderBegin(null);
        }
        if("".equals(distrib.getOrderEnd())){
            distrib.setOrderEnd(null);
        }
        if("".equals(distrib.getPickBegin())){
            distrib.setPickBegin(null);
        };
        if("".equals(distrib.getPickEnd())){
            distrib.setPickEnd(null);
        };
        if("".equals(distrib.getDataBegin())){
            distrib.setDataBegin(null);
        };
        if("".equals(distrib.getDataEnd())){
            distrib.setDataEnd(null);
        };
        if("".equals(distrib.getDistribCheckBegin())){
            distrib.setDistribCheckBegin(null);
        };
        if("".equals(distrib.getDistribCheckEnd())){
            distrib.setDistribCheckEnd(null);
        };
        if("".equals(distrib.getDistribPackBegin())){
            distrib.setDistribPackBegin(null);
        };
        if("".equals(distrib.getDistribPackEnd())){
            distrib.setDistribPackEnd(null);
        };
        if("".equals(distrib.getDistribBegin())){
            distrib.setDistribBegin(null);
        };
        if("".equals(distrib.getDistribEnd())){
            distrib.setDistribEnd(null);
        };
        if("".equals(distrib.getSendoutTime())){
            distrib.setSendoutTime(null);
        };
        if("".equals( distrib.getArrivalTime())){
            distrib.setArrivalTime(null);
        };

        if("".equals(distrib.getCreatedat())){
            distrib.setCreatedat(null);
        };


        return distrib;
    }

}
