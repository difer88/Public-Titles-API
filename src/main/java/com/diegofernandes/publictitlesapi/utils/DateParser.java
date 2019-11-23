package com.diegofernandes.publictitlesapi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static Date fileStringDateToDataBaseDateTime(String fileDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        Date dateParsed = null;

        try {
            dateParsed = formatter.parse(fileDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateParsed;
    }

}
