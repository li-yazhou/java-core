package org.java.book.designpattern.factorymethod2;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 20:18
 */
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
