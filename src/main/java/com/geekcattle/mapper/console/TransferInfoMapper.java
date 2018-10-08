package com.geekcattle.mapper.console;

import com.geekcattle.model.console.TransferInfo;
import com.geekcattle.util.CustomerMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TransferInfoMapper extends CustomerMapper<TransferInfo> {

     List<TransferInfo> getAllTransferInfoeWithDone(TransferInfo transferInfo);
     List<TransferInfo> getAllTransferInfoWithNoDone(TransferInfo transferInfo);
     List<TransferInfo> selectUnRecovery(TransferInfo transferInfo);
     List<HashMap<String, Integer>> getViewShowData(Map<String, String> keyMap);
     List<TransferInfo> getAllTransferInfoByRegionID(int regionID);

}