package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.DateUtils;

import java.io.FileOutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class InThisDate {

    /**
     * 判断时间是否在某个时间段内
     * @param nowDate 需要判断的时间,形如23:30:00
     * @param startDate 时间段开始时间,形如22:30:00
     * @param  endDate 时间段结束时间,形如06:00:00
     * @return boolean
     */
    public static boolean isInTimeRange(String nowDate,String startDate,String endDate){
        int set = Integer.valueOf(nowDate.replaceAll(":",""));
        int begin = Integer.valueOf(startDate.replaceAll(":",""));
        int end = Integer.valueOf(endDate.replaceAll(":",""));
        System.out.println("set```" + set);
        System.out.println("begin```" + begin);
        System.out.println("end```" + end);
        if (begin < end){
            System.out.println("同一天");
            return set < end && set > begin;
        } else {
            System.out.println("跨天");
            return set < end || set > begin;
        }
    }

    /**
     * 比较当前时间 是否在timeArray 范围内
     * @param timezone 时区
     * @param timeArray 开始时间，结束时间
     * @return
     */
    public static boolean isInDate(Date now,String[] timeArray,String pattern,String timezone){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        sdf.setTimeZone(timeZone);
        //转换为对应时区时间
        Date date = StringToDate(sdf.format(now),pattern);

        Date start = StringToDate(timeArray[0],pattern);
        Date end = StringToDate(timeArray[1],pattern);

        if (start.after(end) || start.equals(end)) {
            /**
             * 直接用时间判断
             */
            if (date.getTime() >= start.getTime() || date.getTime() <= end.getTime()) {
                return true;
            }

        }else {
            if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
                return true;
            }
        }
        return false;
    }

    public static String DateToString(Date source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    public static Date StringToDate(String date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        return simpleDateFormat.parse(date, pos);
    }

    public static String aaa(){
        if (1==1){
            return null;
        }
        return "aaa";
    }

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("时间" + String.valueOf(System.currentTimeMillis()));

        User user = new User();
        System.out.println("id```````````````" + user.getId());
        System.out.println("user is null" + user.toString());

        String nowTime = DateToString(new Date(), "yyyy-MM-dd HH:mm:ss");

        System.out.println(nowTime);

        if (1 == 1){
            return;
        }


        System.err.println(new Date().getTime());

        String shuzi = "123456abcdef";
        System.out.println(shuzi.replaceAll("\\d", "*"));
        System.out.println(shuzi.replace("\\d", "*"));


        String str = "{userId=74631264, vin=1G1BL52P7TR116643, beginTime=05:00, endTime=13:20, beginTimeForLong=1555016400000, endTimeForLong=1555046400000, cycleType=, cycleSwitch=0, createTime=1554802730432, updateTime=1554962774257}";

        str = str.replace("{","").replace("}","");

        String[] arr = str.split(","); // 用,分割
        for (int i=0;i<arr.length;i++){
            System.err.println("转换之前" + arr[i]);
            String s1 = arr[i].split("=")[0];
            String s2 = "";
            if (!arr[i].endsWith("=") && !arr[i].endsWith(" ")){
                s2 = arr[i].split("=")[1];
            }

            arr[i] = s1 + ":" + "'" + s2 + "'";
            System.out.println("字符串转换数组" + arr[i]);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length;i++){
            if (i == arr.length -1){
                sb.append(arr[i]);
            }else {
                sb.append(arr[i] + ",");
            }
        }
        String str1 = sb.toString();


        System.out.println("str1`````" + str1);

        JSONObject jsonObject = JSONObject.parseObject("{" + str1 + "}");
        System.err.println(jsonObject);

        //String类型转为Date
        String dateString = "2018-10-25 12:12:36";
        //注意String的格式要与simpleDateFormat设置的格式相同！
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date date1 = simpleDateFormat.parse(dateString, pos);

        System.err.println("date1```" + date1);



        Date date = new Date(Long.parseLong("1554790680000"));

        String remind = DateToString(date, "yyyy-MM-dd HH:mm:ss");

        System.out.println("remind`````" + remind);

        String aa = "liao123456";

        String bb = "     ";

        System.out.println(bb.length());
        String m = ":00";
        System.err.println("isInTimeRange```````````" + isInTimeRange("17:00:00","23:25" + m,"8:30" + m));

        long timestamp = System.currentTimeMillis();
        SimpleDateFormat format =  new SimpleDateFormat("HH:mm"); //设置格式
        String timeText=format.format(timestamp);
        System.out.println(timeText);

        String s = JSONObject.toJSONString("");
        System.err.println(s);

        String s1 = JSONArray.toJSONString(null);
        System.err.println(s1);
    }
}
