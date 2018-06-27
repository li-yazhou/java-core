package org.alpha.mybatis.generator.mapper;

import org.alpha.mybatis.generator.po.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}