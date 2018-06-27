package org.alpha.mybatis.part01.dao;

import org.alpha.mybatis.part01.po.User;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/2 14:41
 */
public interface UserDao {

    public User findUserById(int id) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

}
