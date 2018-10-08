package com.geekcattle.model.console;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;
import com.geekcattle.util.ExcelResources;
import com.geekcattle.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import javax.persistence.*;

public class Distrib extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private String uid;

    @Column(name = "distrib_num")
    private String distribNum;

    @Column(name = "order_unit")
    private String orderUnit;

    private String productname;

    private String factory;

    private String unit;

    private BigDecimal number;

    @Column(name = "shipment_time")
    private String shipmentTime;

    @Column(name = "order_begin")
    private String orderBegin;

    @Column(name = "order_end")
    private String orderEnd;

    @Column(name = "order_man")
    private String orderMan;

    @Column(name = "picker")
    private String picker;

    @Column(name = "pick_begin")
    private String pickBegin;

    @Column(name = "pick_end")
    private String pickEnd;

    @Column(name = "data_man")
    private String dataMan;

    private String databillno;

    @Column(name = "data_begin")
    private String dataBegin;

    @Column(name = "data_end")
    private String dataEnd;

    @Column(name = "distrib_check_man")
    private String distribCheckMan;

    @Column(name = "distrib_check_begin")
    private String distribCheckBegin;

    @Column(name = "distrib_check_end")
    private String distribCheckEnd;

    @Column(name = "distrib_pack_man")
    private String distribPackMan;

    @Column(name = "distrib_pack_begin")
    private String distribPackBegin;

    @Column(name = "distrib_pack_end")
    private String distribPackEnd;

    @Column(name = "distrib_deli_man")
    private String distribDeliMan;

    @Column(name = "distrib_begin")
    private String distribBegin;

    @Column(name = "distrib_end")
    private String distribEnd;

    @Column(name = "receipt_addr")
    private String receiptAddr;

    @Column(name = "sendout_time")
    private String sendoutTime;

    @Column(name = "reciept_man")
    private String recieptMan;

    @Column(name = "receipt_man_id")
    private String receiptManId;

    @Column(name = "arrival_time")
    private String arrivalTime;

    private String remark;

    private Integer state;

    private String createdat;

    private String updatedat;

    @Transient
    private String recestartend;

    @Transient
    private String pickstartend;

    @Transient
    private String datastartend;

    @Transient
    private String checkstartend;

    @Transient
    private String packstartend;

    @Transient
    private String diststartend;

    @Transient
    private String orderinfor;

    @Transient
    private String shipinfor;

    @Transient
    private String arriinfor;
    @Transient
    private String recestartend2;

    @Transient
    private String pickstartend2;

    @Transient
    private String datastartend2;

    @Transient
    private String checkstartend2;

    @Transient
    private String packstartend2;

    @Transient
    private String diststartend2;

    @Transient
    private String orderinfor2;

    @Transient
    private String shipinfor2;

    @Transient
    private String arriinfor2;

    @Transient
    private String empcode;

    private Integer status;

    private Integer recovery;

    @Column(name = "region_id")
    private Integer regionId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    @Transient
    @JsonIgnore
    private String sort="";


    @Transient
    @JsonIgnore
    private String order="";

    public String getSort() {
        if(StringUtils.isEmpty(sort)){
            return "createdat";
        }else{
            return sort;
        }
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        if (StringUtils.isEmpty(sort)){
            return "desc";
        }else {
            return order;
        }
    }

    public void setOrder(String order) {
        this.order = order;
    }



    /**
     * @return uid
     */
    @ExcelResources(title = "UID",order = 1)
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return distrib_num
     */
    @ExcelResources(title = "配送单号",order = 3)
    public String getDistribNum() {
        return distribNum;
    }

    /**
     * @param distribNum
     */
    public void setDistribNum(String distribNum) {
        this.distribNum = distribNum;
    }

    /**
     * @return order_unit
     */
    //@ExcelResources(title = "订货单位",order = 2)
    public String getOrderUnit() {
        return orderUnit;
    }

    /**
     * @param orderUnit
     */
    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    /**
     * @return productname
     */
    @ExcelResources(title = "产品名称",order = 5)
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * @return factory
     */
    @ExcelResources(title = "生产厂家",order = 8)
    public String getFactory() {
        return factory;
    }

    /**
     * @param factory
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }

    /**
     * @return unit
     */
    @ExcelResources(title = "单位",order = 6)
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return number
     */
    @ExcelResources(title = "数量",order = 7)
    public BigDecimal getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    /**
     * @return shipment_time
     */
    //@ExcelResources(title = "发出时间",order = 7)
    public String getShipmentTime() {
        return shipmentTime;
    }

    /**
     * @param shipmentTime
     */
    public void setShipmentTime(String shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    /**
     * @return order_begin
     */
    //@ExcelResources(title = "接单开始",order = 8)
    public String getOrderBegin() {
        return orderBegin;
    }

    /**
     * @param orderBegin
     */
    public void setOrderBegin(String orderBegin) {
        this.orderBegin = orderBegin;
    }

    /**
     * @return order_end
     */
    //@ExcelResources(title = "接单结束",order = 9)
    public String getOrderEnd() {
        return orderEnd;
    }

    /**
     * @param orderEnd
     */
    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
    }

    /**
     * @return order_man
     */
    //@ExcelResources(title = "接单员",order = 10)
    public String getOrderMan() {
        return orderMan;
    }

    /**
     * @param orderMan
     */
    public void setOrderMan(String orderMan) {
        this.orderMan = orderMan;
    }

    /**
     * @return data_man
     */
    //@ExcelResources(title = "开单员",order = 11)
    public String getDataMan() {
        return dataMan;
    }

    /**
     * @param dataMan
     */
    public void setDataMan(String dataMan) {
        this.dataMan = dataMan;
    }

    /**
     * @return databillno
     */
    //@ExcelResources(title = "单据编号",order = 12)
    public String getDatabillno() {
        return databillno;
    }

    /**
     * @param databillno
     */
    public void setDatabillno(String databillno) {
        this.databillno = databillno;
    }

    /**
     * @return data_begin
     */
   //@ExcelResources(title = "开单开始",order = 13)
    public String getDataBegin() {
        return dataBegin;
    }

    /**
     * @param dataBegin
     */
    public void setDataBegin(String dataBegin) {
        this.dataBegin = dataBegin;
    }

    /**
     * @return data_end
     */
    //@ExcelResources(title = "开单结束",order = 14)
    public String getDataEnd() {
        return dataEnd;
    }

    /**
     * @param dataEnd
     */
    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    /**
     * @return distrib_check_man
     */
    //@ExcelResources(title = "复核员",order = 15)
    public String getDistribCheckMan() {
        return distribCheckMan;
    }

    /**
     * @param distribCheckMan
     */
    public void setDistribCheckMan(String distribCheckMan) {
        this.distribCheckMan = distribCheckMan;
    }

    /**
     * @return distrib_check_begin
     */
    //@ExcelResources(title = "复核开始",order = 16)
    public String getDistribCheckBegin() {
        return distribCheckBegin;
    }

    /**
     * @param distribCheckBegin
     */
    public void setDistribCheckBegin(String distribCheckBegin) {
        this.distribCheckBegin = distribCheckBegin;
    }

    /**
     * @return distrib_check_end
     */
    //@ExcelResources(title = "复核结束",order = 17)
    public String getDistribCheckEnd() {
        return distribCheckEnd;
    }

    /**
     * @param distribCheckEnd
     */
    public void setDistribCheckEnd(String distribCheckEnd) {
        this.distribCheckEnd = distribCheckEnd;
    }

    /**
     * @return distrib_pack_man
     */
    //@ExcelResources(title = "打包员",order = 18)
    public String getDistribPackMan() {
        return distribPackMan;
    }

    /**
     * @param distribPackMan
     */
    public void setDistribPackMan(String distribPackMan) {
        this.distribPackMan = distribPackMan;
    }

    /**
     * @return distrib_deli_man
     */
    //@ExcelResources(title = "配送员",order = 19)
    public String getDistribDeliMan() {
        return distribDeliMan;
    }

    /**
     * @param distribDeliMan
     */
    public void setDistribDeliMan(String distribDeliMan) {
        this.distribDeliMan = distribDeliMan;
    }

    //@ExcelResources(title = "打包开始",order = 20)
    public String getDistribPackBegin() {
        return distribPackBegin;
    }

    public void setDistribPackBegin(String distribPackBegin) {
        this.distribPackBegin = distribPackBegin;
    }

    //@ExcelResources(title = "打包结束",order = 21)
    public String getDistribPackEnd() {
        return distribPackEnd;
    }

    public void setDistribPackEnd(String distribPackEnd) {
        this.distribPackEnd = distribPackEnd;
    }

    /**
     * @return distrib_begin
     */
    //@ExcelResources(title = "配送开始",order = 22)
    public String getDistribBegin() {
        return distribBegin;
    }

    /**
     * @param distribBegin
     */
    public void setDistribBegin(String distribBegin) {
        this.distribBegin = distribBegin;
    }

    /**
     * @return distrib_end
     */
    //@ExcelResources(title = "配送结束",order = 23)
    public String getDistribEnd() {
        return distribEnd;
    }

    /**
     * @param distribEnd
     */
    public void setDistribEnd(String distribEnd) {
        this.distribEnd = distribEnd;
    }

    /**
     * @return receipt_addr
     */
    //@ExcelResources(title = "收货地址",order = 24)
    public String getReceiptAddr() {
        return receiptAddr;
    }

    /**
     * @param receiptAddr
     */
    public void setReceiptAddr(String receiptAddr) {
        this.receiptAddr = receiptAddr;
    }

    /**
     * @return sendout_time
     */
    //@ExcelResources(title = "发出时间",order = 25)
    public String getSendoutTime() {
        return sendoutTime;
    }

    /**
     * @param sendoutTime
     */
    public void setSendoutTime(String sendoutTime) {
        this.sendoutTime = sendoutTime;
    }

    /**
     * @return reciept_man
     */
    //@ExcelResources(title = "收货人",order = 26)
    public String getRecieptMan() {
        return recieptMan;
    }

    /**
     * @param recieptMan
     */
    public void setRecieptMan(String recieptMan) {
        this.recieptMan = recieptMan;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return state
     */
    @ExcelResources(title = "单据状态", order = 2)
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return createdat
     */
    public String getCreatedat() {
        return createdat;
    }

    /**
     * @param createdat
     */
    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    /**
     * @return Updatedat
     */
    public String getUpdatedat() {
        return updatedat;
    }

    /**
     * @param updatedat
     */
    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }


    /**
     * @return picker
     */
    //@ExcelResources(title = "配货员",order = 27)
    public String getPicker() {
        return picker;
    }

    /**
     *
     * @param picker
     */
    public void setPicker(String picker) {
        this.picker = picker;
    }

    /**
     *
     * @return pick_begin
     */
    //@ExcelResources(title = "配货开始",order = 28)
    public String getPickBegin() {
        return pickBegin;
    }

    /**
     *
     * @param pickBegin
     */
    public void setPickBegin(String pickBegin) {
        this.pickBegin = pickBegin;
    }

    /**
     *
     * @return pick_end
     */
    //@ExcelResources(title = "配货结束",order = 29)
    public String getPickEnd() {
        return pickEnd;
    }

    /**
     *
     * @param pickEnd
     */
    public void setPickEnd(String pickEnd) {
        this.pickEnd = pickEnd;
    }

    //@ExcelResources(title = "到货时间",order = 30)
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    //@ExcelResources(title = "接单员",order = 9)
    public String getRecestartend() {
    /*    String begin = StringUtils.substring(orderBegin,11,16);
        String end = StringUtils.substring(orderEnd,11,16);*/
        orderMan = orderMan == null ? "":orderMan;
        recestartend = orderMan+"</br>"+StringUtil.startTimeToEnd(orderBegin,orderEnd);
        return recestartend;
    }

    public void setRecestartend(String recestartend) {
        this.recestartend = recestartend;
    }

    //@ExcelResources(title = "订货单位"+"</br>"+"出货时间",order = 4)
    public String getOrderinfor() {
        String shipment = StringUtils.substring(shipmentTime,11,16);
        orderinfor = orderUnit +"</br>"+StringUtils.defaultIfBlank(shipment,"");
        return orderinfor;
    }

    public void setOrderinfor(String orderinfor) {
        this.orderinfor = orderinfor;
    }

    //@ExcelResources(title = "配货员" ,order = 10)
    public String getPickstartend() {
       /* String begin = StringUtils.substring(pickBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(pickEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        picker = picker == null ? "" : picker;
        pickstartend = picker+"</br>"+ StringUtil.startTimeToEnd(pickBegin,pickEnd);
        return pickstartend;
    }

    public void setPickstartend(String pickstartend) {
        this.pickstartend = pickstartend;
    }

    //@ExcelResources(title = "开单员" ,order = 11)
    public String getDatastartend() {
       /* String begin = StringUtils.substring(dataBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(dataEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        dataMan = dataMan == null ?"" : dataMan;
        datastartend = dataMan+"</br>"+StringUtil.startTimeToEnd(dataBegin,dataEnd);
        return datastartend;
    }

    public void setDatastartend(String datastartend) {
        this.datastartend = datastartend;
    }

    //@ExcelResources(title = "复核员" ,order = 12)
    public String getCheckstartend() {
        /*String begin = StringUtils.substring(distribCheckBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribCheckEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        distribCheckMan = distribCheckMan == null ? "" : distribCheckMan ;
        checkstartend = distribCheckMan+"</br>"+StringUtil.startTimeToEnd(distribCheckBegin,distribCheckEnd);
        return checkstartend;
    }

    public void setCheckstartend(String checkstartend) {
        this.checkstartend = checkstartend;
    }

    //@ExcelResources(title = "打包员" ,order = 13)
    public String getPackstartend() {
      /*  String begin = StringUtils.substring(distribPackBegin,11,16);
        begin = StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribPackEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        distribPackMan = distribPackMan == null ? "" : distribPackMan;
        packstartend = distribPackMan+"</br>"+StringUtil.startTimeToEnd(distribPackBegin,distribPackEnd);
        return packstartend;
    }

    public void setPackstartend(String packstartend) {
        this.packstartend = packstartend;
    }

    //@ExcelResources(title = "送货员" ,order = 14)
    public String getDiststartend() {
        /*String begin = StringUtils.substring(distribBegin,11,16);
        begin = StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribEnd,11,16);
        end = StringUtils.defaultIfBlank(end,"");*/
        distribDeliMan = distribDeliMan == null ? "" : distribDeliMan;
        diststartend = distribDeliMan+"</br>"+StringUtil.startTimeToEnd(distribBegin,distribEnd);
        return diststartend;
    }

    public void setDiststartend(String diststartend) {
        this.diststartend = diststartend;
    }

    //@ExcelResources(title = "收货地"+"/n"+"发出时间" ,order = 15)
    public String getShipinfor() {
        String shipment = StringUtils.substring(sendoutTime,11,16);
        receiptAddr = receiptAddr == null ? "" : receiptAddr;
        shipinfor = receiptAddr +"</br>"+StringUtils.defaultIfBlank(shipment,"");
        return shipinfor;
    }

    public void setShipinfor(String shipinfor) {
        this.shipinfor = shipinfor;
    }

    //@ExcelResources(title = "收货"+"/n"+"到货时间" ,order = 16)
    public String getArriinfor() {
        String attival = StringUtils.substring(arrivalTime,11,16);
        //arriinfor = recieptMan +"</br>"+StringUtils.defaultIfBlank(attival,"");
        arriinfor = recieptMan +"</br>"+StringUtils.defaultIfBlank(attival,"");
        return arriinfor;
    }

    public void setArriinfor(String arriinfor) {
        this.arriinfor = arriinfor;
    }


    @ExcelResources(title = "接单员",order = 9)
    public String getRecestartend2() {
    /*    String begin = StringUtils.substring(orderBegin,11,16);
        String end = StringUtils.substring(orderEnd,11,16);*/
        orderMan = orderMan == null ? "":orderMan;
        recestartend2 = orderMan+""+StringUtil.startTimeToEnd(orderBegin,orderEnd);
        return recestartend2;
    }


    @ExcelResources(title = "订货单位"+"-"+"出货时间",order = 4)
    public String getOrderinfor2() {
        String shipment = StringUtils.substring(shipmentTime,11,16);
        orderinfor2 = orderUnit +""+StringUtils.defaultIfBlank(shipment,"");
        return orderinfor2;
    }

    public void setOrderinfor2(String orderinfor2) {
        this.orderinfor2 = orderinfor2;
    }

    @ExcelResources(title = "配货员" ,order = 10)
    public String getPickstartend2() {
       /* String begin = StringUtils.substring(pickBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(pickEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        picker = picker == null ? "" : picker;
        pickstartend2 = picker+""+ StringUtil.startTimeToEnd(pickBegin,pickEnd);
        return pickstartend2;
    }

    public void setPickstartend2(String pickstartend2) {
        this.pickstartend2 = pickstartend2;
    }

    @ExcelResources(title = "开单员" ,order = 11)
    public String getDatastartend2() {
       /* String begin = StringUtils.substring(dataBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(dataEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        dataMan = dataMan == null ?"" : dataMan;
        datastartend2 = dataMan+""+StringUtil.startTimeToEnd(dataBegin,dataEnd);
        return datastartend2;
    }

    public void setDatastartend2(String datastartend2) {
        this.datastartend2 = datastartend2;
    }

    @ExcelResources(title = "复核员" ,order = 12)
    public String getCheckstartend2() {
        /*String begin = StringUtils.substring(distribCheckBegin,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribCheckEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        distribCheckMan = distribCheckMan == null ? "" : distribCheckMan ;
        checkstartend2 = distribCheckMan+""+StringUtil.startTimeToEnd(distribCheckBegin,distribCheckEnd);
        return checkstartend2;
    }

    public void setCheckstartend2(String checkstartend2) {
        this.checkstartend2 = checkstartend2;
    }

    @ExcelResources(title = "打包员" ,order = 13)
    public String getPackstartend2() {
      /*  String begin = StringUtils.substring(distribPackBegin,11,16);
        begin = StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribPackEnd,11,16);
        end=StringUtils.defaultIfBlank(end,"");*/
        distribPackMan = distribPackMan == null ? "" : distribPackMan;
        packstartend2 = distribPackMan+""+StringUtil.startTimeToEnd(distribPackBegin,distribPackEnd);
        return packstartend2;
    }

    public void setPackstartend2(String packstartend2) {
        this.packstartend2 = packstartend2;
    }

    @ExcelResources(title = "送货员" ,order = 14)
    public String getDiststartend2() {
        /*String begin = StringUtils.substring(distribBegin,11,16);
        begin = StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(distribEnd,11,16);
        end = StringUtils.defaultIfBlank(end,"");*/
        distribDeliMan = distribDeliMan == null ? "" : distribDeliMan;
        diststartend2 = distribDeliMan+""+StringUtil.startTimeToEnd(distribBegin,distribEnd);
        return diststartend2;
    }

    public void setDiststartend2(String diststartend2) {
        this.diststartend2 = diststartend2;
    }

    @ExcelResources(title = "收货地"+"-"+"发出时间" ,order = 15)
    public String getShipinfor2() {
        String shipment = StringUtils.substring(sendoutTime,11,16);
        receiptAddr = receiptAddr == null ? "" : receiptAddr;
        shipinfor2 = receiptAddr +""+StringUtils.defaultIfBlank(shipment,"");
        return shipinfor2;
    }

    public void setShipinfor2(String shipinfor2) {
        this.shipinfor2 = shipinfor2;
    }

    @ExcelResources(title = "收货"+"-"+"到货时间" ,order = 16)
    public String getArriinfor2() {
        String attival = StringUtils.substring(arrivalTime,11,16);
        //arriinfor = recieptMan +"</br>"+StringUtils.defaultIfBlank(attival,"");
        arriinfor2 = recieptMan +""+StringUtils.defaultIfBlank(attival,"");
        return arriinfor2;
    }

    public void setArriinfor2(String arriinfor2) {
        this.arriinfor2 = arriinfor2;
    }


    public Integer getRecovery() {
        return recovery;
    }

    public void setRecovery(Integer recovery) {
        this.recovery = recovery;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getReceiptManId() {
        return receiptManId;
    }

    public void setReceiptManId(String receiptManId) {
        this.receiptManId = receiptManId;
    }
}