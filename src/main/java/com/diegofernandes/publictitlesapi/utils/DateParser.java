package com.diegofernandes.publictitlesapi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static Date fileStringDateToDataBaseDateTime(String fileDate) {

        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date dateParsed = null;

        try {
            dateParsed = formatter.parse(fileDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateParsed;
    }

    public static String DataBaseDateTimeToStringDate(Date dataBaseDate){

        Instant instant = dataBaseDate.toInstant();

        LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String dateParsed = ldt.format(fmt);

        return dateParsed;

    }

}
