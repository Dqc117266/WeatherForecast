package com.dqc.weatherforecast.presentation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String[] getFriendlyDateStrings(String dateStr, String currentDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat monthDayFormat = new SimpleDateFormat("MM/dd");

        try {
            Date date = dateFormat.parse(dateStr);
            Date currentDate = dateTimeFormat.parse(currentDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);

            // Remove time part for comparison
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);
            currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
            currentCalendar.set(Calendar.MINUTE, 0);
            currentCalendar.set(Calendar.SECOND, 0);
            currentCalendar.set(Calendar.MILLISECOND, 0);

            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(date);
            targetCalendar.set(Calendar.HOUR_OF_DAY, 0);
            targetCalendar.set(Calendar.MINUTE, 0);
            targetCalendar.set(Calendar.SECOND, 0);
            targetCalendar.set(Calendar.MILLISECOND, 0);

            // Calculate difference in days
            long diff = (targetCalendar.getTimeInMillis() - currentCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
            String relativeDate;

            if (diff == 0) {
                relativeDate = "今天";
            } else if (diff == 1) {
                relativeDate = "明天";
            } else {
                switch (targetCalendar.get(Calendar.DAY_OF_WEEK)) {
                    case Calendar.SUNDAY:
                        relativeDate = "周日";
                        break;
                    case Calendar.MONDAY:
                        relativeDate = "周一";
                        break;
                    case Calendar.TUESDAY:
                        relativeDate = "周二";
                        break;
                    case Calendar.WEDNESDAY:
                        relativeDate = "周三";
                        break;
                    case Calendar.THURSDAY:
                        relativeDate = "周四";
                        break;
                    case Calendar.FRIDAY:
                        relativeDate = "周五";
                        break;
                    case Calendar.SATURDAY:
                        relativeDate = "周六";
                        break;
                    default:
                        relativeDate = "";
                }
            }

            String formattedDate = monthDayFormat.format(date);
            return new String[]{relativeDate, formattedDate};

        } catch (ParseException e) {
            e.printStackTrace();
            return new String[]{"", ""};
        }
    }
}
