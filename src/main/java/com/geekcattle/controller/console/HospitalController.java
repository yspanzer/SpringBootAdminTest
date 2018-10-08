/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.controller.console;

import com.geekcattle.model.Hospital;
import com.geekcattle.model.basic.Employee;
import com.geekcattle.model.console.EmployeeNew;
import com.geekcattle.service.common.EmployeeService;
import com.geekcattle.service.console.EmployeeNewService;
import com.geekcattle.service.console.HospitalService;
import com.geekcattle.util.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:58
 */
@Controller
@RequestMapping("/console/hospital")
public class HospitalController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HospitalService hospitalService;


    /*@RequestMapping(value = "/getAllHosByRegion")
    @ResponseBody
    public Object getAllHosByRegion(Integer type) {
        Map<String, Object> map = new HashMap<>();
        List<Hospital> hospitalList = hospitalService.getAllHosByRegion(regionid);
        map.put("hoslist",hospitalList);
        return ReturnUtil.Success("加载成功", map, null);
    }*/

    @RequestMapping("/getAllHospital")
    @ResponseBody
    public Object getAllHospital (Hospital hospital){
        List<Hospital> hospitalList = hospitalService.getAllHospital(hospital);
        return hospitalList;
    }
    @RequestMapping("/getAllHospitalByRegionID")
    @ResponseBody
    public Object getAllHospitalByRegionID (Hospital hospital){
        List<Hospital> hospitalList = hospitalService.getAllHospitalByRegionID(hospital);
        return hospitalList;
    }

    @RequestMapping("/getHospitalByName")
    @ResponseBody
    public Object getHospitalByName (String  hosname){
        Hospital hospital = hospitalService.getHospitalByName(hosname);
        return hospital;
    }
}
