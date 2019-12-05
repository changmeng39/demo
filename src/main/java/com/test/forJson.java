package com.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class forJson {
    public static void main(String[] args) {

        String s = "a,b,c,d";

        s = s.replace(",", "|");

        System.out.println(s);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt1 = System.currentTimeMillis();
        Date date1 = new Date(lt1);
        String time1 = simpleDateFormat.format(date1);
        System.out.println(time1);

        long lt2 = lt1 - (1000 * 60 + 1000);
        Date date2 = new Date(lt2);
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);

        boolean b = lt1 - lt2 <= 1000 * 60;

        System.out.println(lt1 - lt2);
        System.out.println(b);

        System.out.println("///////////////////////////////////////////////////////////////");

        String str = "{a:'',b:'2'}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);

        String str1 = "userId=";
        String[] splits = str1.split("=", -1);
        for(int i=0;i<splits.length;i++){
            System.err.println(splits[i]);
        }

        String str2 = "vin=11111";
        System.out.println(str1.endsWith("="));

        System.out.println(str2.endsWith("="));

        System.err.println(jsonObject.toString());

        System.err.println(jsonObject.toJSONString());

        String str11 = "vehicle_id=null, vin=1G1BL52P7TR115599, color=红色, vehicleClassCode=null, vClass=null, vtypeid=1, useType=null, licenseNumber=null, userName=null, userId=null, userPhone=null, tsTypeId=null, tsConfigName=null, tsTimeLimit=null, vehicleTsStatus=null, communicationPackage=null, tsStartDate=null, tId=2434, iccid=14526987541256325521, huId=null, batteryId=null, brandCode=null, brand=null, purchaseDate=null, vehicleConfig=null, yearModel=null, provinceCode=null, cityCode=null, appUserId=null, renew=null, dateScreening=null, expire=null, parkService=0";
        System.out.println(str11.concat("vin"));

        String a = new String();
        System.out.println("aaaaa:  " + StringUtils.isEmpty(a));

        double fee = Double.parseDouble(null);
    }
}
