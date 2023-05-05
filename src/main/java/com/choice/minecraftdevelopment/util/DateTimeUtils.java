package com.choice.minecraftdevelopment.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String getCurrentDateTimeString() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(formatter);
    }
}

