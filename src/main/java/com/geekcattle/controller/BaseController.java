package com.geekcattle.controller;

import com.geekcattle.model.console.Admin;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    public Admin getLoginUser(){

        return (Admin) SecurityUtils.getSubject().getPrincipal();
    }
    public Admin getCurrentUser(){
        return getLoginUser();
    }

}
