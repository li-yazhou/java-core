package org.alpha.mybatis.part01.automapper;

import org.alpha.mybatis.part01.po.User;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/8 11:52
 */
public interface NewUserMapper {

    User findUserById(int id) throws Exception;

}
