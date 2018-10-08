package com.geekcattle.mapper.console;

import com.geekcattle.model.console.TransferReceipt;
import com.geekcattle.util.CustomerMapper;

import java.util.List;

public interface TransferReceiptMapper extends CustomerMapper<TransferReceipt> {
    List<TransferReceipt> selectRecoveryed(TransferReceipt transferReceipt);
    List<TransferReceipt> selectUnRecovery(TransferReceipt transferReceipt);
}