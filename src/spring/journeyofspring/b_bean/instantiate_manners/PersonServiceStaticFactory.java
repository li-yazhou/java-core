package spring.journeyofspring.b_bean.instantiate_manners;

/**
 * description:
 *      使用静态工厂方法（简单工厂模式）实例化对象
 * @author liyazhou
 * @since 2017-07-05 18:28
 */
public class PersonServiceStaticFactory {

    // 不用实例化工厂，通过静态工厂方法直接实例化对象即可
    // <bean id="personService" class="cspring.journeyofspring.instantiate_manners.PersonServiceStaticFactory"
    //      factory-method="createPersonService" />
    public static PersonService createPersonService(){
        return new PersonServiceImpl();  // todo  此处使用 new 创建对象了。。。。
    }
}
