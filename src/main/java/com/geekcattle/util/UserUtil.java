package com.geekcattle.util;

import com.geekcattle.model.console.Admin;
import org.apache.shiro.SecurityUtils;

public class UserUtil {

    public static Admin getLoginUser(){
        return (Admin) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getLoginUserUid(){
        Admin admin = getLoginUser();
        if(admin != null){
            return admin.getUid();
        }
        return "";
    }
    public static String getLoginUserName (){
        Admin admin = getLoginUser();
        if(admin != null){
            return admin.getUsername();
        }
        return "";
    }

    public static Admin getCurrentUser(){
       return getLoginUser();
    }

}
