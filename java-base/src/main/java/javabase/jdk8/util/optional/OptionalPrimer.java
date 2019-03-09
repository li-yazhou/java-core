package javabase.jdk8.util.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/26 16:00
 */
public class OptionalPrimer {

    /*
        使用任何像 Optional 的类型作为字段或方法参数都是不可取的.
        Optional 只设计为类库方法的, 可明确表示可能无值情况下的返回类型.
        Optional 类型不可被序列化, 用作字段类型会出问题的

        直白的讲, 当我们还在以如下几种方式使用 Optional 时, 就得开始检视自己了
            调用 isPresent() 方法时
            调用 get() 方法时
            Optional 类型作为类/实例属性时
            Optional 类型作为方法参数时

        Optional 构造方法
            Optional.of(obj)
            Optional.ofNullable(obj)
            Optional.empty()

        Optional API
            public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
            public T orElse(T other)
            public T orElseGet(Supplier<? extends T> other)
            public void ifPresent(Consumer<? super T> consumer)
            public Optional<T> filter(Predicate<? super T> predicate)
            public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
            public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X

        一句话小结
            使用 Optional 时尽量不直接调用 Optional.get() 方法,
            Optional.isPresent() 更应该被视为一个私有方法,
            应依赖于其他像 Optional.orElse(), Optional.orElseGet(), Optional.map() 等这样的方法.
     */


    @Test
    public void test() {
        Wheel frontWheel = new Wheel(new WheelAddress("China", "Beijing"));
        Wheel rearWheel = new Wheel(new WheelAddress("China", "Zhengzhou"));
        Bike bike = new Bike(frontWheel, rearWheel);
        System.out.println("bike = " + bike);
    }


    @Test
    public void map() {
        Bike nullBike = new Bike();
        Optional<Bike> bikeOptional = Optional.of(nullBike);
        String cityOfFrontWheel = bikeOptional.map(Bike::getFrontWheel)
                .map(Wheel::getWheelAddress)
                .map(WheelAddress::getCity)
                .orElse("unknown city");
        System.out.println("cityOfFrontWheel = " + cityOfFrontWheel);
        System.out.println("..........................");

        Wheel frontWheel = new Wheel(new WheelAddress("China", "Beijing"));
        Bike bike = new Bike(frontWheel, null);
        Optional<Bike> bikeOptional1 = Optional.of(bike);
        bikeOptional1.map(Bike::getFrontWheel)
                .map(Wheel::getWheelAddress)
                .map(WheelAddress::getCity)
                .ifPresent(System.out::println);
    }


    public void filter() {

    }

}
