/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.service.console;

import com.geekcattle.mapper.basic.BillnoMapper;
import com.geekcattle.mapper.console.DistribMapper;
import com.geekcattle.model.basic.Billno;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.util.CamelCaseUtil;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:43
 */
@Service
public class DistribService {


    @Autowired
    private BillnoMapper billnoMapper;


    @Autowired
    private DistribMapper distribMapper;

    @Autowired
    private ReceiptService receiptService;

/*    @Autowired
    private RoleService roleService;*/

    public List<Distrib> getPageList(Distrib distrib) {
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), CamelCaseUtil.toUnderlineName(distrib.getSort()) + " " + distrib.getOrder());
        return distribMapper.selectAll();
    }
    public List<Distrib> getAllDistribsByRegionID(Distrib distrib,String uid) {
        int regionID = receiptService.getRegionByUser(uid);
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), CamelCaseUtil.toUnderlineName(distrib.getSort()) + " " + distrib.getOrder());
        return distribMapper.getAllDistribsByRegionID(regionID);
    }



    public List<Distrib> getPageListByRole(Distrib distrib) {
//        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), CamelCaseUtil.toUnderlineName(distrib.getSort())+" "+distrib.getOrder());
        //PageHelper.offsetPage((int)params.get("offset"), (int)params.get("limit"), null);
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), "createdat desc");
        return distribMapper.selectByRole(distrib);
    }

    public Integer getCount(Example example) {
        return distribMapper.selectCountByExample(example);
    }

    public Distrib getById(String id) {
        return distribMapper.selectByPrimaryKey(id);
    }

/*    public Distrib findByUsername(String username) {
        return distribMapper.selectByUsername(username);
    }*/

    public void deleteById(String id) {
        distribMapper.deleteByPrimaryKey(id);
    }

    public void insert(Distrib distrib) {
        //获取当前流水号
        String billtype = "LOOT";
        Billno billNo = billnoMapper.selectByBillType(billtype);
        String billData = billNo.getBilldate();
        String currData = DateUtil.getCurrentDate().replaceAll("-", "");
        String currNo;
        String billid = billNo.getUid();

        if (currData.equals(billData)) {
            currNo = billtype + currData + (billNo.getBillmaxno().toString()).substring(1);
//            distrib.setDistribNum(currNo);
            distrib.setDatabillno(currNo);
            distribMapper.insert(distrib);

            Integer newNo = billNo.getBillmaxno() + 1;
            billNo.setBillmaxno(newNo);
            billnoMapper.updateByPrimaryKey(billNo);
        } else {
            currNo = billtype + currData + "0001";
//            distrib.setDistribNum(currNo);
            distrib.setDatabillno(currNo);
            distribMapper.insert(distrib);

            Integer newNo = 10002;
            billNo.setBillmaxno(newNo);
            billNo.setBilldate(currData);
            billnoMapper.updateByPrimaryKey(billNo);
        }

    }

    public void save(Distrib distrib) {
        if (distrib.getUid() != null) {
            distribMapper.updateByPrimaryKey(distrib);
        } else {
            distribMapper.insert(distrib);
        }
    }

    public void appDistribSave(Distrib distrib) {
            if (StringUtils.isEmpty(distrib.getUid())) {
                distrib.setUid(UuidUtil.getUUID());
                distrib.setCreatedat(DateUtil.getCurrentTime());
                distrib.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(distrib);
                distrib.setState(1);
                distrib.setStatus(0);
                this.insert(distrib);
            } else {
                Distrib distribNew = this.getById(distrib.getUid());
                distrib.setUpdatedat(DateUtil.getCurrentTime());
                timeEmptyToNull(distrib);
                distrib.setState(distribNew.getState()+1);
                distrib.setStatus(0);
                distribMapper.updateByPrimaryKeySelective(distrib);
            }
    }

    public void updateExample(Distrib distrib, Example example) {
        distribMapper.updateByExampleSelective(distrib, example);
    }

    public List<Distrib> getAllDistribs(Distrib distrib){
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), "createdat desc");
        return distribMapper.getAllDistribs(distrib);
    }

    public List<Distrib> selectRecoveryed(Distrib distrib){
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), "createdat desc");
        return distribMapper.selectRecoveryed(distrib);
    }

    public List<Distrib> selectUnRecovery(Distrib distrib){
        PageHelper.offsetPage(distrib.getOffset(), distrib.getLimit(), "createdat desc");
        return distribMapper.selectUnRecovery(distrib);
    }

    public void deleteRow (String uid) throws  Exception{
        Distrib distrib = distribMapper.selectByPrimaryKey(uid);
        if(distrib != null){
            distrib.setStatus(1);
            distribMapper.updateByPrimaryKey(distrib);
        }else{
            throw new Exception("数据有误，无法删除");
        }

    }

    private Distrib timeEmptyToNull(Distrib distrib){


        if("".equals(distrib.getShipmentTime())){
            distrib.setShipmentTime(null);
        }
        if("".equals(distrib.getOrderBegin())){
            distrib.setOrderBegin(null);
        }
        if("".equals(distrib.getOrderEnd())){
            distrib.setOrderEnd(null);
        }
        if("".equals(distrib.getPickBegin())){
            distrib.setPickBegin(null);
        };
        if("".equals(distrib.getPickEnd())){
            distrib.setPickEnd(null);
        };
        if("".equals(distrib.getDataBegin())){
            distrib.setDataBegin(null);
        };
        if("".equals(distrib.getDataEnd())){
            distrib.setDataEnd(null);
        };
        if("".equals(distrib.getDistribCheckBegin())){
            distrib.setDistribCheckBegin(null);
        };
        if("".equals(distrib.getDistribCheckEnd())){
            distrib.setDistribCheckEnd(null);
        };
        if("".equals(distrib.getDistribPackBegin())){
            distrib.setDistribPackBegin(null);
        };
        if("".equals(distrib.getDistribPackEnd())){
            distrib.setDistribPackEnd(null);
        };
        if("".equals(distrib.getDistribBegin())){
            distrib.setDistribBegin(null);
        };
        if("".equals(distrib.getDistribEnd())){
            distrib.setDistribEnd(null);
        };
        if("".equals(distrib.getSendoutTime())){
            distrib.setSendoutTime(null);
        };
        if("".equals( distrib.getArrivalTime())){
            distrib.setArrivalTime(null);
        };

        if("".equals(distrib.getCreatedat())){
            distrib.setCreatedat(null);
        };

       /* if(!distrib.getShipmentTime().equals(null) && distrib.getShipmentTime().isEmpty()){
            distrib.setShipmentTime(null);
        };
        if(!distrib.getOrderBegin().equals(null) && distrib.getOrderBegin().isEmpty()){
            distrib.setOrderBegin(null);
        };
        if(!distrib.getOrderEnd().equals(null) && distrib.getOrderEnd().isEmpty()){
            distrib.setOrderEnd(null);
        };
        //if( "".equals(distrib.getPickBegin())){
        if(!distrib.getPickBegin().equals(null) && distrib.getPickBegin().isEmpty()){
            distrib.setPickBegin(null);
        };
        if(!distrib.getPickEnd().equals(null) && distrib.getPickEnd().isEmpty()){
            distrib.setPickEnd(null);
        };
        if(!distrib.getDataBegin().equals(null) && distrib.getDataBegin().isEmpty()){
            distrib.setDataBegin(null);
        };
        if(!distrib.getDataEnd().equals(null) && distrib.getDataEnd().isEmpty()){
            distrib.setDataEnd(null);
        };
        if(!distrib.getDistribCheckBegin().equals(null) && distrib.getDistribCheckBegin().isEmpty()){
            distrib.setDistribCheckBegin(null);
        };
        if(!distrib.getDistribCheckEnd().equals(null) && distrib.getDistribCheckEnd().isEmpty()){
            distrib.setDistribCheckEnd(null);
        };
        if(!distrib.getDistribPackBegin().equals(null) && distrib.getDistribPackBegin().isEmpty()){
            distrib.setDistribPackBegin(null);
        };
        if(!distrib.getDistribPackEnd().equals(null) && distrib.getDistribPackEnd().isEmpty()){
            distrib.setDistribPackEnd(null);
        };
        if(!distrib.getDistribBegin().equals(null) && distrib.getDistribBegin().isEmpty()){
            distrib.setDistribBegin(null);
        };
        if(!distrib.getDistribEnd().equals(null) && distrib.getDistribEnd().isEmpty()){
            distrib.setDistribEnd(null);
        };
        if(!distrib.getSendoutTime().equals(null) && distrib.getSendoutTime().isEmpty()){
            distrib.setSendoutTime(null);
        };
        if(!distrib.getArrivalTime().equals(null) && distrib.getArrivalTime().isEmpty()){
            distrib.setArrivalTime(null);
        };

        if(!distrib.getCreatedat().equals(null) && distrib.getCreatedat().isEmpty()){
            distrib.setCreatedat(null);
        };*/

        return distrib;
    }




    public int[] getDistribData(Map<String, String> keyMap) {
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
        ListData =distribMapper.getViewShowData(keyMap);
        int[] distribData = new int[categories.length];

        //写入对应的值  String date :categories
        for(int i = 0; i < categories.length; i++){
            String date = categories[i];
            boolean isNotEmpty = false;
            for(HashMap<String,Integer> dataMap :ListData){
                String _date = String.valueOf(dataMap.get("date"));
                if(date.equals(_date)){
                    distribData[i] = Integer.valueOf(String.valueOf(dataMap.get("count")));
                    isNotEmpty = true;
                }
            }
            if(isNotEmpty == false){
                distribData[i] = 0 ;
            }
        }

        return distribData;
    }




}
