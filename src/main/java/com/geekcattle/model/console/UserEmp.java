package com.geekcattle.model.console;

import javax.persistence.*;

@Table(name = "user_emp")
public class UserEmp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录用户的ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 员工ID
     */
    @Column(name = "emp_id")
    private Integer empId;

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
     * 获取登录用户的ID
     *
     * @return user_id - 登录用户的ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置登录用户的ID
     *
     * @param userId 登录用户的ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取员工ID
     *
     * @return emp_id - 员工ID
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置员工ID
     *
     * @param empId 员工ID
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}