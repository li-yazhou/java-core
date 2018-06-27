package org.alpha.ssm.dao;

import org.alpha.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/12 14:43
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    @Override
    public User findUserById(int id) throws Exception {
        // 继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("org.alpha.ssm.dao.findUserById", id);
        return user;
    }

/*    @Override
    public User findUserById(int id) throws Exception {
        // 继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("org.alpha.ssm.dao.findUserById", id);
        return user;
    }*/
}
