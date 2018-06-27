package org.alpha.ssm.mapper;

import org.alpha.ssm.po.User;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/12 14:42
 */
public interface UserMapper {

    User findUserById(int id) throws Exception;
}
