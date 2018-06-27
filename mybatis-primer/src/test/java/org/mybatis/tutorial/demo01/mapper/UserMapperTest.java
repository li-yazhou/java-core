package org.mybatis.tutorial.demo01.mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.tutorial.demo01.po.User;
import org.mybatis.tutorial.demo01.util.SqlSessionFactoryUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-01 17:17
 */
public class UserMapperTest {

    private SqlSession sqlSession = SqlSessionFactoryUtil.openSession();

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindUserById() throws Exception {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @org.junit.Test
    public void testFindUserByName() throws Exception {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("liyazhou");
        System.out.println(users);
    }

}