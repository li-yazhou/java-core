package javase.util;


/**
 * @author liyazhou1
 * @date 2019/12/17
 */
public class CurrentMethod {


    public void method() {

        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        String clazz = stackTraceElement.getClassName();
        String method = stackTraceElement.getMethodName();

        System.out.println(clazz + " :: " + method);

        System.out.println(getMethodDesc());

    }


    /**
     * 获取调用该方法的类名和方法名称
     */
    public String getMethodDesc() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String clazz = stackTraceElement.getClassName();
        String method = stackTraceElement.getMethodName();
        return clazz + " :: " + method;
    }


    public static void main(String[] args) {
    }
}
