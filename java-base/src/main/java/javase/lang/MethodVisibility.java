package javase.lang;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/7/3
 */
public class MethodVisibility {

    private String ID = "PARENT";

    public void start() {
        System.out.println("start(), ID = " + this.ID);
        commonMethod();
    }

    public void commonMethod() {
        System.out.println("commonMethod(), ID = " + ID);
    }

}


class SubClass extends MethodVisibility {

    private String ID = "SUB";

    public void play() {
//        new MethodVisibility().start();
//        start();
//        this.start();
        super.start();
    }

    @Override
    public void commonMethod() {
        System.out.println("commonMethod(), ID = " + ID);
    }


    public static void main(String[] args) {
        new SubClass().play();
    }
}
