package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;

public class Array {

    public static <T> List<T> convert(List<?> list, Class<T> c) {
        return (List<T>)list;
    }

    public void a(){

    }

    public String a(String a){
        return a;
    }


    public static void test(){
        String stationIds = "[\"00d78550-c585-40bb-8bbf-6a3571a05a08\",\"aaa\",\"bbb\"]";
        stationIds.replace("[", "").replace("]", "");

        String a = "a1中文";
        System.out.println(a.length());
        System.err.println(a.getBytes().length);
        System.out.println("a1中文".length());
        System.err.println(a.getBytes());

    }

    public static void main(String[] args) {

        JSONArray jsonArray = JSONArray.parseArray("[\n" +
                "            {\n" +
                "                \"score\": \"49hN9MR2Y0oPpf60rRNmaGp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"wuJd8XgBvQ0rkI/LQiM9gg==\",\n" +
                "                \"longitude\": \"SPC+29f4Yoiu0lCwg5fidA==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"qiXMFUi6Hy2X4nSIizTGPGp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"juWgY2L2+KVV2xJaEeFaNA==\",\n" +
                "                \"longitude\": \"kj/evNFlIZRRyYW1k8Z3sw==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"fmrkPcMH8yLybVvjfwIpwWp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"JbTVrHy+5Ci7Z0Aj18iS7Q==\",\n" +
                "                \"longitude\": \"RJ+11o3yAKksfM/PTAWCSg==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"ZP/kXYsQF4wFiw442XolMmp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"ajoKV5GJr67Hbsj/8RFFBA==\",\n" +
                "                \"longitude\": \"9p/P6iYhHXYH+UnaRGDwCw==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"tESki/XoGkxcRVoTpF15Dmp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"4cnJFL2N6m54R3pjvdi3pw==\",\n" +
                "                \"longitude\": \"ea/pBbBz1urJih2u40a2Sg==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"fe5YQWddT7FHKugh4Oaw6mp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"FQfMX9jmcUt1RVnJDAeJYw==\",\n" +
                "                \"longitude\": \"tVBlN0Op2tqACZ6nnrVdFg==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"Do8xhod4jQgSgVT8XqfmT2p0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"8MDnhiXBeGJYBpW5qgz/uQ==\",\n" +
                "                \"longitude\": \"qjXPOdYKk5hCWRjOL1WsgA==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"ESHGifbymZScVje2ij7eWWp0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"bhUOKQDjQ9dYawFJsvWVtQ==\",\n" +
                "                \"longitude\": \"0uNvRiksKVjHDkwudREs9w==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"at/u88LTi503xYtrHQ5hh2p0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"tJUJ86Ae6Q8zAlue7Pcs5A==\",\n" +
                "                \"longitude\": \"ICCzw4BEADsZaWC0WhuoWA==\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"score\": \"G4lPzddg5oEZjaD6CjsDc2p0SHOfBtiSg08bnQDBZ3Y=\",\n" +
                "                \"latitude\": \"tlLc0PUTU2UUx6st9R3W3Q==\",\n" +
                "                \"longitude\": \"2yZpScQxsYE7O56LdWapnA==\"\n" +
                "            }\n" +
                "        ]");
        
        List<JSONObject> list = new ArrayList<>();

        for (Object o : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            list.add(jsonObject);
        }


        for(JSONObject j : list){
            System.err.println("score``````" + j.getString("score"));
            System.err.println("latitude````````" + j.getString("latitude"));
            System.err.println("longitude````````" + j.getString("longitude"));
        }



//        test();
//
//        String a = "1a整";
//
//        System.out.println("3```````" + a.length());//3
//
//        System.out.println("4```````" + a.getBytes().length);//4
//
//        char[] chars = a.toCharArray();
//
//        System.err.println(chars.length);
//
//        for (int i = 0; i < chars.length; i++) {
//            System.err.println(chars[i]);
//        }
//
//        System.out.println("////////////////////////////////////////////////////////");
//
//        List<String> list = new ArrayList<String>();
//        for (String l : list) {
//            System.out.println(l);
//        }
//
//        list.forEach(l -> {
//            System.err.println(l);
//        });
//
//        List<Object> objList = new ArrayList<Object>();
//
//        objList.add("a");
//        objList.add("b");
//        objList.add("c");
//
//        List<String> strList = convert(objList, String.class);
//
//        for (String s : strList) {
//            System.out.println(s);
//        }
//
//        System.out.println(String.class);
//
//        System.out.println(strList.getClass());
//
//        JSONObject jsonObject = new JSONObject();
//        if(jsonObject==null){
//            System.out.println("jsonObject==null");
//        }else {
//            System.out.println("jsonObject!=null");
//        }
//
//        if(jsonObject.isEmpty()){
//            System.out.println("jsonObject.isEmpty()");
//        }
//
//        System.out.println(System.currentTimeMillis());
//
//
//
//        JSONObject jsonObject1 = new JSONObject();
//
//
//        JSONObject resData = new JSONObject();
//
//        jsonObject1.put("resCode", 1);
//
//        jsonObject1.put("resData", resData);
//
//
//        System.err.println(jsonObject1.toString());

        System.out.println(System.currentTimeMillis());
    }
}
