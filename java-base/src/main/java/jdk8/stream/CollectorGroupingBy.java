package jdk8.stream;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/11
 */
public class CollectorGroupingBy {

    private List<Dish> menu = Menu.menu;

    enum CaloriesLevel { Diet, Normal, Fat;}


    @Test
    public void groupingBy() {
        Map<Dish.Type, List<Dish>> dishTypeMap = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishTypeMap);
        dishTypeMap.forEach((k, v) -> System.out.println(k + " = " + v));


        Map<CaloriesLevel, List<Dish>> dishesByCaloriesLevel = menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() < 400) return CaloriesLevel.Diet;
                    else if (dish.getCalories() <= 700) return CaloriesLevel.Normal;
                    else return CaloriesLevel.Fat;
                }));
        dishesByCaloriesLevel.forEach((k, v) -> System.out.println(k + " = " + v));
    }


    /**
     * 多级分组
     *
     * Collectors.groupingBy(level_1, Collectors.groupingBy(level_2))
     */
    @Test
    public void groupingByMultiLevel(){
        Map<Dish.Type, Map<CaloriesLevel, List<Dish>>> multiGroupsMap =
                menu.stream()
                    .collect(
                        Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                                if (dish.getCalories() < 400) return CaloriesLevel.Diet;
                                else if (dish.getCalories() <= 700) return CaloriesLevel.Normal;
                                else return CaloriesLevel.Fat;
                            })
                        )
                    );
        multiGroupsMap.forEach((k, v) -> System.out.println(k + ", " + v));

        multiGroupsMap.forEach((k, v) -> {
            System.out.println(k + " = ");
            v.forEach((kk, vv) -> System.out.println(kk + " = " + vv));
        });
    }


    /**
     * 按子组收集数据
     */
    @Test
    public void collectBySubgroup() {

        // 收集各种菜的个数
        Map<Dish.Type, Long> typeCount = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.counting())
        );
        typeCount.forEach((k, v) -> System.out.println(k + " = " + v));

        // 收集各种菜中热量最高的菜
        Map<Dish.Type, Optional<Dish>> typeDishMap = menu.stream()
                .collect(
                    Collectors.groupingBy(
                        Dish::getType,
                        Collectors.maxBy(Comparator.comparing(Dish::getCalories))
                )
        );
        typeDishMap.forEach((k, v) -> System.out.println(k + " = " + v));

        Map<Dish.Type, Dish> mostCaloriesByType = menu.stream()
                .collect(
                        Collectors.groupingBy(
                            Dish::getType,
                            Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                            Optional::get
                        )
                    )
                );
        mostCaloriesByType.forEach((k, v) -> System.out.println(k + " = " + v));
    }

}
