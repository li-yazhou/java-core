package org.alpha.ssm.dao;

import org.alpha.ssm.po.User;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/12 14:43
 */
public interface UserDao {

    User findUserById(int id) throws Exception;

}
