package com.ksimeo.givorost.core.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Ksimeo. Created on 17.02.17 at 19:58 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class DatesHelper {

    public static final SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yy HH:mm");

    public static String format(Calendar calendar) {
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    public static String format(Date date) {
        return fmt.format(date);
    }

    public static String format(java.sql.Date date) {
        return fmt.format(date);
    }

    public static Calendar parseToCalendar(String date) {
        return fmt.getCalendar();
    }

    public static Calendar parseToCalendar(java.sql.Date date) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    public static Date parseToDate(String date) {
        try {
            return fmt.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date parseToSQLDate(String date) {
        try {
            Date time = fmt.parse(date);
            return new java.sql.Date(time.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date parseToSQLDate(Calendar date) {
        return new java.sql.Date(date.getTimeInMillis());
    }

    public static java.sql.Date parseToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Date parseToDate(Calendar date) {
        return new Date(date.getTimeInMillis());
    }

    public static Date getDate() {
       return new Date();
    }

    public static java.sql.Date getSQLDate() {
        return new java.sql.Date(new Date().getTime());
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static LocalDateTime getLocalDate() {
        return LocalDateTime.now();
    }
}