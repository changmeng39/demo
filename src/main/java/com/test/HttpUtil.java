package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static String HttpClientGet(String url) throws Exception {
        // 获取http客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过httpget方式来实现我们的get请求
        HttpGet httpGet = new HttpGet(url);
        // 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
        CloseableHttpResponse response = client.execute(httpGet);
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 所有的响应的数据，也全部都是封装在HttpEntity里面
        HttpEntity entity = response.getEntity();
        // 通过EntityUtils 来将我们的数据转换成字符串
        String str = EntityUtils.toString(entity, "UTF-8");
        // 关闭
        response.close();
        return str;
    }

    public static int HttpClientPost(Map<String,String> map, String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
         for(Map.Entry<String,String> entry : map.entrySet()) {
             pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
         }
        httpPost.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
        CloseableHttpResponse response = client.execute(httpPost);
        System.err.println(response.toString());
        return response.getStatusLine().getStatusCode();
    }

    public static void main(String[] args) {


        String str = "[{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572518536000\",\"exitTime\":\"1572518604000\",\"fee\":\"0.0\",\"id\":1,\"name\":\"ETCP智慧停车场\",\"orderId\":\"590F91E4-6D4A-4BE1-B728-1DB57AEECB1E\",\"orderType\":1,\"parkPeriod\":\"68\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572524585000\",\"exitTime\":\"1572524759000\",\"fee\":\"0.0\",\"id\":4,\"name\":\"ETCP智慧停车场\",\"orderId\":\"3F93DEB9-A11E-4661-8736-DD87CA99536C\",\"orderType\":1,\"parkPeriod\":\"174\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572525386000\",\"exitTime\":\"1572525544000\",\"fee\":\"0.0\",\"id\":5,\"name\":\"ETCP智慧停车场\",\"orderId\":\"575F8F0A-03E2-4AE8-A397-AA47E51CDA10\",\"orderType\":1,\"parkPeriod\":\"158\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572577683000\",\"exitTime\":\"1572577750000\",\"fee\":\"0.0\",\"id\":6,\"name\":\"ETCP智慧停车场\",\"orderId\":\"C8ABDCEC-CE4B-43EB-AB39-B1FCF8944F17\",\"orderType\":1,\"parkPeriod\":\"67\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572577911000\",\"exitTime\":\"1572578402000\",\"fee\":\"0.0\",\"id\":7,\"name\":\"ETCP智慧停车场\",\"orderId\":\"8F2B3D85-3408-41C1-AF87-8687325FA663\",\"orderType\":1,\"parkPeriod\":\"491\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572676559000\",\"exitTime\":\"1572676820000\",\"fee\":\"0.0\",\"id\":8,\"name\":\"ETCP智慧停车场\",\"orderId\":\"99E76614-351E-4DD5-96AD-C7E1725246C6\",\"orderType\":1,\"parkPeriod\":\"261\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572678006000\",\"exitTime\":\"1572678976000\",\"fee\":\"0.0\",\"id\":9,\"name\":\"ETCP智慧停车场\",\"orderId\":\"59E37894-9D74-4F43-AF4B-6491E58EA5A0\",\"orderType\":1,\"parkPeriod\":\"970\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572681804000\",\"exitTime\":\"1572685548000\",\"fee\":\"7.0\",\"id\":10,\"name\":\"ETCP智慧停车场\",\"orderId\":\"7818EAFD-5BE7-4C63-9F9B-1289E0B9CB6A\",\"orderType\":1,\"parkPeriod\":\"3744\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1572856868000\",\"exitTime\":\"1572858828000\",\"fee\":\"5.0\",\"id\":11,\"name\":\"ETCP智慧停车场\",\"orderId\":\"D60BA671-5A1B-4906-AB72-9F8AE47FAEED\",\"orderType\":1,\"parkPeriod\":\"1960\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":1,\"enterTime\":\"1573018941000\",\"exitTime\":\"1573020828000\",\"fee\":\"5.0\",\"id\":68,\"name\":\"ETCP智慧停车场\",\"orderId\":\"EDE3C584-0695-4899-866D-ED04B31D39CC\",\"orderType\":1,\"parkPeriod\":\"1887\",\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1573022141000\",\"exitTime\":\"1573022581000\",\"fee\":\"0.0\",\"id\":69,\"name\":\"ETCP智慧停车场\",\"orderId\":\"0B2FB5BA-5685-42CD-A04D-C0E99A28E988\",\"orderType\":1,\"parkPeriod\":\"440\",\"payStatus\":1,\"userType\":1},{\"carNo\":\"沪AFG3016\",\"debt\":2,\"enterTime\":\"1573027719000\",\"exitTime\":\"1573028922000\",\"fee\":\"0.16\",\"id\":70,\"name\":\"ETCP智慧停车场\",\"orderId\":\"273B1851-09A7-4239-81AB-FFC3A206D591\",\"orderType\":1,\"parkPeriod\":\"1202\",\"userType\":1}]";
        JSONArray jsonArray = JSONArray.parseArray(str);
        for (Object o : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            System.err.println("1".equals(jsonObject.getString("orderType")));
            System.out.println(o);
        }
    }
}
