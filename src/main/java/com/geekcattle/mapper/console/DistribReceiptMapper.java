package com.geekcattle.mapper.console;

import com.geekcattle.model.console.DistribReceipt;
import com.geekcattle.util.CustomerMapper;

import java.util.List;

public interface DistribReceiptMapper extends CustomerMapper<DistribReceipt> {
    List<DistribReceipt> selectRecoveryed(DistribReceipt distribReceipt);
    List<DistribReceipt> selectUnRecovery(DistribReceipt distribReceipt);
}