package spring.journeyofspring.instantiate_manners;

/**
 * description:
 *      使用静态工厂方法（简单工厂模式）实例化对象
 * @author liyazhou
 * @since 2017-07-05 18:28
 */
public class PersonServiceStaticFactory {
    public static PersonService createPersonService(){
        return new PersonServiceImpl();  // todo  此处使用 new 创建对象了。。。。
    }
}
