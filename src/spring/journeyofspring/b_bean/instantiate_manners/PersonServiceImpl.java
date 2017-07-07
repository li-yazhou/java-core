package spring.journeyofspring.b_bean.instantiate_manners;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 18:25
 */

/*
1.使用类构造器实例化(默认无参数)
    <bean id="personService" class="spring.journeyofspring.b_bean.instantiate_manners.PersonServiceImpl">

2.使用静态工厂方法实例化(简单工厂模式)
    不用实例化工厂，通过静态工厂方法直接实例化对象即可
    <bean id="personService" class="cspring.journeyofspring.instantiate_manners.PersonServiceStaticFactory"
         factory-method="createPersonService" />

3.使用实例工厂方法实例化(工厂方法模式):
    首先实例化工厂，然后通过工厂实例化对象
    <bean id=“personServiceInstanceFactory" class="com.itcast.factory.PersonServiceInstanceFactory"/>
    <bean id="personService" factory-bean=“personServiceInstanceFactory" factory-method="createPersonService" />

 */


// <bean id="personService" class="spring.journeyofspring.b_bean.instantiate_manners.PersonServiceImpl">
public class PersonServiceImpl implements PersonService{
    @Override
    public void service(){
        System.out.println(this + ", this is a PersonServiceImpl instance.");
    }
}
