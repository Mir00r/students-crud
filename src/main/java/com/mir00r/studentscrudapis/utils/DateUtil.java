package com.mir00r.studentscrudapis.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
public class DateUtil {
    public static String DATE_PATTERN_READABLE = "MMM dd, YYYY";

    public static String getReadableDate(Date date) {
        return getReadableDateFormat().format(date);
    }

    public static DateFormat getReadableDateFormat() {
        return new SimpleDateFormat(DATE_PATTERN_READABLE);
    }
}
