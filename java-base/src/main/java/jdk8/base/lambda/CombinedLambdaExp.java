package jdk8.base.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/5
 */
public class CombinedLambdaExp {

    private List<Fruit> fruitList = Arrays.asList(
            new Fruit("Apple", "Red", 10.1),
            new Fruit("Orange", "Yellow", 5.2),
            new Fruit("Pineapple", "Yellow", 10.1),
            new Fruit("Banana","Yellow", 2.5),
            new Fruit("Purplegrape","Purple", 5.2 )
    );


    /**
     * 比较器复合
     */
    @Test
    public void sort() {
        fruitList.sort(Comparator.comparing(Fruit::getName).reversed());
        fruitList.forEach(System.out::println);
        System.out.println("----------------");

        // 价格逆序，若价格相等则名称顺序
        Comparator cmp = Comparator.comparing(Fruit::getPrice)
                .reversed()
                .thenComparing(Fruit::getName);
        fruitList.sort(cmp);
        fruitList.forEach(System.out::println);
    }


    private List<Fruit> fruitFilter(List<Fruit> fruitList, Predicate<Fruit> predicate) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            if (predicate.test(fruit)) {
                result.add(fruit);
            }
        }
        return result;
    }


    /**
     * 谓词复合，从左向右确定优先级的
     */
    @Test
    public void predicate() {
        Predicate<Fruit> yellowFruit = (Fruit f) -> "Yellow".equalsIgnoreCase(f.getColor());
        List<Fruit> yellowFruitList = fruitFilter(fruitList, yellowFruit);
        System.out.println("yellowFruitList = " + yellowFruitList);

        // 非 negate()
        Predicate<Fruit> notYellowFruit = yellowFruit.negate();
        List<Fruit> notYellowFruitList = fruitFilter(fruitList, notYellowFruit);
        System.out.println("notYellowFruitList = " + notYellowFruitList);

        // 与 and()
        // 或 or()
        Predicate<Fruit> notYellowAndPriceLess10OrApple = yellowFruit.negate()
                .and((Fruit f) -> f.getPrice() < 10)
                .or((Fruit f) -> "Apple".equalsIgnoreCase(f.getName()));
        List<Fruit> notYellowAndPriceLess10OrAppleList = fruitFilter(fruitList, notYellowAndPriceLess10OrApple);
        System.out.println("notYellowAndPriceLess10OrAppleList = " + notYellowAndPriceLess10OrAppleList);
    }


    /**
     * 函数复合
     */
    @Test
    public void combinedFunction() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        // 顺序执行，由外向内执行，外部的结果作为内部的参数
        Function<Integer, Integer> h = f.andThen(g);
        int andThenResult = h.apply(1);
        System.out.println("andThenResult = " + andThenResult);

        // 由内向外执行，内部的结果作为外部的参数
        Function<Integer, Integer> c = f.compose(g);
        int composeResult = c.apply(1);
        System.out.println("composeResult = " + composeResult);

    }


    class Fruit {
        private String name;
        private String color;
        private Double price;
        public Fruit(String name, String color, Double price) {
            this.name = name;
            this.color = color;
            this.price = price;
        }
        @Override
        public String toString() {
            return "[price = " + price + ", color = " + color + ", name = " + name + "]";
        }
        public String getName() { return this.name; }
        public String getColor() { return this.color; }
        public Double getPrice() { return this.price; }
    }
}
