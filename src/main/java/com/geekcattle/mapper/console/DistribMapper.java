package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Distrib;
import com.geekcattle.util.CustomerMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DistribMapper extends CustomerMapper<Distrib> {
    List<Distrib> selectByRole(Distrib distrib);
    List<Distrib> selectRecoveryed(Distrib distrib);
    List<Distrib> selectUnRecovery(Distrib distrib);
    List<Distrib> getAllDistribs(Distrib distrib);
    List<HashMap<String, Integer>> getViewShowData(Map<String, String> keyMap);
    List<Distrib> getAllDistribsByRegionID(int regionID);
}