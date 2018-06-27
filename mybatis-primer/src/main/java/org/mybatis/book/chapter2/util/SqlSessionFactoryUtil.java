package org.mybatis.book.chapter2.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-28 19:33
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtil(){}

    /**
     * 创建SqlSessionFactory对象，单例的
     */
    private static void initSqlSessionFactory(){
        String resource = "/org/mybatis/tutorial/demo01/mybatis-config.xml";
        InputStream inputStream = SqlSessionFactoryUtil.class.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 开启SqlSession
     * @return SqlSession对象
     */
    public static SqlSession openSession(){
        synchronized (SqlSessionFactoryUtil.class) {
            if (sqlSessionFactory == null)
                initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}



















