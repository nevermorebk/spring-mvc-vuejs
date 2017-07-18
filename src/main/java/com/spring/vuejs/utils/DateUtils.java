/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.spring.vuejs.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Author : Quang Tran Dang
 * Email: quang.trandang@homedirect.com
 * 18/07/2017
 */


public class DateUtils {
    public static final String ddMMyyyy = "dd/MM/yyyy";
    public static final String ddMMyyyyHHmmSS = "dd/MM/yyyy HH:mm:ss";
    public static final String HHmmSSddMMyyyy = "HH:mm:ss dd/MM/yyyy";
    public static final String DATE_TIME_MYSQL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String HHmmddMM = "HH:mm dd/MM";

    public static Date toBeginDate(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        toBeginDate(cal);
        date = cal.getTime();
        return date;
    }

    public static Date toEndDate(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        toEndDate(cal);
        date = cal.getTime();
        return date;
    }

    public static void toBeginDate(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    public static void toEndDate(Calendar cal) {
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
    }


    public static Date toDate(String strDate, String format){
        if(StringUtils.isEmpty(strDate)) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            return toEndDate(sdf.parse(strDate));
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date fromDate(String strDate, String format){
        if(StringUtils.isEmpty(strDate)) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            return toBeginDate(sdf.parse(strDate));
        } catch (ParseException e) {
            return new Date();
        }
    }


    public static String toDateString(Date date, String format){
        if(date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String toDateTimeMySQLString(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_MYSQL_FORMAT);
        return sdf.format(date);
    }
}