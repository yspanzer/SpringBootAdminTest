/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.mapper.basic.BillnoMapper;
import com.geekcattle.mapper.console.DistribMapper;
import com.geekcattle.mapper.console.DistribReceiptMapper;
import com.geekcattle.mapper.console.TransferReceiptMapper;
import com.geekcattle.model.basic.Billno;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.model.console.DistribReceipt;
import com.geekcattle.model.console.TransferReceipt;
import com.geekcattle.util.CamelCaseUtil;
import com.geekcattle.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:43
 */
@Service
public class DistribReceiptService {



    @Autowired
    private DistribReceiptMapper distribReceiptMapper;

    @Autowired
    private TransferReceiptMapper transferReceiptMapper;



/*    public Integer getCount(Example example) {
        return distribReceiptMapper.selectCountByExample(example);
    }*/


    public List<DistribReceipt> selectRecoveryed(DistribReceipt distribReceipt){
        PageHelper.offsetPage(distribReceipt.getOffset(), distribReceipt.getLimit(), "createdat desc");
        return distribReceiptMapper.selectRecoveryed(distribReceipt);
    }

    public List<DistribReceipt> selectUnRecovery(DistribReceipt distribReceipt){
        PageHelper.offsetPage(distribReceipt.getOffset(), distribReceipt.getLimit(), "createdat desc");
        return distribReceiptMapper.selectUnRecovery(distribReceipt);
    }

    public List<TransferReceipt> selectRecoveryedTR(TransferReceipt transferReceipt){
        PageHelper.offsetPage(transferReceipt.getOffset(), transferReceipt.getLimit(), "createtime desc");
        return transferReceiptMapper.selectRecoveryed(transferReceipt);
    }

    public List<TransferReceipt> selectUnRecoveryTR(TransferReceipt transferReceipt){
        PageHelper.offsetPage(transferReceipt.getOffset(), transferReceipt.getLimit(), "createtime desc");
        return transferReceiptMapper.selectUnRecovery(transferReceipt);
    }



}
