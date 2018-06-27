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
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/11 12:17
 */
public class UserMapperTest {

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
    public void testFindUserAndItemResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserAndItemResultMap();
        for (User user : list){
            System.out.println(user);
        }
    }
}
