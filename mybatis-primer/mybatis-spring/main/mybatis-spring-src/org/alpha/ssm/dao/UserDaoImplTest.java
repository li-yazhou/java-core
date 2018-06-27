package org.alpha.ssm.dao;

import org.alpha.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/12 14:43
 */
public class UserDaoImplTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() throws Exception{
        String path = "spring/applicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void testFindUserById() throws Exception{
        // UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
