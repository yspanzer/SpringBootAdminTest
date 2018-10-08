package com.geekcattle.model;

import javax.persistence.*;

public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer incharge;

    @Transient
    private String inchargeName;

    private String remark;

    @Column(name = "receipt_addr")
    private String receiptAddr;

    @Column(name = "deliver_addr")
    private String deliverAddr;

    @Column(name = "region_id")
    private Integer regionId;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return incharge
     */
    public Integer getIncharge() {
        return incharge;
    }

    /**
     * @param incharge
     */
    public void setIncharge(Integer incharge) {
        this.incharge = incharge;
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
     * @return receipt_addr
     */
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
     * @return deliver_addr
     */
    public String getDeliverAddr() {
        return deliverAddr;
    }

    /**
     * @param deliverAddr
     */
    public void setDeliverAddr(String deliverAddr) {
        this.deliverAddr = deliverAddr;
    }

    /**
     * @return region_id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getInchargeName() {
        return inchargeName;
    }

    public void setInchargeName(String inchargeName) {
        this.inchargeName = inchargeName;
    }
}