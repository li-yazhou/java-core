package org.alpha.mybatis.part01.test;

import org.alpha.mybatis.part01.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/1 16:16
 */
public class FirstProgramTest {

    @Test
    public void findUserByIdTest() throws IOException {

        // mybatis的全局配置文件SqlMapConfig.xml，在classpath路径下
        String resource = "SqlMapConfig.xml";

        // 使用Resources工具类读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 使用配置文件创建会话工厂SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 使用会话工厂 SqlSessionFactory 创建会话 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用会话执行查询操作 selectOne(statementId, parameters)
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        // 关闭会话
        sqlSession.close();

    }

}
