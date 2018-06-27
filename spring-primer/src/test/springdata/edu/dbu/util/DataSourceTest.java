package edu.dbu.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-27 15:14
 */
public class DataSourceTest {
    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        printCurrentMethodName();
        ctx = new ClassPathXmlApplicationContext("jdbc-beans.xml");
    }

    @After
    public void tearDown(){
        printCurrentMethodName();
        ctx = null;
    }


    private void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName + "\n");
    }

    @Test
    public void dataSourceTest(){
        printCurrentMethodName();
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        Assert.notNull(dataSource);
    }


    @Test
    public void jdbcTemplateTest(){
        printCurrentMethodName();
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        Assert.notNull(jdbcTemplate);
    }
}





























