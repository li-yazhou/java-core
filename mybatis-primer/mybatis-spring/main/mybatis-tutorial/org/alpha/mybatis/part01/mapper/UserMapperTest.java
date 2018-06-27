package org.alpha.mybatis.part01.mapper;

import org.alpha.mybatis.part01.po.User;
import org.alpha.mybatis.part01.po.UserCustom;
import org.alpha.mybatis.part01.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/2 20:21
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // mybatis生成XxxMapper.java接口的代理对象
        // sqlSession.getMapper(Class<T> clazz)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }

    @Test
    public void testFindUserCount() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        int userCount = userMapper.findUserCount(userQueryVo);
        System.out.println(userCount);
    }


    /**
     * 测试userMapper.findUserByIdResultMap方法
     */
    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int id = 1;
        User user = userMapper.findUserByIdResultMap(id);
        System.out.println(user);
    }


    /**
     * 测试 userMapper.findUserByIdWithAlias 方法
     * @throws Exception 异常
     */
    @Test
    public void testFindUserByIdWithAlias() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int id = 1;
        User user = userMapper.findUserByIdWithAlias(id);
        System.out.println(user);
    }


    /**
     * 测试方法 userMapper.findUserListWithDynamicSql
     */
    @Test
    public void testFindUserListWithDynamicSql() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> list = userMapper.findUserListWithDynamicSql(userQueryVo);
        System.out.println(list);
    }


    /**
     * 测试方法 userMapper.findUserCountWithDynamicSql
     * @throws Exception
     */
    @Test
    public void testFindUserCountWithDynamicSql() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        // userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        int count = userMapper.findUserCountWithDynamicSql(userQueryVo);
        System.out.println(count);
    }


    /**
     * 测试方法 userMapper.findUserCountWithSqlCode
     * @throws Exception 异常
     */
    @Test
    public void testFindUserCountWithSqlCode() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        // userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        int count = userMapper.findUserCountWithSqlCode(userQueryVo);
        System.out.println(count);
    }


    /**
     * 测试方法 userMapper.findUserListWithForeach
     * @throws Exception 异常
     */
    @Test
    public void testFindUserListWithForeach() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();

        UserCustom userCustom = new UserCustom();
        userCustom.setGender("1");
        userCustom.setUsername("l");
        userQueryVo.setUserCustom(userCustom);

        // List<Integer> ids = Arrays.asList(1, 3, 5);
        List<Integer> ids = Arrays.asList(1, 3);
        userQueryVo.setIds(ids);

        List<UserCustom> list = userMapper.findUserListWithForeach(userQueryVo);
        System.out.println(list);
    }
}
