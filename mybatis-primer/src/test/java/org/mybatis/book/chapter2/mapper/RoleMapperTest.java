package org.mybatis.book.chapter2.mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.book.chapter2.po.Role;
import org.mybatis.book.chapter2.util.SqlSessionFactoryUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-01 16:38
 */
public class RoleMapperTest {

    private SqlSession sqlSession = null;


    @BeforeMethod
    public void setUp() throws Exception {
        sqlSession = SqlSessionFactoryUtil.openSession();
    }

    @AfterMethod
    public void tearDown() throws Exception{

    }

    @Test
    public void testSelectRole() throws Exception {
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.selectRole(1);
        System.out.println(role);
    }

    @Test
    public void testDeleteRole() throws Exception {

    }

    @Test
    public void testInsertRole() throws Exception {

    }

}