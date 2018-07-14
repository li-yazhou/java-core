
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception{
    	URL web = new URL("http://www.163.com/");
    	URLConnection webc = web.openConnection();
    	BufferedReader in = new BufferedReader(new InputStreamReader(webc.getInputStream()));
    	String inputLine;
    	while((inputLine = in.readLine()) != null){
    		System.out.println(inputLine);
    	}
    	in.close();
    }
}
