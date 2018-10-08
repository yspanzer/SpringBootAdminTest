package com.geekcattle.service.console;

import com.geekcattle.mapper.HospitalMapper;
import com.geekcattle.mapper.RegionMapper;
import com.geekcattle.mapper.console.EmployeeNewMapper;
import com.geekcattle.mapper.console.UserEmpMapper;
import com.geekcattle.model.Hospital;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.EmployeeNew;
import com.geekcattle.model.console.UserEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeNewService {

    @Autowired
    EmployeeNewMapper employeeNewMapper;
    @Autowired
    UserEmpMapper userEmpMapper;
    @Autowired
    RegionMapper regionMapper;
    @Autowired
    HospitalMapper hospitalMapper;

    public String getEmployNameById(int empId){

       EmployeeNew employeeNew = employeeNewMapper.selectByPrimaryKey(empId);

       if(employeeNew != null){
           return employeeNew.getEmpName();
       }

        return null;
    }

    public int getEmployIdByName(String empName){

        return  employeeNewMapper.getEmployIdByName("玉宁");

    }

    public List<EmployeeNew> getAllEmpsByDepartment(int deptId){

        List<EmployeeNew> employeeNewList = new ArrayList<>();
        employeeNewList = employeeNewMapper.getAllEmpsByDepartment(deptId);
        return employeeNewList;
    }

    public EmployeeNew getEmployeeByUserId(String uid){
        return employeeNewMapper.getEmployeeByUserId(uid);
    }

    public Admin getAdminByEmployeeId(int eid){
        return employeeNewMapper.getAdminByEmployeeId(eid);
    }

    public List<EmployeeNew> getAllEmps(){
        return employeeNewMapper.selectAll();
    }

    public void insert(Integer empId,String uid){
        UserEmp userEmp = new UserEmp();
        userEmp.setEmpId(empId);
        userEmp.setUserId(uid);
        userEmpMapper.insert(userEmp);
    }

}
