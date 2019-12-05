package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.HashMap;

public class aiwaysTspMain {

    public void HttpClientGet() throws Exception {

        // 获取http客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过httpget方式来实现我们的get请求
        HttpGet httpGet = new HttpGet("https://wecloudapi.autoai.com/parkingLot/p4/memberBook/payPage?deviceId=1104a89792febb703aa&id=3202065495&type=alipay&openId=20o-VQQtyU_pRp0_UZkLSERY23Edux&apiKey=42050e25a65c4fdbbb0d0154449494a2");
        // 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
        CloseableHttpResponse Response = client.execute(httpGet);
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 所有的响应的数据，也全部都是封装在HttpEntity里面
        HttpEntity entity = Response.getEntity();
        // 通过EntityUtils 来将我们的数据转换成字符串
        String str = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(str);
        // 关闭
        Response.close();
        System.err.println(jsonObject.get("status"));
        System.err.println(jsonObject.get("error"));
        System.err.println("500".equals(jsonObject.getString("status")));

        // EntityUtils.toString(entity)
        System.err.println(str);
    }



    public static void main(String[] args) throws Exception {

JSONObject jsonObject = JSONObject.parseObject("{\"callBackType\":\"carout\",\"deviceId\":\"18640289942\",\"entranceTime\":\"2019-10-12 16:55:21\",\"exitTime\":\"2019-10-12 16:58:00\",\"fixParkingId\":\"\",\"parkId\":\"1002559\",\"parkName\":\"开放平台测试车场\",\"plateNumber\":\"京LDD1888\",\"pushTime\":\"2019-10-12 16:58:00\",\"receivableFee\":\"0.0\",\"remainingDays\":\"\",\"stayedTime\":159,\"synId\":\"453C40D0-BFB6-4061-92ED-A077945083EC\",\"userType\":\"77\"}");
        System.err.println("0.0".equals(jsonObject.getString("receivableFee")));

        System.err.println(Double.parseDouble(jsonObject.getString("receivableFee")) == 0);

        JSONObject jsonObject1 = JSONObject.parseObject("{\n" +
                "\"code\": 0,\n" +
                "\"data\": [\n" +
                "{\n" +
                "\"payType\": \"3\",\n" +
                "\"carNo\": \"辽A89890\",\n" +
                "\"status\": \"1\"\n" +
                "}\n" +
                "],\n" +
                "\"message\": \"success\"\n" +
                "}");



        JSONObject jsonObject2 = JSONObject.parseObject("{\n" +
                "\t\"code\": 0,\n" +
                "\t\"data\": [{\n" +
                "\t\t\"thirdParty\": null,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"tel\": null,\n" +
                "\t\t\"carNo\": \"辽A89890\",\n" +
                "\t\t\"name\": null,\n" +
                "\t\t\"email\": null,\n" +
                "\t\t\"icon\": null,\n" +
                "\t\t\"point\": null,\n" +
                "\t\t\"recommendCode\": null,\n" +
                "\t\t\"recommenderId\": null,\n" +
                "\t\t\"city\": null,\n" +
                "\t\t\"cityName\": null,\n" +
                "\t\t\"province\": null,\n" +
                "\t\t\"provinceName\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"loginTime\": null,\n" +
                "\t\t\"loginIP\": null,\n" +
                "\t\t\"loginDeviceId\": null,\n" +
                "\t\t\"referer\": null,\n" +
                "\t\t\"refererId\": null,\n" +
                "\t\t\"status\": 0,\n" +
                "\t\t\"statusName\": null,\n" +
                "\t\t\"token\": null,\n" +
                "\t\t\"deviceId\": null,\n" +
                "\t\t\"payType\": \"1\"\n" +
                "\t}],\n" +
                "\t\"message\": \"success\"\n" +
                "}");

        System.out.println(jsonObject1.get("code"));

        JSONArray jsonArray1 = JSONArray.parseArray(jsonObject1.getString("data"));

        jsonArray1.forEach(j1->{
            JSONObject jsonObject11 = JSONObject.parseObject(j1.toString());
            System.out.println(jsonObject11.get("carNo"));
        });

        System.out.println(jsonObject2.get("code"));

        JSONArray jsonArray2 = JSONArray.parseArray(jsonObject2.getString("data"));

        jsonArray2.forEach(j2->{
            JSONObject jsonObject22 = JSONObject.parseObject(j2.toString());
            System.out.println(jsonObject22.get("carNo"));
        });

        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2019-01-31 13:46:50");
        long ts = date.getTime();
        res = String.valueOf(ts);
        System.out.println(res);

        System.out.println(System.currentTimeMillis());

        String aa = " https://wecloudapi.autoai.com/parkingLot/p4/memberBook/payPage?deviceId=1104a89792febb703aa&id=3202065495&type=alipay&openId=";

        System.err.println("aa" + aa.length());

        aiwaysTspMain at = new aiwaysTspMain();
        at.HttpClientGet();

        System.err.println("--------------------------------------------------");

        System.out.println(new Date().getTime());
        LocalTime now = LocalTime.now()/*.withNano(0)*/;
        System.out.println(now);
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.err.println(today + " " + now);

        LocalTime lt = LocalTime.now().withMinute(10);
        System.out.println(lt);

//        String url = "https://wecloudapi.autoai.com/parkingLot/p4/memberBook/payPage?deviceId={deviceId}&id={id}&type={type}&openId={openId}&apiKey={apiKey}";
        String url = "https://wecloudapi.autoai.com/parkingLot/p4/memberBook/payPage?deviceId=1104a89792febb703aa&id=3202065495&type=alipay&openId=20o-VQQtyU_pRp0_UZkLSERY23Edux&apiKey=42050e25a65c4fdbbb0d0154449494a2";
//        String url = "https://wecloudapi.autoai.com/parkingLot/p4/memberBook/payPage/";
//        String url = "https://www.baidu.com";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        //设置请求格式
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //设置响应格式
        headers.add(HttpHeaders.ACCEPT, "*/*");
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//        Map<String, String> map = new HashMap<>();
//        map.put("deviceId", "1104a89792febb703aa");
//        map.put("id", "3202065495");
//        map.put("type", "alipay");
//        map.put("openId", "o-VQQtyU_pRp0_UZkLSERY23Edux");
//        map.put("apiKey", "42050e25a65c4fdbbb0d0154449494a2");


        org.springframework.http.HttpEntity<Map<String, String>> request = new org.springframework.http.HttpEntity<>(headers);
        ResponseEntity<JSONObject> result = restTemplate.getForEntity(url, JSONObject.class, headers);
        System.out.println(result.toString());
    }
}