package com.geekcattle.service.console;

import com.geekcattle.mapper.HospitalMapper;
import com.geekcattle.mapper.console.DepartmentMapper;
import com.geekcattle.model.Hospital;
import com.geekcattle.model.console.Department;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.util.CamelCaseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    public List<Hospital> getAllHospital(Hospital hospital) {
        //PageHelper.offsetPage(hospital.getOffset(), hospital.getLimit(), CamelCaseUtil.toUnderlineName(hospital.getSort()) + " " + hospital.getOrder());
        return hospitalMapper.getAllHospital(hospital);
    }
    public List<Hospital> getAllHospitalByRegionID(Hospital hospital) {
        //PageHelper.offsetPage(hospital.getOffset(), hospital.getLimit(), CamelCaseUtil.toUnderlineName(hospital.getSort()) + " " + hospital.getOrder());
        return hospitalMapper.getAllHospitalByRegionID(hospital);
    }

    public Hospital getHospitalByName(String hosname){
        return hospitalMapper.getHospitalByName(hosname);
    }


}
