package com.geekcattle.service.console;

import com.geekcattle.mapper.console.TransferInfoMapper;
import com.geekcattle.model.console.Distrib;
import com.geekcattle.model.console.Receipt;
import com.geekcattle.model.console.TransferInfo;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TransferService {
    @Autowired
    private TransferInfoMapper transferInfoMapper;
    @Autowired
    private ReceiptService receiptService;

   public List<TransferInfo> getAllTransferInfoeWithDone(TransferInfo transferInfo){
       PageHelper.offsetPage(transferInfo.getOffset(),transferInfo.getLimit());
        return transferInfoMapper.getAllTransferInfoeWithDone(transferInfo);
    }

    public List<TransferInfo> getAllTransferInfoWithNoDone(TransferInfo transferInfo){
        PageHelper.offsetPage(transferInfo.getOffset(),transferInfo.getLimit());
        return transferInfoMapper.getAllTransferInfoWithNoDone(transferInfo);
    }

    public List<TransferInfo> getAllTransferInfoByRegionID(TransferInfo transferInfo,String uid){
        int regionID = receiptService.getRegionByUser(uid);
        PageHelper.offsetPage(transferInfo.getOffset(),transferInfo.getLimit());
        return transferInfoMapper.getAllTransferInfoByRegionID(regionID);
    }

    public List<TransferInfo> selectUnRecovery(TransferInfo transferInfo){
        PageHelper.offsetPage(transferInfo.getOffset(),transferInfo.getLimit());
        return transferInfoMapper.selectUnRecovery(transferInfo);
    }

    public TransferInfo getById(Integer id) {
        return transferInfoMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insert(TransferInfo transferInfo) throws  Exception{
       if(transferInfo == null){
           throw new Exception("调货单的数据不能为空");
       }
       if(transferInfo.getId()== null && transferInfo.getUid() == null){
           transferInfo.setUid(UuidUtil.getUUID());
       }
        transferInfoMapper.insert(transferInfo);
    }

    public void save(TransferInfo transferInfo) {
        if (transferInfo.getId() != null) {
           transferInfoMapper.updateByPrimaryKey(transferInfo);
        } else {
            transferInfoMapper.insert(transferInfo);
        }
    }

    public void update(TransferInfo transferInfo) {
       if(transferInfo != null){
           if(transferInfo.getId() != null){
               int state =  transferInfo.getState();
               Date currTime = DateUtil.getSysTime();
               switch (state){
                   case 1:
                       transferInfo.setTransferTimeBegin(currTime);
                       break;
                   case 2:
                       transferInfo.setTransferTimeEnd(currTime);
                       break;
                   case 3:
                       transferInfo.setFetchGoodsBegin(currTime);
                       break;
                   case 4:
                       transferInfo.setFetchGoodsEnd(currTime);
                       break;
                   case 5:
                       transferInfo.setDataTimeBegin(currTime);
                       break;
                   case 6:
                       transferInfo.setDataTimeEnd(currTime);
                   case 7:
                       transferInfo.setCheckTimeBegin(currTime);
                       break;
                   case 8:
                       transferInfo.setCheckTimeEnd(currTime);
                       break;
                   case 9:
                       transferInfo.setRecheckTimeBegin(currTime);
                       break;
                   case 10:
                       transferInfo.setRecheckTimeEnd(currTime);
                       break;
                   case 11:
                       transferInfo.setPackTimeBegin(currTime);
                       break;
                   case 12:
                       transferInfo.setPackTimeEnd(currTime);
                   case 13:
                       transferInfo.setDeliveryTimeBegin(currTime);
                       break;
                   case 14:
                       transferInfo.setDeliveryTimeEnd(currTime);
                       break;
               }
               transferInfo.setState(++state);
               transferInfoMapper.updateByPrimaryKey(transferInfo);
           }
       }
    }


    public void appUpdate(TransferInfo transferInfo) {
        if(transferInfo != null){
            if(transferInfo.getId() != null){
                TransferInfo transferInfoNew = transferInfoMapper.selectByPrimaryKey(transferInfo.getId());
                if(transferInfo.getTransferman() != null){
                    transferInfoNew.setTransferman(transferInfo.getTransferman());
                }
                if(transferInfo.getFetchGoodsMan()!= null){
                    transferInfoNew.setFetchGoodsMan(transferInfo.getFetchGoodsMan());
                }
                if(transferInfo.getDataMan()!=null){
                    transferInfoNew.setDataMan(transferInfo.getDataMan());
                }
                if(transferInfo.getCheckMan()!=null){
                    transferInfoNew.setCheckMan(transferInfo.getCheckMan());
                }
                if(transferInfo.getRecheckMan()!=null){
                    transferInfoNew.setRecheckMan(transferInfo.getRecheckMan());
                }
                if(transferInfo.getPackMan()!=null){
                    transferInfoNew.setPackMan(transferInfo.getPackMan());
                }
                if(transferInfo.getDeliveryMan()!=null){
                    transferInfoNew.setDeliveryMan(transferInfo.getDeliveryMan());
                }

                int state =  transferInfoNew.getState();
                Date currTime = DateUtil.getSysTime();
                switch (state){
                    case 1:
                        transferInfoNew.setTransferTimeBegin(currTime);
                        break;
                    case 2:
                        transferInfoNew.setTransferTimeEnd(currTime);
                        break;
                    case 3:
                        transferInfoNew.setFetchGoodsBegin(currTime);
                        break;
                    case 4:
                        transferInfoNew.setFetchGoodsEnd(currTime);
                        break;
                    case 5:
                        transferInfoNew.setDataTimeBegin(currTime);
                        break;
                    case 6:
                        transferInfoNew.setDataTimeEnd(currTime);
                    case 7:
                        transferInfoNew.setCheckTimeBegin(currTime);
                        break;
                    case 8:
                        transferInfoNew.setCheckTimeEnd(currTime);
                        break;
                    case 9:
                        transferInfoNew.setRecheckTimeBegin(currTime);
                        break;
                    case 10:
                        transferInfoNew.setRecheckTimeEnd(currTime);
                        break;
                    case 11:
                        transferInfoNew.setPackTimeBegin(currTime);
                        break;
                    case 12:
                        transferInfoNew.setPackTimeEnd(currTime);
                    case 13:
                        transferInfoNew.setDeliveryTimeBegin(currTime);
                        break;
                    case 14:
                        transferInfoNew.setDeliveryTimeEnd(currTime);
                        break;
                }
                transferInfoNew.setState(++state);
                transferInfoMapper.updateByPrimaryKey(transferInfoNew);
            }
        }
    }



    public int[] getTransferInfoData(Map<String, String> keyMap) {
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
        ListData =transferInfoMapper.getViewShowData(keyMap);
        int[] transferInfoData = new int[categories.length];

        //写入对应的值  String date :categories
        for(int i = 0; i < categories.length; i++){
            String date = categories[i];
            boolean isNotEmpty = false;
            for(HashMap<String,Integer> dataMap :ListData){
                String _date = String.valueOf(dataMap.get("date"));
                if(date.equals(_date)){
                    transferInfoData[i] = Integer.valueOf(String.valueOf(dataMap.get("count")));
                    isNotEmpty = true;
                }
            }
            if(isNotEmpty == false){
                transferInfoData[i] = 0 ;
            }
        }

        return transferInfoData;
    }

}
