package javase.thread.Volatile;

/**
 * Created by ji  .
 */
public class finalTest {
    final Obj obj;

    int a = 0;

    public finalTest() {
        obj = new Obj();
        a = 1;
    }

    public static void main(String[] args) {
        finalTest finalTest = new finalTest();
        System.out.println(finalTest.a);
        System.out.println(finalTest.obj.b);
    }




    class Obj{

        int b = 0;
        public Obj(){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
