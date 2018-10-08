package com.geekcattle.model.console;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geekcattle.model.BaseEntity;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ExcelResources;
import com.geekcattle.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import javax.persistence.*;

@Table(name = "transfer_info")
public class TransferInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uid;

    /**
     * 业务单号
     */
    private String bizno;

    /**
     * 订货单位
     */
    private String orderunit;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date ordertime;

    @Column(name = "product_name")
    private String productName;

    private String unit;

    private Integer quantity;

    /**
     * 厂家
     */
    private String manufacture;

    /**
     * 调货单位
     */
    private String transferunit;

    /**
     * 调货人
     */
    private String transferman;

    /**
     * 调货开始
     */
    @Column(name = "transfer_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date transferTimeBegin;

    /**
     * 调货结束
     */
    @Column(name = "transfer_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date transferTimeEnd;

    /**
     * 拿货人
     */
    @Column(name = "fetch_goods_man")
    private String fetchGoodsMan;

    /**
     * 拿货开始
     */
    @Column(name = "fetch_goods_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date fetchGoodsBegin;

    @Column(name = "fetch_goods_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date fetchGoodsEnd;

    /**
     * 采购数据人
     */
    @Column(name = "data_man")
    private String dataMan;

    @Column(name = "data_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date dataTimeBegin;

    @Column(name = "data_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date dataTimeEnd;

    /**
     * 复核
     */
    @Column(name = "check_man")
    private String checkMan;

    @Column(name = "check_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date checkTimeBegin;

    @Column(name = "check_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date checkTimeEnd;

    @Column(name = "recheck_man")
    private String recheckMan;

    @Column(name = "recheck_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date recheckTimeBegin;

    @Column(name = "recheck_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date recheckTimeEnd;

    @Column(name = "pack_man")
    private String packMan;

    @Column(name = "pack_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date packTimeBegin;

    @Column(name = "pack_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date packTimeEnd;

    @Column(name = "delivery_man")
    private String deliveryMan;

    @Column(name = "delivery_time_begin")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date deliveryTimeBegin;

    @Column(name = "delivery_time_end")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date deliveryTimeEnd;

    @Column(name = "receive_address")
    private String receiveAddress;

    @Column(name = "receive_time")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date receiveTime;

    @Column(name = "receive_man")
    private String receiveMan;

    @Column(name = "receive_end_time")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date receiveEndTime;

    private Integer state;

    private String remark;

    private String billno;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date createtime;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date modifytime;

    private Integer recovery;

    @Column(name = "region_id")
    private Integer regionId;

    /**
     * 订货信息
     */
    @Transient
    private String orderinfor;

    /**
     * 调货信息
     */
    @Transient
    private String transferstartend;

    /**
     * 拿货信息
     */
    @Transient
    private String fetchstartend;

    /**
     * 开单信息
     */
    @Transient
    private String datastartend;

    /**
     * 验货信息
     */
    @Transient
    private String checkstartend;

    /**
     * 复核信息
     */
    @Transient
    private String recheckstartend;

    /**
     * 打包信息
     */
    @Transient
    private String packstartend;

    /**
     * 送货信息
     */
    @Transient
    private String diststartend;

    /**
     * 发出信息
     */
    @Transient
    private String shipinfor;


    /**
     * 到货信息
     */
    @Transient
    private String arriinfor;


    /**
     * 订货信息2
     */
    @Transient
    private String orderinfor2;

    /**
     * 调货信息2
     */
    @Transient
    private String transferstartend2;

    /**
     * 拿货信息2
     */
    @Transient
    private String fetchstartend2;

    /**
     * 开单信息2
     */
    @Transient
    private String datastartend2;

    /**
     * 验货信息2
     */
    @Transient
    private String checkstartend2;

    /**
     * 复核信息2
     */
    @Transient
    private String recheckstartend2;

    /**
     * 打包信息2
     */
    @Transient
    private String packstartend2;

    /**
     * 送货信息2
     */
    @Transient
    private String diststartend2;

    /**
     * 发出信息2
     */
    @Transient
    private String shipinfor2;


    /**
     * 到货信息2
     */
    @Transient
    private String arriinfor2;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取业务单号
     *
     * @return bizno - 业务单号
     */
    @ExcelResources(title = "调货单号",order = 3)
    public String getBizno() {
        return bizno;
    }

    /**
     * 设置业务单号
     *
     * @param bizno 业务单号
     */
    public void setBizno(String bizno) {
        this.bizno = bizno;
    }

    /**
     * 获取订货单位
     *
     * @return orderunit - 订货单位
     */
    //@ExcelResources(title = "订货单位",order = 2)
    public String getOrderunit() {
        return orderunit;
    }

    /**
     * 设置订货单位
     *
     * @param orderunit 订货单位
     */
    public void setOrderunit(String orderunit) {
        this.orderunit = orderunit;
    }

    /**
     * @return ordertime
     */
    //@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //@ExcelResources(title = "出货时间",order = 3)
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * @param ordertime
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * @return product_name
     */
    @ExcelResources(title = "产品名称",order = 5)
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * @return quantity
     */
    @ExcelResources(title = "数量",order = 7)
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取厂家
     *
     * @return manufacture - 厂家
     */
    @ExcelResources(title = "生产厂家",order = 8)
    public String getManufacture() {
        return manufacture;
    }

    /**
     * 设置厂家
     *
     * @param manufacture 厂家
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * 获取调货单位
     *
     * @return transferunit - 调货单位
     */
    //@ExcelResources(title = "调货单位",order = 8)
    public String getTransferunit() {
        return transferunit;
    }

    /**
     * 设置调货单位
     *
     * @param transferunit 调货单位
     */
    public void setTransferunit(String transferunit) {
        this.transferunit = transferunit;
    }

    /**
     * 获取调货人
     *
     * @return transferman - 调货人
     */
    //@ExcelResources(title = "调货人",order = 9)
    public String getTransferman() {
        return transferman;
    }

    /**
     * 设置调货人
     *
     * @param transferman 调货人
     */
    public void setTransferman(String transferman) {
        this.transferman = transferman;
    }

    /**
     * 获取调货开始
     *
     * @return transfer_time_begin - 调货开始
     */
    //@ExcelResources(title = "调货开始",order = 10)
    public Date getTransferTimeBegin() {
        return transferTimeBegin;
    }

    /**
     * 设置调货开始
     *
     * @param transferTimeBegin 调货开始
     */
    public void setTransferTimeBegin(Date transferTimeBegin) {
        this.transferTimeBegin = transferTimeBegin;
    }

    /**
     * 获取调货结束
     *
     * @return transfer_time_end - 调货结束
     */
    //@ExcelResources(title = "调货结束",order = 11)
    public Date getTransferTimeEnd() {
        return transferTimeEnd;
    }

    /**
     * 设置调货结束
     *
     * @param transferTimeEnd 调货结束
     */
    public void setTransferTimeEnd(Date transferTimeEnd) {
        this.transferTimeEnd = transferTimeEnd;
    }

    /**
     * 获取拿货人
     *
     * @return fetch_goods_man - 拿货人
     */
    //@ExcelResources(title = "拿货人",order = 12)
    public String getFetchGoodsMan() {
        return fetchGoodsMan;
    }

    /**
     * 设置拿货人
     *
     * @param fetchGoodsMan 拿货人
     */
    public void setFetchGoodsMan(String fetchGoodsMan) {
        this.fetchGoodsMan = fetchGoodsMan;
    }

    /**
     * 获取拿货开始
     *
     * @return fetch_goods_begin - 拿货开始
     */
    //@ExcelResources(title = "拿货开始",order = 13)
    public Date getFetchGoodsBegin() {
        return fetchGoodsBegin;
    }

    /**
     * 设置拿货开始
     *
     * @param fetchGoodsBegin 拿货开始
     */
    public void setFetchGoodsBegin(Date fetchGoodsBegin) {
        this.fetchGoodsBegin = fetchGoodsBegin;
    }

    /**
     * @return fetch_goods_end
     */
    //@ExcelResources(title = "拿货结束",order = 14)
    public Date getFetchGoodsEnd() {
        return fetchGoodsEnd;
    }

    /**
     * @param fetchGoodsEnd
     */
    public void setFetchGoodsEnd(Date fetchGoodsEnd) {
        this.fetchGoodsEnd = fetchGoodsEnd;
    }

    /**
     * 获取采购数据人
     *
     * @return data_man - 采购数据人
     */
    //@ExcelResources(title = "开单员",order = 15)
    public String getDataMan() {
        return dataMan;
    }

    /**
     * 设置采购数据人
     *
     * @param dataMan 采购数据人
     */
    public void setDataMan(String dataMan) {
        this.dataMan = dataMan;
    }

    /**
     * @return data_time_begin
     */
    //@ExcelResources(title = "开单开始",order = 16)
    public Date getDataTimeBegin() {
        return dataTimeBegin;
    }

    /**
     * @param dataTimeBegin
     */
    public void setDataTimeBegin(Date dataTimeBegin) {
        this.dataTimeBegin = dataTimeBegin;
    }

    /**
     * @return data_time_end
     */
    //@ExcelResources(title = "开单结束",order = 17)
    public Date getDataTimeEnd() {
        return dataTimeEnd;
    }

    /**
     * @param dataTimeEnd
     */
    public void setDataTimeEnd(Date dataTimeEnd) {
        this.dataTimeEnd = dataTimeEnd;
    }

    /**
     * 获取复核
     *
     * @return check_man - 复核
     */
    //@ExcelResources(title = "验货员",order = 18)
    public String getCheckMan() {
        return checkMan;
    }

    /**
     * 设置复核
     *
     * @param checkMan 复核
     */
    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    /**
     * @return check_time_begin
     */
    //@ExcelResources(title = "验货开始",order = 19)
    public Date getCheckTimeBegin() {
        return checkTimeBegin;
    }

    /**
     * @param checkTimeBegin
     */
    public void setCheckTimeBegin(Date checkTimeBegin) {
        this.checkTimeBegin = checkTimeBegin;
    }

    /**
     * @return check_time_end
     */
    //@ExcelResources(title = "验货结束",order = 20)
    public Date getCheckTimeEnd() {
        return checkTimeEnd;
    }

    /**
     * @param checkTimeEnd
     */
    public void setCheckTimeEnd(Date checkTimeEnd) {
        this.checkTimeEnd = checkTimeEnd;
    }

    /**
     * @return recheck_man
     */
    //@ExcelResources(title = "复核员",order = 21)
    public String getRecheckMan() {
        return recheckMan;
    }

    /**
     * @param recheckMan
     */
    public void setRecheckMan(String recheckMan) {
        this.recheckMan = recheckMan;
    }

    /**
     * @return recheck_time_begin
     */
    //@ExcelResources(title = "复核开始",order = 22)
    public Date getRecheckTimeBegin() {
        return recheckTimeBegin;
    }

    /**
     * @param recheckTimeBegin
     */
    public void setRecheckTimeBegin(Date recheckTimeBegin) {
        this.recheckTimeBegin = recheckTimeBegin;
    }

    /**
     * @return recheck_time_end
     */
    //@ExcelResources(title = "复核结束",order = 23)
    public Date getRecheckTimeEnd() {
        return recheckTimeEnd;
    }

    /**
     * @param recheckTimeEnd
     */
    public void setRecheckTimeEnd(Date recheckTimeEnd) {
        this.recheckTimeEnd = recheckTimeEnd;
    }

    /**
     * @return pack_man
     */
    //@ExcelResources(title = "打包员",order = 24)
    public String getPackMan() {
        return packMan;
    }

    /**
     * @param packMan
     */
    public void setPackMan(String packMan) {
        this.packMan = packMan;
    }

    /**
     * @return pack_time_begin
     */
    //@ExcelResources(title = "打包开始",order = 25)
    public Date getPackTimeBegin() {
        return packTimeBegin;
    }

    /**
     * @param packTimeBegin
     */
    public void setPackTimeBegin(Date packTimeBegin) {
        this.packTimeBegin = packTimeBegin;
    }

    /**
     * @return pack_time_end
     */
    //@ExcelResources(title = "打包结束",order = 26)
    public Date getPackTimeEnd() {
        return packTimeEnd;
    }

    /**
     * @param packTimeEnd
     */
    public void setPackTimeEnd(Date packTimeEnd) {
        this.packTimeEnd = packTimeEnd;
    }

    /**
     * @return delivery_man
     */
    //@ExcelResources(title = "送货员",order = 27)
    public String getDeliveryMan() {
        return deliveryMan;
    }

    /**
     * @param deliveryMan
     */
    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    /**
     * @return delivery_time_begin
     */
    //@ExcelResources(title = "送货开始",order = 28)
    public Date getDeliveryTimeBegin() {
        return deliveryTimeBegin;
    }

    /**
     * @param deliveryTimeBegin
     */
    public void setDeliveryTimeBegin(Date deliveryTimeBegin) {
        this.deliveryTimeBegin = deliveryTimeBegin;
    }

    /**
     * @return delivery_time_end
     */
    //@ExcelResources(title = "送货结束",order = 29)
    public Date getDeliveryTimeEnd() {
        return deliveryTimeEnd;
    }

    /**
     * @param deliveryTimeEnd
     */
    public void setDeliveryTimeEnd(Date deliveryTimeEnd) {
        this.deliveryTimeEnd = deliveryTimeEnd;
    }

    /**
     * @return receive_address
     */
    //@ExcelResources(title = "收货地址",order = 30)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    /**
     * @param receiveAddress
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    /**
     * @return receive_time
     */
    //@ExcelResources(title = "到货时间",order = 31)
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * @param receiveTime
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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
     * @return billno
     */
    public String getBillno() {
        return billno;
    }

    /**
     * @param billno
     */
    public void setBillno(String billno) {
        this.billno = billno;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return modifytime
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Date getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(Date receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }


    @ExcelResources(title = "订货单位-出货时间",order = 4)
    public String getOrderinfor2() {
        String ordertime1 = DateUtil.formatForTime(ordertime);
        orderinfor2 = orderunit == null ? "":orderunit;
        orderinfor2 = orderinfor2+""+ ordertime1;
        return orderinfor2;
    }

    public void setOrderinfor2(String orderinfor2) {
        this.orderinfor2 = orderinfor2;
    }

    @ExcelResources(title = "调货单位-调货信息",order = 9)
    public String getTransferstartend2() {
        String transferunit1 = transferunit == null ? "":transferunit;
        String transferman1 = transferman == null ? "":transferman;
        transferstartend2 = transferunit1+" | "+transferman1+""+DateUtil.formatForTime(transferTimeBegin)+"-"+DateUtil.formatForTime(transferTimeEnd);
        return transferstartend2;
    }

    public void setTransferstartend2(String transferstartend2) {
        this.transferstartend2 = transferstartend2;
    }

    @ExcelResources(title = "拿货",order = 10)
    public String getFetchstartend2() {
        String fetchGoodsMan1 = fetchGoodsMan == null ? "":fetchGoodsMan;
        fetchstartend2 = fetchGoodsMan1+""+DateUtil.formatForTime(fetchGoodsBegin)+"-"+DateUtil.formatForTime(fetchGoodsEnd);
        return fetchstartend2;
    }

    public void setFetchstartend2(String fetchstartend2) {
        this.fetchstartend2 = fetchstartend2;
    }

    @ExcelResources(title = "开单",order = 11)
    public String getDatastartend2() {
        String dataMan1 = dataMan == null ? "":dataMan;
        datastartend2 = dataMan1+""+DateUtil.formatForTime(dataTimeBegin)+"-"+DateUtil.formatForTime(dataTimeEnd);
        return datastartend2;
    }

    public void setDatastartend2(String datastartend2) {
        this.datastartend2 = datastartend2;
    }

    @ExcelResources(title = "验货",order = 12)
    public String getCheckstartend2() {
        String checkMan1 = checkMan == null ? "":checkMan;
        checkstartend2 = checkMan1+""+DateUtil.formatForTime(checkTimeBegin)+"-"+DateUtil.formatForTime(checkTimeEnd);
        return checkstartend2;
    }

    public void setCheckstartend2(String checkstartend2) {
        this.checkstartend2 = checkstartend2;
    }

    @ExcelResources(title = "复核",order = 13)
    public String getRecheckstartend2() {
        String recheckMan1 = recheckMan == null ? "":recheckMan;
        recheckstartend2 = recheckMan1+""+DateUtil.formatForTime(recheckTimeBegin)+"-"+DateUtil.formatForTime(recheckTimeEnd);
        return recheckstartend2;
    }

    public void setRecheckstartend2(String recheckstartend2) {
        this.recheckstartend2 = recheckstartend2;
    }

    @ExcelResources(title = "打包",order = 14)
    public String getPackstartend2() {
        String packMan1 = packMan == null ? "":packMan;
        packstartend2 = packMan1+""+DateUtil.formatForTime(packTimeBegin)+"-"+DateUtil.formatForTime(packTimeEnd);
        return packstartend2;
    }

    public void setPackstartend2(String packstartend2) {
        this.packstartend2 = packstartend2;
    }

    @ExcelResources(title = "送货",order = 15)
    public String getDiststartend2() {
        String deliveryMan1 = deliveryMan == null ? "":deliveryMan;
        diststartend2 = deliveryMan1+""+DateUtil.formatForTime(deliveryTimeBegin)+"-"+DateUtil.formatForTime(deliveryTimeEnd);
        return diststartend2;
    }

    public void setDiststartend2(String diststartend2) {
        this.diststartend2 = diststartend2;
    }

    @ExcelResources(title = "收货地址-发出时间",order = 16)
    public String getShipinfor2() {
        String receiveAddress1 = receiveAddress == null ? "":receiveAddress;
        shipinfor2 = receiveAddress1+""+DateUtil.formatForTime(receiveTime);
        return shipinfor2;
    }

    public void setShipinfor2(String shipinfor2) {
        this.shipinfor2 = shipinfor2;
    }


    @ExcelResources(title = "收货人-到货时间",order = 17)
    public String getArriinfor2() {
        String receiveMan1 = receiveMan == null ? "":receiveMan;
        arriinfor2 = receiveMan1+""+DateUtil.formatForTime(receiveEndTime);
        return arriinfor2;
    }

    public void setArriinfor2(String arriinfor2) {
        this.arriinfor2 = arriinfor2;
    }


    public String getOrderinfor() {
        String ordertime1 = DateUtil.formatForTime(ordertime);
        orderinfor = orderunit == null ? "":orderunit;
        orderinfor = orderinfor+"</br>"+ ordertime1;
        return orderinfor;
    }

    public void setOrderinfor(String orderinfor) {
        this.orderinfor = orderinfor;
    }

    public String getTransferstartend() {
        String transferunit1 = transferunit == null ? "":transferunit;
        String transferman1 = transferman == null ? "":transferman;
        transferstartend = "<div>"+transferunit1+" | "+transferman1+"</div><div>"+DateUtil.formatForTime(transferTimeBegin)+"-"+DateUtil.formatForTime(transferTimeEnd)+"</div>";
        return transferstartend;
    }

    public void setTransferstartend(String transferstartend) {
        this.transferstartend = transferstartend;
    }

    public String getFetchstartend() {
        String fetchGoodsMan1 = fetchGoodsMan == null ? "":fetchGoodsMan;
        fetchstartend = "<div>"+fetchGoodsMan1+"</div><div>"+DateUtil.formatForTime(fetchGoodsBegin)+"-"+DateUtil.formatForTime(fetchGoodsEnd)+"</div>";
        return fetchstartend;
    }

    public void setFetchstartend(String fetchstartend) {
        this.fetchstartend = fetchstartend;
    }

    public String getDatastartend() {
        String dataMan1 = dataMan == null ? "":dataMan;
        datastartend = "<div>"+dataMan1+"</div><div>"+DateUtil.formatForTime(dataTimeBegin)+"-"+DateUtil.formatForTime(dataTimeEnd)+"</div>";
        return datastartend;
    }

    public void setDatastartend(String datastartend) {
        this.datastartend = datastartend;
    }

    public String getCheckstartend() {
        String checkMan1 = checkMan == null ? "":checkMan;
        checkstartend = "<div>"+checkMan1+"</div><div>"+DateUtil.formatForTime(checkTimeBegin)+"-"+DateUtil.formatForTime(checkTimeEnd)+"</div>";
        return checkstartend;
    }

    public void setCheckstartend(String checkstartend) {
        this.checkstartend = checkstartend;
    }

    public String getRecheckstartend() {
        String recheckMan1 = recheckMan == null ? "":recheckMan;
        recheckstartend = "<div>"+recheckMan1+"</div><div>"+DateUtil.formatForTime(recheckTimeBegin)+"-"+DateUtil.formatForTime(recheckTimeEnd)+"</div>";
        return recheckstartend;
    }

    public void setRecheckstartend(String recheckstartend) {
        this.recheckstartend = recheckstartend;
    }

    public String getPackstartend() {
        String packMan1 = packMan == null ? "":packMan;
        packstartend = "<div>"+packMan1+"</div><div>"+DateUtil.formatForTime(packTimeBegin)+"-"+DateUtil.formatForTime(packTimeEnd)+"</div>";
        return packstartend;
    }

    public void setPackstartend(String packstartend) {
        this.packstartend = packstartend;
    }

    public String getDiststartend() {
        String deliveryMan1 = deliveryMan == null ? "":deliveryMan;
        diststartend = "<div>"+deliveryMan1+"</div><div>"+DateUtil.formatForTime(deliveryTimeBegin)+"-"+DateUtil.formatForTime(deliveryTimeEnd)+"</div>";
        return diststartend;
    }

    public void setDiststartend(String diststartend) {
        this.diststartend = diststartend;
    }

    public String getShipinfor() {
        String receiveAddress1 = receiveAddress == null ? "":receiveAddress;
        shipinfor = "<div>"+receiveAddress1+"</div><div>"+DateUtil.formatForTime(receiveTime)+"</div>";
        return shipinfor;
    }

    public void setShipinfor(String shipinfor) {
        this.shipinfor = shipinfor;
    }


    public String getArriinfor() {
        String receiveMan1 = receiveMan == null ? "":receiveMan;
        arriinfor = "<div>"+receiveMan1+"</div><div>"+DateUtil.formatForTime(receiveEndTime)+"</div>";
        return arriinfor;
    }

    public void setArriinfor(String arriinfor) {
        this.arriinfor = arriinfor;
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
}