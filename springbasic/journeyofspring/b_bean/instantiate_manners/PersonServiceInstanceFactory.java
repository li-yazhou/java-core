package springbasic.journeyofspring.b_bean.instantiate_manners;

/**
 * description:
 *      使用实例工厂方法实例化(工厂方法模式)
 * @author liyazhou
 * @since 2017-07-05 19:05
 */
public class PersonServiceInstanceFactory {
    // 首先实例化工厂，然后通过工厂实例化对象
    // <bean id=“personServiceInstanceFactory" class="com.itcast.factory.PersonServiceInstanceFactory"/>
    // <bean id="personService" factory-bean=“personServiceInstanceFactory" factory-method="createPersonService" />
    public PersonService createPersonService(){
        return new PersonServiceImpl();
    }
}
