package com.geekcattle.model.console;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ExcelResources;
import com.geekcattle.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Receipt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "receipt_num")
    private String receiptNum;

    @Column(name = "delivery_unit")
    private String deliveryUnit;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    @Column(name = "delivery_time")
    private Date deliveryTime;

    private String productname;

    private String factory;

    private String unit;

    private BigDecimal number;

    @Column(name = "receipt_addr")
    private String receiptAddr;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "receipt_time")
    private Date receiptTime;

    @Column(name = "receipt_man")
    private String receiptMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    @Column(name = "receipt_time_begin")
    private Date receiptTimeBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "receipt_time_end")
    private Date receiptTimeEnd;

    @Column(name = "accep_re_man")
    private String accepReMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_re_begin")
    private Date accepReBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_re_end")
    private Date accepReEnd;

    @Column(name = "accep_check_man")
    private String accepCheckMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_check_begin")
    private Date accepCheckBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_check_end")
    private Date accepCheckEnd;

    @Column(name = "accep_back_man")
    private String accepBackMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_back_begin")
    private Date accepBackBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "accep_back_end")
    private Date accepBackEnd;

    @Column(name = "tally_man")
    private String tallyMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "tally_begin")
    private Date tallyBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8" )
    @Column(name = "tally_end")
    private Date tallyEnd;

    private String remark;

    private Integer state;

    private Date createdat;

    private Date updatedat;

    private String distribno;//配送单号

    private String transferno;//调货单号

    @Column(name = "region_id")
    private Integer regionID;


    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //这些属性用来显示组合字段
    @Transient
    public String deliveryFromAndTime;//发货单位和时间
    @Transient
    public String arriveStationAndTime;//接货地址和时间
    @Transient
    public String fetchGoodsManAndTime;//接货员和时间
    @Transient
    public String examineGoodsManAndTime;//验货员和时间
    @Transient
    public String checkGoodsManAndTime;//复核员和时间
    @Transient
    public String chargeBackManAndTime;//退单员和时间
    @Transient
    public String groundingManAndTime;//上架员和时间

    @Transient
    public String deliveryFromAndTime2;//发货单位和时间
    @Transient
    public String arriveStationAndTime2;//接货地址和时间
    @Transient
    public String fetchGoodsManAndTime2;//接货员和时间
    @Transient
    public String examineGoodsManAndTime2;//验货员和时间
    @Transient
    public String checkGoodsManAndTime2;//复核员和时间
    @Transient
    public String chargeBackManAndTime2;//退单员和时间
    @Transient
    public String groundingManAndTime2;//上架员和时间


    @Transient
    @JsonIgnore
    private String sort = "";


    @Transient
    @JsonIgnore
    private String order = "";

    public String getSort() {
        if (StringUtils.isEmpty(sort)) {
            return "createdat";
        } else {
            return sort;
        }
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        if (StringUtils.isEmpty(sort)) {
            return "desc";
        } else {
            return order;
        }
    }

    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * @return uid
     */
    @ExcelResources(title = "UID", order = 1)
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
     * @return receipt_num
     */
    @ExcelResources(title = "收货单号", order = 3)
    public String getReceiptNum() {
        return receiptNum;
    }

    /**
     * @param receiptNum
     */
    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    /**
     * @return delivery_unit
     */
    //@ExcelResources(title = "发货单位",order = 2)
    public String getDeliveryUnit() {
        return deliveryUnit;
    }

    /**
     * @param deliveryUnit
     */
    public void setDeliveryUnit(String deliveryUnit) {
        this.deliveryUnit = deliveryUnit;
    }

    /**
     * @return delivery_time
     */
    //@ExcelResources(title = "发货时间",order=3)
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @param deliveryTime
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
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
    @ExcelResources(title = "生成厂家",order = 6)
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
    @ExcelResources(title = "单位",order = 7)
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
    @ExcelResources(title = "数量",order = 8)
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
     * @return receipt_addr
     */
    //@ExcelResources(title = "接货地址",order = 8)
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
     * @return receipt_time
     */
    //@ExcelResources(title = "接货时间",order = 9)
    public Date getReceiptTime() {
        return receiptTime;
    }

    /**
     * @param receiptTime
     */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * @return receipt_man
     */
    //@ExcelResources(title = "接货员",order = 10)
    public String getReceiptMan() {
        return receiptMan;
    }

    /**
     * @param receiptMan
     */
    public void setReceiptMan(String receiptMan) {
        this.receiptMan = receiptMan;
    }

    /**
     * @return receipt_time_begin
     */
    //@ExcelResources(title = "接货开始", order = 11)
    public Date getReceiptTimeBegin() {
        return receiptTimeBegin;
    }

    /**
     * @param receiptTimeBegin
     */
    public void setReceiptTimeBegin(Date receiptTimeBegin) {
        this.receiptTimeBegin = receiptTimeBegin;
    }

    /**
     * @return receipt_time_end
     */
    //@ExcelResources(title = "接货结束", order = 12)
    public Date getReceiptTimeEnd() {
        return receiptTimeEnd;
    }

    /**
     * @param receiptTimeEnd
     */
    public void setReceiptTimeEnd(Date receiptTimeEnd) {
        this.receiptTimeEnd = receiptTimeEnd;
    }

    /**
     * @return accep_re_man
     */
    //@ExcelResources(title = "验货员",order = 13)
    public String getAccepReMan() {
        return accepReMan;
    }

    /**
     * @param accepReMan
     */
    public void setAccepReMan(String accepReMan) {
        this.accepReMan = accepReMan;
    }

    /**
     * @return accep_re_begin
     */
    //@ExcelResources(title = "验货开始",order = 14)
    public Date getAccepReBegin() {
        return accepReBegin;
    }

    /**
     * @param accepReBegin
     */
    public void setAccepReBegin(Date accepReBegin) {
        this.accepReBegin = accepReBegin;
    }

    /**
     * @return accep_re_end
     */
    //@ExcelResources(title = "验货结束",order = 15)
    public Date getAccepReEnd() {
        return accepReEnd;
    }

    /**
     * @param accepReEnd
     */
    public void setAccepReEnd(Date accepReEnd) {
        this.accepReEnd = accepReEnd;
    }

    /**
     * @return accep_check_man
     */
    //@ExcelResources(title = "复核员",order = 16)
    public String getAccepCheckMan() {
        return accepCheckMan;
    }

    /**
     * @param accepCheckMan
     */
    public void setAccepCheckMan(String accepCheckMan) {
        this.accepCheckMan = accepCheckMan;
    }

    /**
     * @return accep_check_begin
     */
    //@ExcelResources(title = "复核开始",order = 17)
    public Date getAccepCheckBegin() {
        return accepCheckBegin;
    }

    /**
     * @param accepCheckBegin
     */
    public void setAccepCheckBegin(Date accepCheckBegin) {
        this.accepCheckBegin = accepCheckBegin;
    }

    /**
     * @return accep_check_end
     */
    //@ExcelResources(title = "复核结束",order = 18)
    public Date getAccepCheckEnd() {
        return accepCheckEnd;
    }

    /**
     * @param accepCheckEnd
     */
    public void setAccepCheckEnd(Date accepCheckEnd) {
        this.accepCheckEnd = accepCheckEnd;
    }

    /**
     * @return accep_back_man
     */
    //@ExcelResources(title = "退单员",order = 19)
    public String getAccepBackMan() {
        return accepBackMan;
    }

    /**
     * @param accepBackMan
     */
    public void setAccepBackMan(String accepBackMan) {
        this.accepBackMan = accepBackMan;
    }

    /**
     * @return accep_back_begin
     */
    //@ExcelResources(title = "退单开始",order = 20)
    public Date getAccepBackBegin() {
        return accepBackBegin;
    }

    /**
     * @param accepBackBegin
     */
    public void setAccepBackBegin(Date accepBackBegin) {
        this.accepBackBegin = accepBackBegin;
    }

    /**
     * @return accep_back_end
     */
    //@ExcelResources(title = "退单结束",order = 21)
    public Date getAccepBackEnd() {
        return accepBackEnd;
    }

    /**
     * @param accepBackEnd
     */
    public void setAccepBackEnd(Date accepBackEnd) {
        this.accepBackEnd = accepBackEnd;
    }

    /**
     * @return tally_man
     */
    //@ExcelResources(title = "上架员",order = 22)
    public String getTallyMan() {
        return tallyMan;
    }

    /**
     * @param tallyMan
     */
    public void setTallyMan(String tallyMan) {
        this.tallyMan = tallyMan;
    }

    /**
     * @return tally_begin
     */
    //@ExcelResources(title = "上架开始",order = 23)
    public Date getTallyBegin() {
        return tallyBegin;
    }

    /**
     * @param tallyBegin
     */
    public void setTallyBegin(Date tallyBegin) {
        this.tallyBegin = tallyBegin;
    }

    /**
     * @return tally_end
     */
    //@ExcelResources(title = "上架结束",order = 24)
    public Date getTallyEnd() {
        return tallyEnd;
    }

    /**
     * @param tallyEnd
     */
    public void setTallyEnd(Date tallyEnd) {
        this.tallyEnd = tallyEnd;
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
    @ExcelResources(title = "单据状态",order = 2)
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
    public Date getCreatedat() {
        return createdat;
    }

    /**
     * @param createdat
     */
    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    /**
     * @return updatedat
     */
    public Date getUpdatedat() {
        return updatedat;
    }

    /**
     * @param updatedat
     */
    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }


    public String getDeliveryFromAndTime() {

        deliveryFromAndTime = "<div>"+deliveryUnit + "</div><div>" + DateUtil.formatForTime(deliveryTime)+"</div>";
        return deliveryFromAndTime;
    }

    public void setDeliveryFromAndTime(String deliveryFromAndTime) {
        this.deliveryFromAndTime = deliveryFromAndTime;
    }

    public String getArriveStationAndTime() {
        arriveStationAndTime = "<div>"+receiptAddr + "</div><div>" + DateUtil.formatForTime(receiptTime)+"</div>";
        return arriveStationAndTime;
    }

    public void setArriveStationAndTime(String arriveStationAndTime) {
        this.arriveStationAndTime = arriveStationAndTime;
    }

    public String getFetchGoodsManAndTime() {
        receiptMan = receiptMan == null ? "" :receiptMan;
        fetchGoodsManAndTime = "<div>"+receiptMan + "</div><div>" + DateUtil.formatForTime(receiptTimeBegin)+"-"+DateUtil.formatForTime(receiptTimeEnd)+"</div>";
        return fetchGoodsManAndTime;
    }

    public void setFetchGoodsManAndTime(String fetchGoodsManAndTime) {
        this.fetchGoodsManAndTime = fetchGoodsManAndTime;
    }

    public String getExamineGoodsManAndTime() {
        accepReMan = accepReMan == null ? "" : accepReMan;
        examineGoodsManAndTime = "<div>"+accepReMan + "</div><div>" + DateUtil.formatForTime(accepReBegin)+"-"+DateUtil.formatForTime(accepReEnd)+"</div>";
        return examineGoodsManAndTime;
    }

    public void setExamineGoodsManAndTime(String examineGoodsManAndTime) {
        this.examineGoodsManAndTime = examineGoodsManAndTime;
    }

    public String getCheckGoodsManAndTime() {
        accepCheckMan = accepCheckMan== null ? "" : accepCheckMan;
        checkGoodsManAndTime = "<div>"+accepCheckMan + "</div><div>" + DateUtil.formatForTime(accepCheckBegin)+"-"+DateUtil.formatForTime(accepCheckEnd)+"</div>";
        return checkGoodsManAndTime;
    }

    public void setCheckGoodsManAndTime(String checkGoodsManAndTime) {
        this.checkGoodsManAndTime = checkGoodsManAndTime;
    }

    public String getChargeBackManAndTime() {
        accepBackMan = accepBackMan== null ?"" : accepBackMan;
        chargeBackManAndTime = "<div>"+accepBackMan + "</div><div>" + DateUtil.formatForTime(accepBackBegin)+"-"+DateUtil.formatForTime(accepBackEnd)+"</div>";
        return chargeBackManAndTime;
    }

    public void setChargeBackManAndTime(String chargeBackManAndTime) {

        this.chargeBackManAndTime = chargeBackManAndTime;
    }

    public String getGroundingManAndTime() {
        tallyMan = tallyMan == null ? "" : tallyMan;
        groundingManAndTime = "<div>"+tallyMan + "</div><div>" + DateUtil.formatForTime(tallyBegin)+"-"+DateUtil.formatForTime(tallyEnd)+"</div>";
        return groundingManAndTime;
    }

    @ExcelResources(title = "发货单位",order = 4)
    public String getDeliveryFromAndTime2() {
        deliveryFromAndTime2 = deliveryUnit + "" + DateUtil.formatForTime(deliveryTime);
        return deliveryFromAndTime2;
    }

    public void setDeliveryFromAndTime2(String deliveryFromAndTime2) {
        this.deliveryFromAndTime2 = deliveryFromAndTime2;
    }

    @ExcelResources(title = "接货地址",order = 9)
    public String getArriveStationAndTime2() {
        arriveStationAndTime2 = receiptAddr + "" + DateUtil.formatForTime(receiptTime);
        return arriveStationAndTime2;
    }

    public void setArriveStationAndTime2(String arriveStationAndTime2) {
        this.arriveStationAndTime2 = arriveStationAndTime2;
    }

    @ExcelResources(title = "接货员",order = 10)
    public String getFetchGoodsManAndTime2() {
        receiptMan = receiptMan == null ? "" :receiptMan;
        fetchGoodsManAndTime2 = receiptMan + ":" + DateUtil.formatForTime(receiptTimeBegin)+"-"+DateUtil.formatForTime(receiptTimeEnd);
        return fetchGoodsManAndTime2;
    }

    public void setFetchGoodsManAndTime2(String fetchGoodsManAndTime2) {
        this.fetchGoodsManAndTime2 = fetchGoodsManAndTime2;
    }

    @ExcelResources(title = "验货员",order = 11)
    public String getExamineGoodsManAndTime2() {
        accepReMan = accepReMan == null ? "" : accepReMan;
        examineGoodsManAndTime2 = accepReMan + ":" + DateUtil.formatForTime(accepReBegin)+"-"+DateUtil.formatForTime(accepReEnd);
        return examineGoodsManAndTime2;
    }

    public void setExamineGoodsManAndTime2(String examineGoodsManAndTime2) {
        this.examineGoodsManAndTime2 = examineGoodsManAndTime2;
    }

    @ExcelResources(title = "复核员",order = 12)
    public String getCheckGoodsManAndTime2() {
        accepCheckMan = accepCheckMan== null ? "" : accepCheckMan;
        checkGoodsManAndTime2 = accepCheckMan + ":" + DateUtil.formatForTime(accepCheckBegin)+"-"+DateUtil.formatForTime(accepCheckEnd);
        return checkGoodsManAndTime2;
    }

    public void setCheckGoodsManAndTime2(String checkGoodsManAndTime2) {
        this.checkGoodsManAndTime2 = checkGoodsManAndTime2;
    }

    @ExcelResources(title = "退单员",order = 13)
    public String getChargeBackManAndTime2() {
        accepBackMan = accepBackMan== null ?"" : accepBackMan;
        chargeBackManAndTime2 = accepBackMan + ":" + DateUtil.formatForTime(accepBackBegin)+"-"+DateUtil.formatForTime(accepBackEnd);
        return chargeBackManAndTime2;
    }

    public void setChargeBackManAndTime2(String chargeBackManAndTime2) {

        this.chargeBackManAndTime2 = chargeBackManAndTime2;
    }

    @ExcelResources(title = "理货上架",order = 14)
    public String getGroundingManAndTime2() {
        tallyMan = tallyMan == null ? "" : tallyMan;
        groundingManAndTime2 = tallyMan + ":" + DateUtil.formatForTime(tallyBegin)+"-"+DateUtil.formatForTime(tallyEnd);
        return groundingManAndTime2;
    }

    public void setGroundingManAndTime(String groundingManAndTime) {
        this.groundingManAndTime = groundingManAndTime;
    }

    public String getDistribno() {
        return distribno;
    }

    public void setDistribno(String distribno) {
        this.distribno = distribno;
    }

    public String getTransferno() {
        return transferno;
    }

    public void setTransferno(String transferno) {
        this.transferno = transferno;
    }
}