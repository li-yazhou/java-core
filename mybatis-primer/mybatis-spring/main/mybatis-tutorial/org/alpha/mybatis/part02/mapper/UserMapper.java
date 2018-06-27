package org.alpha.mybatis.part02.mapper;

import org.alpha.mybatis.part02.po.User;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/11 12:15
 */
public interface UserMapper {
    // 通过Id查找用户
    User findUserById(int userId) throws Exception;

    // 更新用户
    void updateUser(User user) throws Exception;

    // 查询用户及购买商品信息
    List<User> findUserAndItemResultMap() throws Exception;
}
