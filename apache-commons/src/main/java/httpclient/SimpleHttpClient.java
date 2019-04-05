package httpclient;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * @author liyazhou1
 * @date 2018/9/21
 */
public class SimpleHttpClient {

    public SimpleHttpClient() {
    }

    private Content get(String url) throws IOException {
        return Request.Get(url)
                .execute()
                .returnContent();
    }

    private Content post(String url, Form form) throws IOException {
        return Request.Post(url)
                .bodyForm(form.build())
                .execute()
                .returnContent();
    }


    public static void main(String[] args) throws IOException {
        // String getUrl = "http://10.175.15.52:8888/put?clientid=10575&version=2&message=lyz&timestamp=1521621619000&token=143242343242";
        String getUrl = "http://www.baidu.com";
        String postUrl;

        SimpleHttpClient client = new SimpleHttpClient();
        Content content = client.get(getUrl);
        String result = content.asString();
        System.out.println("result = " + result);

    }
}
