package com.diegofernandes.publictitlesapi.utils;

import com.diegofernandes.publictitlesapi.constants.CommonConstants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.getDefault());

        formatter.format(dataBaseDate);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(dataBaseDate);

        StringBuilder sb = new StringBuilder();

        sb.append(calendar.get(Calendar.DAY_OF_MONTH))
                .append(CommonConstants.DATE_BAR_SEPARATOR)
                .append(calendar.get(Calendar.MONTH))
                .append(CommonConstants.DATE_BAR_SEPARATOR)
                .append(calendar.get(Calendar.YEAR))
                .append(CommonConstants.SPACE_SEPARATOR)
                .append(calendar.get(Calendar.HOUR_OF_DAY))
                .append(CommonConstants.HOUR_SEPARATOR)
                .append(calendar.get(Calendar.MINUTE))
                .append(CommonConstants.HOUR_SEPARATOR)
                .append(CommonConstants.ZERO_SECONDS);

        return sb.toString();

    }

}
