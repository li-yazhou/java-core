package httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Example URL
 *      http://hc.apache.org/httpcomponents-client-4.5.x/httpclient/examples/org/apache/http/examples/client/QuickStart.java
 *
 * @author liyazhou1
 * @date 2018/8/2
 */
public class HttpClientPrimer {

    @Test
    public void httpGet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.sina.com");
        CloseableHttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            System.out.println("httpResponse.getStatusLine() = " + httpResponse.getStatusLine());
            try {
                HttpEntity entity = httpResponse.getEntity();
                // EntityUtils.consume(entity);
                InputStream inputStream = entity.getContent();
                InputStreamReader buffer = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(buffer);
                for (String line; (line = bufferedReader.readLine()) != null; ) {
                    System.out.println(line);
                }
            } finally {
                httpResponse.close();
            }
        } finally {
            httpClient.close();
        }
    }

    @Test
    public void httpPost() throws IOException {
        HttpPost httpPost = new HttpPost("http://www.sina.com");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            System.out.println("httpResponse.getStatusLine() = " + httpResponse.getStatusLine());
            HttpEntity entity = httpResponse.getEntity();
            InputStream inputStream = entity.getContent();
            InputStreamReader buffer = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(buffer);
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                System.out.println(line);
            }
        } finally {
            httpResponse.close();
        }
    }



    /*
    params:{
        "clientid":"e7c518aa",
        "batch":0,
        "message":{"head":{"accountName":"liuyuan10","accountType":1,"appName":"qsapp","clientIp":"127.0.0.1","interfaceName":"com.xstore.member.biz.user.service.MemberInfoService","op":3,"serverIp":"10.0.196.152","systemName":"fresh7tms","time":1540277561,"uuid":"68000012605501","version":"V1.0"},"reqInfo":{"carryBillId":"68000012605501"},"respInfo":{"telephone":"13611234459"}},
        "version":3,
        "timestamp":1540277561821,
        "token":"a68f43c8-3133-4bbc-a7e5-b16d198b2ac5"
    }
     */

    /*
    @Test
    public void httpPost2() throws IOException {
        String url = "http://jdbus-da.bdp.jd.com/put";
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();
        String msg = "{\"head\":{\"accountName\":\"liuyuan10\",\"accountType\":1,\"appName\":\"qsapp\",\"clientIp\":\"127.0.0.1\",\"interfaceName\":\"com.xstore.member.biz.user.service.MemberInfoService\",\"op\":3,\"serverIp\":\"10.0.196.152\",\"systemName\":\"fresh7tms\",\"time\":1540277561,\"uuid\":\"68000012605501\",\"version\":\"V1.0\"},\"reqInfo\":{\"carryBillId\":\"68000012605501\"},\"respInfo\":{\"telephone\":\"13611234459\"}}";
        System.out.println("msg = " + msg);
        nvps.add(new BasicNameValuePair("clientid", "e7c518aa"));
        nvps.add(new BasicNameValuePair("batch", "0"));
        nvps.add(new BasicNameValuePair("message", msg));
        nvps.add(new BasicNameValuePair("version", "3"));
        nvps.add(new BasicNameValuePair("timestamp", System.currentTimeMillis()+""));
        nvps.add(new BasicNameValuePair("token", "a68f43c8-3133-4bbc-a7e5-b16d198b2ac5"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            System.out.println("httpResponse.getStatusLine() = " + httpResponse.getStatusLine());
            HttpEntity entity = httpResponse.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                System.out.println(line);
            }
        } finally {
            httpResponse.close();
        }
    }
    */

}
