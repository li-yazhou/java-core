package simpleexample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-26 8:12
 */
public class SqlSessionFactoryDemo {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        // 01, SqlSessionFactory
        String resource = "mybatis-config.xml";
        Reader reader = null;
        InputStream inputStream = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            // inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }


    public static void main(String[] args){
        SqlSessionFactoryDemo instance = new SqlSessionFactoryDemo();
        // instance.test01();
        instance.test02();
    }


    public void test01(){
        // 02, SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Blog blog = sqlSession.selectOne("BlogMapper.selectBlog", 101);
            System.out.println(blog);
        } finally {
            sqlSession.close();
        }
    }

    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlog(101);
            System.out.println(blog);
        } finally {
            sqlSession.close();
        }

    }
}


















