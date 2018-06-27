package org.alpha.mybatis.part02.mapper;

import org.alpha.mybatis.part02.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/11 21:11
 */
public class CacheTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testFindUserByIdCache() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.findUserById(1);
        User user2 = userMapper.findUserById(1);
        System.out.println(user1 == user2);  // true

        user1.setUsername("zhouzhou");
        user1.setAddress("郑州");
        userMapper.updateUser(user1);
        sqlSession.commit();

        User user3 = userMapper.findUserById(1);
        System.out.println(user1 == user3); // false
    }


    // 二级缓存测试
    @Test
    public void testCache() throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        SqlSession sqlSession4 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.findUserById(1);
        User user1_1 = userMapper1.findUserById(1);
        System.out.println("user1 == user1_1 ? " + (user1 == user1_1));
        System.out.println(user1);
        // 执行关闭操作，将sqlSession中的数据写到二级缓存区域中
        sqlSession1.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        // 第二次发起请求，查询id为1的用户
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println("user1 == user2 ? " + (user1 == user2));

        // 使用sqlSession3执行commit()操作
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user = userMapper3.findUserById(1);
        user.setUsername("新的名字");
        userMapper3.updateUser(user);
        // 执行提交，清空UserMapper下面的二级缓存
        sqlSession3.commit();
        sqlSession3.close();

        UserMapper userMapper4 = sqlSession4.getMapper(UserMapper.class);
        User user4 = userMapper4.findUserById(1);
        sqlSession4.close();
        System.out.println("user1 == user4 ? " + (user1 == user4));
    }


}
