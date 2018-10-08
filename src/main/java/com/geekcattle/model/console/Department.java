package com.geekcattle.model.console;

import com.geekcattle.model.BaseEntity;

import javax.persistence.*;

public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "dept_desc")
    private String deptDesc;

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
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * @return dept_desc
     */
    public String getDeptDesc() {
        return deptDesc;
    }

    /**
     * @param deptDesc
     */
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }
}