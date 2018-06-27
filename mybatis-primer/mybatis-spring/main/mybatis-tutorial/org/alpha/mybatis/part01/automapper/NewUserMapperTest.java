package org.alpha.mybatis.part01.automapper;

import org.alpha.mybatis.part01.po.User;
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
 * @since 2018/2/8 11:57
 */
public class NewUserMapperTest {
    SqlSessionFactory sqlSessionFactory;

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
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NewUserMapper newUserMapper = sqlSession.getMapper(NewUserMapper.class);
        int id = 1;
        User user = newUserMapper.findUserById(id);
        System.out.println(user);
    }

}
