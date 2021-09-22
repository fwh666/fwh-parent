package club.fuwenhao.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * CLASSNAME DistanceAlgorithmUtils
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/11/26 18:42
 * @Version 1.0
 */
public class DistanceAlgorithmUtils {

    public static String getDistanceAlgorithm(LocalDateTime auditTime) {
//        if (ObjectUtils.isEmpty(auditTime)) {
//            return "";
//        }
        LocalDateTime end = LocalDateTime.now();
        LocalDate startLocalDate = auditTime.toLocalDate();
        LocalDate endLocalDate = end.toLocalDate();
        Duration between = Duration.between(auditTime, end);
        long toMinutes = between.toMinutes();
        long tohours = between.toHours();
        if (toMinutes < 60) {
            if (startLocalDate.compareTo(endLocalDate) != 0) {
                return String.format(ArticlePublishConstant.DAYS,1);
            }
            return String.format(ArticlePublishConstant.MINUTES,toMinutes);
        }
        if (toMinutes >= 60 && tohours < 24) {
            if (startLocalDate.compareTo(endLocalDate) != 0) {
                return String.format(ArticlePublishConstant.DAYS,1);
            }
            return String.format(ArticlePublishConstant.HOURS,tohours);
        }
        LocalDateTime min = auditTime.toLocalDate().atTime(0,0,0);
        Duration daysBetween = Duration.between(min, end);
        long toDays = daysBetween.toDays();
        if (tohours >= 24 && toDays <= 3) {
            return String.format(ArticlePublishConstant.DAYS,toDays);
        }
        return auditTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


//    public static String secToTime(Integer date ) {
//        if (date<60) {
//            return "00:"+date;
//        }else if (date>60&&date<3600) {
//            int m = date/60;
//            int s = date%60;
//            return m+":"+s+":";
//        }else {
//            int h = date/3600;
//            int m = (date%3600)/60;
//            int s = (date%3600)%60;
//            return h+":"+m+":"+s+":";
//        }
//
//    }


//    public static String intToDate(Integer time) {
//        String timeStr = null;
//        int hour = 0;
//        int minute = 0;
//        int second = 0;
//        if (time <= 0)
//            return "00:00";
//        else {
//            minute = time / 60;
//            if (minute < 60) {
//                second = time % 60;
//                timeStr = unitFormat(minute) + ":" + unitFormat(second);
//            } else {
//                hour = minute / 60;
//                if (hour > 99)
//                    return "59:59:99";
//                minute = minute % 60;
//                second = time - hour * 3600 - minute * 60;
//                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
//            }
//        }
//        return timeStr;
//    }
//
//    private static String unitFormat(int i) {
//        String retStr = null;
//        if (i >= 0 && i < 10)
//            retStr = "0" + i;
//        else
//            retStr = "" + i;
//        return retStr;
//    }

    public static String intToDate(Integer time) {
        long interval = (long) time;
        String hms = "00:00";
        if(interval == 0){
            return hms;
        }
        if(interval >= 3600000){
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            hms = formatter.format(interval);
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");//初始化Formatter的转换格式。
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            hms = formatter.format(interval);
        }
        return hms;
    }

}
