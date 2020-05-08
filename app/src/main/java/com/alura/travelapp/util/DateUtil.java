package com.alura.travelapp.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static final String MONTH_DAY = "MM/dd";

    public static String tripLengthToString(int days) {
        Calendar departureDay = Calendar.getInstance();
        Calendar arrivalDay = Calendar.getInstance();
        arrivalDay.add(Calendar.DATE, days);
        SimpleDateFormat dateFormatEn = new SimpleDateFormat(MONTH_DAY);
        String formattedDepartureDay = dateFormatEn.format(departureDay.getTime());
        String formattedArrivalDay = dateFormatEn.format(arrivalDay.getTime());
        return formattedDepartureDay + " - "
                + formattedArrivalDay + " de "
                + arrivalDay.get(Calendar.YEAR);
    }
}
