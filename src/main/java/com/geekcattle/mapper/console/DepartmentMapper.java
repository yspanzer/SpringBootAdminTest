package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Department;
import com.geekcattle.util.CustomerMapper;

public interface DepartmentMapper extends CustomerMapper<Department> {

   Department  getDeparmentByEmpID(int empId);
}