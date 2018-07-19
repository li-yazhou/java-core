# 工厂方法模式
写作时间：2017-06-28 20:41

## 工厂方法模式的思路
第一，创建产品规范，也就是产品接口
第二，根据产品规范设计真实的产品，也就是使产品类实现产品接口
第三，结合产品规范，创建工厂规范，也就是工厂接口或者抽象类，产品规范作为工厂中抽象方法（生产线）的参数
第四，根据工厂规范创建工厂，此时工厂可以生产产品了


----------


## 举一个例子——生产手机
业务需求是，现在和将来一段时间要生产各种型号的手机。
所有的手机都满足手机的规范，比如包含打电话，上网，定位等功能。
现在，小米公司设计了小米手机，苹果公司设计了苹果手机，它们没有手机生产线。
有需求就有人做，富士康有大规模生产加工的经验和能力，它准备建立手机生产线。
只要给手机设计方案，富士康就能够产生出手机。
手机方案是满足手机规范的，工厂根据手机规范建设生产线。
生产线根据手机设计方案生产手机。

### 手机规范

```
public interface Phone {

    /**
     * 手机介绍自己的功能
     */
    void introduce();
}
```

### 手机产品设计方案
小米手机和苹果手机的设计方案

```
public class XiaomiPhone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am a xiaomi mobilephone");
    }
}


public class Iphone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am an iphone.");
    }
}
```
### 工厂规范
定义工厂的规范，工厂有一条手机生产线

```
public abstract class ExtractPhoneFactory {

    /**
     * 手机生产线
     * @param clazz 手机的设计方案
     * @param <T> 手机类型
     * @return 根据该类型手机的设计方案生产出来的手机
     */
    public abstract <T extends Phone> T createPhone(Class<T> clazz);
}
```

### 真实的工厂

```
public class PhoneFactory extends ExtractPhoneFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> clazz) {
        T phone = null;
        try{
            phone = (T)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e){
            System.out.println("it goes wrong when creating phone.");
        }
        return phone;
    }
}
```

### 生产场景
当前，工厂可以生产小米手机和苹果手机

```
public class App {
    public static void main(String[] args){
        // 实例化工厂
        ExtractPhoneFactory phoneFactory = new PhoneFactory();

        // 为工厂的生产线 createPhone 传递一个手机设计方案 XiaomiPhone.class
        XiaomiPhone mi = phoneFactory.createPhone(XiaomiPhone.class);
        mi.introduce();

        Iphone iphone = phoneFactory.createPhone(Iphone.class);
        iphone.introduce();
    }
}
```
### 新的需求——生产华为手机

```
public class HuaweiPhone implements Phone {
    @Override
    public void introduce() {
        System.out.println("i am a huawei mobilephone.");
    }
}
```

### 新的生产场景

```
public class App {
    public static void main(String[] args){
        // 实例化工厂
        ExtractPhoneFactory phoneFactory = new PhoneFactory();

        // 为工厂的生产线 createPhone 传递一个手机设计方案 XiaomiPhone.class
        XiaomiPhone mi = phoneFactory.createPhone(XiaomiPhone.class);
        mi.introduce();

        Iphone iphone = phoneFactory.createPhone(Iphone.class);
        iphone.introduce();

        // 现在增加生产华为手机的业务，只需要创建一个实现了手机接口的手机设计方案类即可
        HuaweiPhone huawei = phoneFactory.createPhone(HuaweiPhone.class);
        huawei.introduce();
    }
}
```


----------


## 解释
工厂方法模式命名非常准确。在工厂方法模式中，有两个主体，产品和工厂。
产品一定要满足产品规范，工厂通过产品规范来设计生产线，工厂通过产品设计方案生产产品。
一般地，工厂也需要满足工厂规范。


----------


## 典型应用
JDBC 连接不同的数据库


----------


## 为什么需要工厂模式
提高程序的可扩展性，降低程序之间的耦合程度。
比如，已经有一个生产手机的工厂，它可以生产小米手机、苹果手机，
现在工厂接到生产华为手机的订单。怎么办？
工厂只需要华为的手机设计即可，也就是定义一个实现了手机规范的化为手机类即可。


----------


## 规范的作用
规范，也就是接口，或者是抽象类，
规范是各个模块通信的桥梁。它可以是各个具体模块之间耦合关系降低。


----------


## 工厂方法模式的弱化——静态工厂模式
简单工厂模式，也就是静态工厂模式
我们省略掉工厂规范，并将实际的工厂类中的方法设置为静态类型，此时就是静态工厂模式。
静态工厂模式的缺点是，工厂类的扩展比较困难。