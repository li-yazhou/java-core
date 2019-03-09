package javabase.jdk8.defaultmethod;

import org.junit.Test;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27
 */
public class DefaultMethod {

    /*
        Syntax
            1. 每个默认接口只能有一个默认方法，该默认方法使用default修饰，且有方法体，如
                interface Food {
                    default void print() {
                        System.out.println("I am a kind of food.");
                    }
                }

            2. 当一个类实现了接口，则该类会自动继承接口的默认方法

        问题
            当一个类实现了多个接口，而且多个接口有同名的默认方法，此时不能通过编译，
            怎么确定继承了哪个接口的默认方法
                interface Fruit {
                    default void print() {
                        System.out.println("I am a kind of fruit.");
                    }
                }

            解决方案一：
                在该类中创建自己的方法，覆盖接口的默认方法
                    public Apple implements Food, Fruit {
                        public void print() {
                            System.out.println("I am an apple.");
                        }
                    }

            解决方案二：
                在该类中创建自己的的方法，在方法体中调用指定接口的默认方法
                    public Apple implements Food, Fruit {
                        public void print() {
                            // 调用 Fruit 接口的默认方法
                            Fruit.super.print();
                        }
                    }


            接口的静态方法
                接口可以包含静态方法；
                接口中的静态方法不被其实现类继承，
                    若实现类需要调用接口的静态方法，则通过 接口名.静态方法 的形式调用；
     */


    interface Food {
        default void print() {
            System.out.println("default method : I am a kind of food.");
        }

        static void showColor() {
            System.out.println("interface static method : This is food's color.");
        }
    }

    interface Fruit {
        default void print() {
            System.out.println("default method : I am a king of fruit.");
        }
    }

    class Apple implements Food, Fruit {
        public void print() {
            Food.super.print();
            Food.showColor();
            Fruit.super.print();
            System.out.println("instance method : I am an apple.");
        }
    }


    @Test
    public void defaultMethod() {
        new Apple().print();
    }
}
