package com.alura.travelapp.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceUtil {

    public static final String LANGUAGE = "en";
    public static final String COUNTRY = "us";
    public static final String RECEIVED = "$";
    public static final String CHANGED = "$ ";

    public static String formatPriceToCad(BigDecimal price) {
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(
                new Locale(LANGUAGE, COUNTRY));
        return currencyInstance
                .format(price)
                .replace(RECEIVED, CHANGED);
    }
}
