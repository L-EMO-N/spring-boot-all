package com.lemon.weixin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luolin on 2018/1/31.
 */
public class DateUtil {

    public static String getTimeStr(Date date){
        if(date == null){
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr  = format.format(date);
        return timeStr;
    }
}
