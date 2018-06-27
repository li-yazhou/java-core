package org.alpha.mybatis.part01.dao.impl;

import org.alpha.mybatis.part01.dao.UserDao;
import org.alpha.mybatis.part01.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/2 14:42
 */
public class UserDaoImpl implements UserDao {

    // 注入会话工厂，而不是会话，
    // 因为SqlSession是线程不安全，在方法体内创建更合适
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.deleteUser", 5);
        sqlSession.commit();
        sqlSession.close();
    }
}
