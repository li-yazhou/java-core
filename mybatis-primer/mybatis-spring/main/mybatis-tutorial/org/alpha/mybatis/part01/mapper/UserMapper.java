package org.alpha.mybatis.part01.mapper;

import org.alpha.mybatis.part01.po.User;
import org.alpha.mybatis.part01.po.UserCustom;
import org.alpha.mybatis.part01.po.UserQueryVo;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/2 20:14
 */
public interface UserMapper {

    User findUserById(int id) throws Exception;

    List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    int findUserCount(UserQueryVo userQueryVo) throws Exception;

    User findUserByIdResultMap(int id) throws Exception;

    User findUserByIdWithAlias(int id) throws Exception;

    List<UserCustom> findUserListWithDynamicSql(UserQueryVo userQueryVo) throws Exception;

    int findUserCountWithDynamicSql(UserQueryVo userQueryVo) throws Exception;

    int findUserCountWithSqlCode(UserQueryVo userQueryVo) throws Exception;

    List<UserCustom> findUserListWithForeach(UserQueryVo userQueryVo) throws Exception;

}
