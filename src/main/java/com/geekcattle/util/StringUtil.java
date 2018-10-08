package com.geekcattle.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static  String null2String(String obj){
        return StringUtils.defaultIfBlank(obj,"");
    }
    public static String startTimeToEnd(String startTime,String endTime){

        String begin = StringUtils.substring(startTime,11,16);
        begin=StringUtils.defaultIfBlank(begin,"");
        String end = StringUtils.substring(endTime,11,16);
        end=StringUtils.defaultIfBlank(end,"");
        return begin +"-"+end;
    }
}
