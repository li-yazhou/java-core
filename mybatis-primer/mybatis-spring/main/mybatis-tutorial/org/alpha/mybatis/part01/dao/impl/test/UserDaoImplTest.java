package org.alpha.mybatis.part01.dao.impl.test;

import org.alpha.mybatis.part01.dao.UserDao;
import org.alpha.mybatis.part01.dao.impl.UserDaoImpl;
import org.alpha.mybatis.part01.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/2 14:58
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(2);
        System.out.println("user = " + user);
    }


}