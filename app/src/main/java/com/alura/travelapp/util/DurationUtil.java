package com.alura.travelapp.util;

public class DurationUtil {

    public static final String PLURAL = " days";
    public static final String SINGULAR = " day";

    public static String formatDaysToString(int days) {
        if (days > 1) {
            return days + PLURAL;
        }
        return days + SINGULAR;
    }
}
