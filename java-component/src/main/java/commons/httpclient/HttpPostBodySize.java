package commons.httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/9
 */
public class HttpPostBodySize {
    /*
    msg=`head -1 escapse_post.body`
    clientId="dbf8dc60"
    ip="11.24.86.218"
    token="e8d408a5-4ab4-4010-8c80-2b522ed9c28a"
    request_url="http://$ip:8888/put"
    currtime=`date +%s%N`
    currtime_millis=${currtime:0:13}
    request_args="clientid=$clientId&version=3&token=$token&batch=0&timestamp=${currtime_millis}&message=${msg}"
    curl -d $request_args $request_url
     */


    public static void main(String[] args) throws Exception {
        String msg = null;
        if (args != null && args.length > 0 && StringUtils.isNotBlank(args[0])) {
            msg = readFile(args[0]);
        } else {
            msg = readPostBody("src/main/backup/post_body_text.txt");
        }
        // String url = "http://11.24.86.218:8888/put";
        String url = "http://jdbus-da.bdp.jd.com/put";
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("clientid", "dbf8dc60"));
        nvps.add(new BasicNameValuePair("version", "3"));
        nvps.add(new BasicNameValuePair("token", "e8d408a5-4ab4-4010-8c80-2b522ed9c28a"));
        nvps.add(new BasicNameValuePair("timestamp", System.currentTimeMillis() + ""));
        nvps.add(new BasicNameValuePair("message", msg));
        // nvps.add(new BasicNameValuePair("batch", "0"));
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

    private static String readPostBody(String path) throws IOException {
        StringBuilder sBuilder = new StringBuilder();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        for (String line = null; (line = bufferedReader.readLine()) != null; sBuilder.append(line))
            ;
        bufferedReader.close();
        in.close();
        return sBuilder.toString();
    }


    private static String readFile(String path) throws IOException {
        StringBuilder sBuilder = new StringBuilder();
        InputStream in = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        for (String line = null; (line = bufferedReader.readLine()) != null; sBuilder.append(line))
            ;
        return sBuilder.toString();
    }

}
