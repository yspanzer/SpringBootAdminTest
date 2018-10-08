package com.geekcattle.mapper.console;

import com.geekcattle.model.console.Receipt;
import com.geekcattle.util.CustomerMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReceiptMapper extends CustomerMapper<Receipt> {
   List<Receipt> getAllReceipts(Receipt receipt);
   List<Receipt> getAllReceiptsWithFullState(Receipt receipt);

   List<HashMap<String, Integer>> getViewShowData(Map<String, String> keyMap);

   List<Receipt> getAllReceiptsByRegionID(int regionID);

}