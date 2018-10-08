package com.geekcattle.mapper;

import com.geekcattle.model.Hospital;
import com.geekcattle.util.CustomerMapper;

import java.util.List;

public interface HospitalMapper extends CustomerMapper<Hospital> {
    Hospital getHospitalByName(String hosname);
    List<Hospital> getAllHospital(Hospital hospital);
    List<Hospital> getAllHospitalByRegionID(Hospital hospital);

    }
