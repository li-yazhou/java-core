# Spring 定时任务


使用Spring定时任务

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xmlns:task="http://www.springframework.org/schema/task"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd 
        http://www.springframework.org/schema/task 
        http://www.springframework.org/schema/task/spring-task-3.0.xsd">

    <bean id="springScheduledTask" class="org.alpha.SpringScheduledTask" />
    <task:scheduled-tasks>
        <task:scheduled ref="springScheduledTask" method="startCollect" cron="${sampling.time}"/>
        <task:scheduled ref="springScheduledTask" method="startManage" cron="${manage.time}"/>
        <task:scheduled ref="springScheduledTask" method="startTakeSnapshot" cron="${snapshot.time}"/>
    </task:scheduled-tasks>

    <task:scheduler id="myScheduler" pool-size="5"/>
    <task:annotation-driven scheduler="myScheduler"/> 
    
    <!--<task:annotation-driven />-->
</beans>
```


除了可以在task:scheduled标签中指定调度时间属性cron之外，也可以在方法上使用@Scheduled注解，指定调度时间cron。
```
@Component  // import org.springframework.stereotype.Component
public class SpringScheduledTask implements ISpringScheduledTask {
      @Scheduled(cron="0/5 * *  * * ? ")   // 每5秒执行一次
      @Override
      public void startCollect() { 
          System.out.println("Enter startCollect ...");
      }
}
```


使用Spring定时任务时，需要注意的是：
* 实现类上要有组件的注解@Component
* Spring的@Scheduled注解需要写在实现上
* 定时器的任务方法不能有返回值，如果有返回值，spring初始化时会报错
* corn表达式
* 推荐配置定时任务的线程池，Spring的定时任务默认是单线程，多个任务执行起来时间会有问题，B任务会因为A任务执行起来需要20S而被延后20S执行

