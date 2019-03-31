package javase.object;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/15
 */
public class InnerClass {

    /*
    内部类访问特点：
        1，内部类可以直接访问外部类中的成员。
        2，外部类要访问内部类，必须建立内部类的对象。
        一把用于类的设计。
        分析事物时，发现该事物描述中还有事物，而且这个事物还在访问被描述事物的内容。
        这时就是还有的事物定义成内部类来描述。

    为什么内部类能直接访问外部类中成员呢？
    那是因为内部类持有了外部类的引用。  外部类名.this


    内部类可以存放在局部位置上。
    内部类在局部位置上只能访问局部中被final修饰的局部变量。


    通常的使用场景之一：
    当函数参数是接口类型时，而且接口中的方法不超过三个。
    可以用匿名内部类作为实际参数进行传递

     */

    Object obj = new Object(){
        public void show() {
            System.out.println("This is a instance of Object.");
        }
    };

    public static void main(String[] args) {
        // new InnerClass().obj.show();
    }
}
