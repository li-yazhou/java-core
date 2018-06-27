package org.mybatis.book.chapter2.main;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.book.chapter2.mapper.RoleMapper;
import org.mybatis.book.chapter2.po.Role;
import org.mybatis.book.chapter2.util.SqlSessionFactoryUtil;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-28 19:16
 */
public class Chapter2Main {

    public static void main(String[] args){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.selectRole(1);
        System.out.println(role);
    }


}
