package _commons.httpclient;


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
}
