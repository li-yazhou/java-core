package javase.thread;

public class C {

    public static void main(String[] args) {
        test(1);
    }

    private static synchronized void test(int cc) {
        if (cc < 10) {
            cc++;
            System.out.println(cc);
            test(cc);
        }

    }
}
