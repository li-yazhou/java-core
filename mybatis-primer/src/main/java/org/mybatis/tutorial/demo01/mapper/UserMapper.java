package org.mybatis.tutorial.demo01.mapper;

import org.mybatis.tutorial.demo01.po.User;

import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-01 17:10
 */
public interface UserMapper {

    User findUserById(int id) throws Exception;

    List<User> findUserByName(String name) throws Exception;

}
