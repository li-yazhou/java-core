package org.alpha.ssm.mapper;

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
 * @since 2018/2/12 14:42
 */
public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void init(){
        String path = "spring/applicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void testFindUserById() throws Exception{
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
