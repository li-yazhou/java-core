package javase.proxy.cglib.dao;

/**
 * @author liyazhou1
 * @date 2019/12/17
 */
public class Dao {

    public Dao() {
        System.out.println(getMethodDesc());
    }

    public String select() {
        System.out.println(getMethodDesc());
        return "SELECT";
    }


    public void update() {
        System.out.println(getMethodDesc());
    }


    public void insert() {
        System.out.println(getMethodDesc());
    }


    private String getMethodDesc() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String clazz = stackTraceElement.getClassName();
        String method = stackTraceElement.getMethodName();
        return clazz + " :: " + method;
    }


    public static void main(String[] args) {

        new Dao().select();

        new Dao().update();

    }
}

