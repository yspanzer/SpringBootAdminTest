/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.mapper.basic.BillnoMapper;
import com.geekcattle.mapper.console.ReceiptMapper;
import com.geekcattle.model.Region;
import com.geekcattle.model.console.Admin;
import com.geekcattle.model.console.Receipt;

import com.geekcattle.model.basic.Billno;
import com.geekcattle.model.console.Receipt;
import com.geekcattle.util.CamelCaseUtil;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.UserUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:43
 */
@Service
public class ReceiptService {

    @Autowired
    private ReceiptMapper receiptMapper;

    @Autowired
    private BillnoMapper billnoMapper;
    @Autowired
    private AdminService adminService;

/*    @Autowired
    private RoleService roleService;*/

    public List<Receipt> getPageList(Receipt receipt) {
        PageHelper.offsetPage(receipt.getOffset(), receipt.getLimit(), CamelCaseUtil.toUnderlineName(receipt.getSort()) + " " + receipt.getOrder());
        return receiptMapper.selectAll();
    }

    public List<Receipt> getPageListByRole(HashMap params) {
        //PageHelper.offsetPage(receipt.getOffset(), receipt.getLimit(), CamelCaseUtil.toUnderlineName(receipt.getSort())+" "+receipt.getOrder());
        return null;
    }

    public Integer getCount(Example example) {
        return receiptMapper.selectCountByExample(example);
    }

    public Receipt getById(Integer id) {
        return receiptMapper.selectByPrimaryKey(id);
    }

/*    public Receipt findByUsername(String username) {
        return receiptMapper.selectByUsername(username);
    }*/

    public void deleteById(String id) {
        receiptMapper.deleteByPrimaryKey(id);
    }

    public void insert(Receipt receipt) {
        //获取当前流水号
  /*      String billtype = "LOIN";
        Billno billNo = billnoMapper.selectByBillType(billtype);
        String billData = billNo.getBilldate();
        String currData = DateUtil.getCurrentDate().replaceAll("-", "");
        String currNo;
        String billid = billNo.getUid();*/
        receipt.setUid(UuidUtil.getUUID());
        receipt.setCreatedat(DateUtil.getSysTime());
        receipt.setUpdatedat(DateUtil.getSysTime());
        receipt.setState(1);
        receiptMapper.insert(receipt);

    }

    public void save(Receipt receipt) {
        if (receipt.getUid() != null) {
            receiptMapper.updateByPrimaryKey(receipt);
        } else {
            receiptMapper.insert(receipt);
        }
    }

    public void updateExample(Receipt receipt, Example example) {
        receiptMapper.updateByExampleSelective(receipt, example);
    }

    public List<Receipt> getAllReceipts(Receipt receipt) {
        //PageHelper.offsetPage(offset,limit);
        PageHelper.offsetPage(receipt.getOffset(), receipt.getLimit());
        return receiptMapper.getAllReceipts(receipt);
    }

    public void update(Receipt receipt) {
        if (receipt != null) {

            if (receipt.getId() != null) {

                int state = receipt.getState();
                Date currentTime = DateUtil.getSysTime();
                switch (state) {
                    case 1:
                        receipt.setReceiptTimeBegin(currentTime);//收货开始时间
                        break;
                    case 2:
                        receipt.setReceiptTimeEnd(currentTime);//收货开始时间
                        break;
                    case 3:
                        receipt.setAccepReBegin(currentTime);//收货开始时间
                        break;
                    case 4:
                        receipt.setAccepReEnd(currentTime);//收货开始时间
                        break;
                    case 5:
                        receipt.setAccepCheckBegin(currentTime);//收货开始时间
                        break;
                    case 6:
                        receipt.setAccepCheckEnd(currentTime);//收货开始时间
                        break;
                    case 7:
                        receipt.setAccepBackBegin(currentTime);//收货开始时间
                        break;
                    case 8:
                        receipt.setAccepBackEnd(currentTime);//收货开始时间
                        break;
                    case 9:
                        receipt.setTallyBegin(currentTime);//收货开始时间
                        break;
                    case 10:
                        receipt.setTallyEnd(currentTime);//收货开始时间
                        break;

                }
                receipt.setState(++state);
                receiptMapper.updateByPrimaryKey(receipt);
            }

        }
    }

    public List<Receipt> getAllReceiptsWithFullState(Receipt receipt) {

        PageHelper.offsetPage(receipt.getOffset(), receipt.getLimit());
        return receiptMapper.getAllReceiptsWithFullState(receipt);
    }





    public int[] getReceiptData(Map<String, String> keyMap) {
        String beginDate = keyMap.get("beginDate");
        String endDate = keyMap.get("endDate");

        String categories[] = DateUtil.getCategories(beginDate,endDate);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();

        if (StringUtil.isEmpty(beginDate)) {
            cale = Calendar.getInstance();
            cale.add(Calendar.MONTH, 0);
            cale.set(Calendar.DAY_OF_MONTH, 1);
            beginDate = format.format(cale.getTime());
            keyMap.put("beginDate",beginDate);
        }

        if (StringUtil.isEmpty(endDate)) {
            Date date=new Date();//取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE,+1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
            date=calendar.getTime();
            endDate = format.format(date);
            keyMap.put("endDate",endDate);
        }
        List<HashMap<String,Integer>> ListData = new ArrayList<HashMap<String,Integer>>();
        ListData =receiptMapper.getViewShowData(keyMap);
        int[] receiptData = new int[categories.length];

        //写入对应的值  String date :categories
        for(int i = 0; i < categories.length; i++){
            String date = categories[i];
             boolean isNotEmpty = false;
            for(HashMap<String,Integer> dataMap :ListData){
                String _date = String.valueOf(dataMap.get("date"));
                if(date.equals(_date)){
                    receiptData[i] = Integer.valueOf(String.valueOf(dataMap.get("count")));
                    isNotEmpty = true;
                }
            }
            if(isNotEmpty == false){
                receiptData[i] = 0 ;
            }
        }

        return receiptData;
    }


    public List<Receipt> getAllReceiptsByRegionID(Receipt receipt,String uid){

        int regionID = getRegionByUser(uid);
        PageHelper.offsetPage(receipt.getOffset(),receipt.getLimit());
        return receiptMapper.getAllReceiptsByRegionID(regionID);

    }

    public int getRegionByUser(String uid){
        int regionID = 0;
//        Admin admin = UserUtil.getCurrentUser();
//        if(admin != null){
            Region region = adminService.getRegionByUser(uid);
            if(region != null){
                regionID = region.getId();
//            }
        }
        return regionID;
    }

}
