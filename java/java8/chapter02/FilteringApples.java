package java8.chapter02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-28 10:30
 */
public class FilteringApples {
    private List<Apple> appleList = null;

    /**
     * 遍历集合选出符合条件的对象
     * @param inventory 集合
     * @return 符合条件的对象组成的集合
     */
    public List<Apple> filterGreenApples(List<Apple> inventory){
        printCurrentMethodName();
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if ("green".equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }

    @Test
    public void filterGreenApplesTest(){
        List<Apple> greenAppleList = filterGreenApples(appleList);
        printList(greenAppleList);
    }


    public List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        printCurrentMethodName();
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (color.equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }

    @Test
    public void filterApplesByColorTest(){
        List<Apple> redApples = filterApplesByColor(appleList, "red");
        printList(redApples);
        System.out.println();

        List<Apple> greenApples = filterApplesByColor(appleList, "green");
        printList(greenApples);
    }



    public List<Apple> filterApplesByWeight(List<Apple> inventory, int lessWeight){
        printCurrentMethodName();
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (apple.getWeight() < lessWeight)
                result.add(apple);
        }
        return result;
    }

    @Test
    public void filterApplesByWeigthTest(){
        List<Apple> result = filterApplesByWeight(appleList, 160);
        printList(result);
    }


    //----------------------------行为参数化----------------------------
    interface ApplePredicate{
        public boolean test(Apple apple);
    }

    // TODO: 2017/7/28 可以添加参数，使程序更加灵活
    class AppleColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    class AppleWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() < 160;
        }
    }

    public List<Apple> filterApplesByPredicate(List<Apple> inventory, ApplePredicate predicate){
        printCurrentMethodName();
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (predicate.test(apple))
                result.add(apple);
        }
        return result;
    }

    @Test
    public void filterApplesByPredicateTest(){
        List<Apple> result = filterApplesByPredicate(appleList, new AppleColorPredicate());
        printList(result);
        System.out.println();
        printList(filterApplesByPredicate(appleList, new AppleWeightPredicate()));
    }








    private void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println();
        System.out.println(methodName);
    }


    @Before
    public void before(){
        appleList = generateAppleList();
    }

    private <T> void printList(List<T> list){
        for (T t : list)
            System.out.println(t);
    }

    private List<Apple> generateAppleList(){
        List<Apple> appleList = new ArrayList<>(10);
        appleList.add(new Apple(50, "green"));
        appleList.add(new Apple(100, "green"));
        appleList.add(new Apple(150, "green"));
        appleList.add(new Apple(200, "green"));
        appleList.add(new Apple(200, "green"));
        appleList.add(new Apple(50, "red"));
        appleList.add(new Apple(100, "red"));
        appleList.add(new Apple(150, "red"));
        appleList.add(new Apple(200, "red"));
        appleList.add(new Apple(200, "red"));
        return appleList;
    }



    private static class Apple{
        private int weight;
        private String color;

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
