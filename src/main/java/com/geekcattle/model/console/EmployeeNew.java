package com.geekcattle.model.console;

import com.geekcattle.model.BaseEntity;

import javax.persistence.*;

@Table(name = "employee_new")
public class EmployeeNew  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    /**
     * 员工编号
     */
    @Column(name = "emp_code")
    private String empCode;

    @Column(name = "emp_name")
    private String empName;

    /**
     * 员工描述

     */
    @Column(name = "emp_desc")
    private String empDesc;

    /**
     * 是否在岗
     */
    @Column(name = "emp_state")
    private Integer empState;

    @Column(name = "dept_id")
    private Integer deptID;

    @Column(name = "region_id")
    private Integer regionID;


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
     * 获取员工编号
     *
     * @return emp_code - 员工编号
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * 设置员工编号
     *
     * @param empCode 员工编号
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    /**
     * @return emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取员工描述

     *
     * @return emp_desc - 员工描述

     */
    public String getEmpDesc() {
        return empDesc;
    }

    /**
     * 设置员工描述

     *
     * @param empDesc 员工描述

     */
    public void setEmpDesc(String empDesc) {
        this.empDesc = empDesc;
    }

    /**
     * 获取是否在岗
     *
     * @return emp_state - 是否在岗
     */
    public Integer getEmpState() {
        return empState;
    }

    /**
     * 设置是否在岗
     *
     * @param empState 是否在岗
     */
    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

}