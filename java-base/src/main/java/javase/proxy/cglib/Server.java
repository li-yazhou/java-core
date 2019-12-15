package javase.proxy.cglib;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-22 14:05
 */
public class Server {


    public String start() {
        System.out.println("开机...");
        return "START";
    }


    public String running(){
        System.out.println("运行...");
        return "RUNNING";
    }


    public void stop() {
        System.out.println("关机...");
    }
}
