package org.alpha.mybatis.part01.dao;

import org.alpha.mybatis.part01.po.User;
import org.alpha.mybatis.part01.po.UserWithUuid;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/1 19:34
 */
public class UserDaoDemo {

    /**
     * 根据id查询用户
     * 接收传入的参数，#{id}, #{value}相当于预编译语句中的占位符?
     * @throws IOException
     */
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



    /**
     * 模糊查询
     * 接收传入的参数并拼接sql语句，${value}，以原始的形式拼接到sql语句中
     * @throws IOException
     */
    @Test
    public void findUserByName() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByName", "j");
        // System.out.println(Arrays.toString(list.toArray()));
        for (User user : list)
            System.out.println(user);
        sqlSession.close();
    }



    private SqlSession openSession(){
        String resource = "SqlMapConfig.xml";
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }


    public void insertUser(User user){
        SqlSession sqlSession = openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("zzz");
        user.setGender("1");
        user.setBirthday(new Date());
        user.setAddress("bj");
        insertUser(user);
    }



    /**
     * double/0 = Infinity
     * 0/0, Exception, 代码从try块中跳转到catch中，然后执行catch之后的代码
     */
    @Test
    public void test(){
        int a = 1;
        int b = 0;
        try{
            double c = a / b;
            System.out.println(c);
        }catch(Exception e){
            System.out.println("exception.");
        }
        System.out.println("execute....");
    }


    /**
     * 插入对象，并返回自增主键到对象属性中，user.id
     */
    public void insertUserAndReturnId(User user){
        SqlSession sqlSession = openSession();
        sqlSession.insert("test.insertUserAndReturnId", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUserAndReturnIdTest(){
        User user = new User();
        user.setUsername("aaa");
        user.setGender("0");
        user.setBirthday(new Date());
        user.setAddress("bj");
        insertUserAndReturnId(user);
        System.out.println("last_insert_id() = " + user.getId());
    }


    /**
     * 插入对象，并返回uuid主键到对象属性中，userWithUuid.id
     */
    public void insertUserAndReturnUuid(UserWithUuid userWithUuid){
        SqlSession sqlSession = openSession();
        sqlSession.insert("test.insertUserAndReturnUuid", userWithUuid);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUserAndReturnUuidTest(){
        UserWithUuid userWithUuid = new UserWithUuid();
        userWithUuid.setUsername("lyz-uuid");
        insertUserAndReturnUuid(userWithUuid);
        System.out.println("userWithUuid.id = " + userWithUuid.getId());
    }


    public void deleteUser(int id){
        SqlSession sqlSession = openSession();
        sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        int id = 9;
        deleteUser(id);
    }


    /**
     * 根据用户的标识id，和用户对象属性更新记录
     * @param user
     */
    public void updateUser(User user){
        SqlSession sqlSession = openSession();
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        User user = new User();
        user.setId(7);
        user.setUsername("阿里多隆");
        updateUser(user);
    }

}
