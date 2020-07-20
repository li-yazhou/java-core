package javase.thread;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    /**
     * httpClient 调用请求
     *
     * @param json
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendHttp(String json, String url, String param) throws Exception {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost("", 0, "http");
        PostMethod post = new PostMethod(url);
        List<NameValuePair> lists = new ArrayList<NameValuePair>();
        NameValuePair simcard = new NameValuePair(param, json);
        lists.add(simcard);
        post.setRequestBody(lists.toArray(new NameValuePair[lists.size()]));
        String charset = "UTF-8";
        post.getParams().setHttpElementCharset(charset);
        post.getParams().setContentCharset(charset);
        client.executeMethod(post); // 打印服务器返回的状态
//        String response = new String(post.getResponseBodyAsString());
        String response = post.getResponseBodyAsString();
        return response;
    }

    public static String sendHttpWithParams(String url, Map<String, String> paramMap) throws Exception {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost("", 0, "http");
        PostMethod post = new PostMethod(url);
        List<NameValuePair> lists = new ArrayList<NameValuePair>();
        if (paramMap != null && paramMap.size() > 0) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                NameValuePair pair = new NameValuePair(entry.getKey(), entry.getValue());
                lists.add(pair);
            }
        }
        post.setRequestBody(lists.toArray(new NameValuePair[lists.size()]));
        String charset = "UTF-8";
        post.getParams().setHttpElementCharset(charset);
        post.getParams().setContentCharset(charset);
        client.executeMethod(post); // 打印服务器返回的状态
        String response = post.getResponseBodyAsString();
        return response;
    }

    /**
     * @param url
     * @param json
     * @return
     */
    public static String postBody(String url, String json) throws Exception {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost("", 0, "http");
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Content-Type", "application/json");
        RequestEntity requestEntity = new ByteArrayRequestEntity(json.getBytes("UTF-8"));
        post.setRequestEntity(requestEntity);
        String charset = "UTF-8";
        post.getParams().setHttpElementCharset(charset);
        post.getParams().setContentCharset(charset);
        client.executeMethod(post); // 打印服务器返回的状态
        return post.getResponseBodyAsString();
    }

}
