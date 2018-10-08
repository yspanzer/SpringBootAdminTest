package com.geekcattle.service.console;

import com.geekcattle.mapper.RegionMapper;
import com.geekcattle.mapper.console.DepartmentMapper;
import com.geekcattle.model.Region;
import com.geekcattle.model.console.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionMapper regionMapper;

    public Region getDepartmentByID(int rid){

        return regionMapper.selectByPrimaryKey(rid);
    }

    public Region getRegionByHospitalID(int hid){
        return regionMapper.getRegionByHospitalID(hid);
    }
}
