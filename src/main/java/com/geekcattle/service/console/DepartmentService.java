package com.geekcattle.service.console;

import com.geekcattle.mapper.console.DepartmentMapper;
import com.geekcattle.model.console.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepartmentByID(int did){

        return departmentMapper.selectByPrimaryKey(did);
    }

    public Department getDepartmentByEmpID(int eid){
        return departmentMapper.getDeparmentByEmpID(eid);
    }
}
