package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.EmployeeNew;
import com.geekcattle.util.CustomerMapper;

import java.util.List;

public interface EmployeeNewMapper extends CustomerMapper<EmployeeNew> {
    int getEmployIdByName(String empName);
    List<EmployeeNew> getAllEmpsByDepartment(int deptId);
    EmployeeNew getEmployeeByUserId(String uid);
    Admin getAdminByEmployeeId(int eid);
}