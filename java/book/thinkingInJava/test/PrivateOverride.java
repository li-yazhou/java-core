package book.thinkingInJava.test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-08 16:28
 */
public class PrivateOverride {
   private void sameMethod(){
        System.out.println("parent method..");
    }

    public static void main(String[] args){
        PrivateOverride po = new DerivedClass();
        po.sameMethod();
    }
}

class DerivedClass extends PrivateOverride{
    public void sameMethod(){
        System.out.println("child method..");
    }
}