package com.geekcattle.model.console;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TransferReceipt extends TransferInfo {

    //收货单号
    private String receiptNum;

    //收货单发货单位
    private String deliveryUnit;

    //收货单接货时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    private Date deliveryTime;

    //收货单品名
    private String rproductname;

    //收货单厂家
    private String rfactory;

    //收货单单位
    private String runit;

    //收货单数量
    private BigDecimal rnumber;

    //收货单接货地址
    private String rreceiptAddr;

    //收货单状态
    private Integer rstate;

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getDeliveryUnit() {
        return deliveryUnit;
    }

    public void setDeliveryUnit(String deliveryUnit) {
        this.deliveryUnit = deliveryUnit;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRproductname() {
        return rproductname;
    }

    public void setRproductname(String rproductname) {
        this.rproductname = rproductname;
    }

    public String getRfactory() {
        return rfactory;
    }

    public void setRfactory(String rfactory) {
        this.rfactory = rfactory;
    }

    public String getRunit() {
        return runit;
    }

    public void setRunit(String runit) {
        this.runit = runit;
    }

    public BigDecimal getRnumber() {
        return rnumber;
    }

    public void setRnumber(BigDecimal rnumber) {
        this.rnumber = rnumber;
    }

    public String getRreceiptAddr() {
        return rreceiptAddr;
    }

    public void setRreceiptAddr(String rreceiptAddr) {
        this.rreceiptAddr = rreceiptAddr;
    }

    public Integer getRstate() {
        return rstate;
    }

    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }
}