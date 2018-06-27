package org.mybatis.book.chapter2.mapper;

import org.mybatis.book.chapter2.po.Role;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-28 19:33
 */
public interface RoleMapper {

    Role selectRole(int id);

    void deleteRole(int id);

    void insertRole(Role role);

}
