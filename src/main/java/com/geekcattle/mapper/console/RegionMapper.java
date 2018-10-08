package com.geekcattle.mapper;

import com.geekcattle.model.Region;
import com.geekcattle.util.CustomerMapper;

public interface RegionMapper extends CustomerMapper<Region> {
     Region getRegionByHospitalID(int hid);
}