package org.alpha.mybatis.part02.mapper;

import org.alpha.mybatis.part02.po.Order;
import org.alpha.mybatis.part02.po.User;
import org.alpha.mybatis.part02.pojo.OrderCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/9 21:03
 */
public class OrderMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testFindOrderUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderCustom> list = orderMapper.findOrderUser();
        for(OrderCustom o : list){
            System.out.println(o);
        }
    }


    @Test
    public void testFindOrderUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.findOrderUserResultMap();
        for(Order order : list){
            System.out.println(order);
        }
    }


    @Test
    public void testFindOrderAndOrderDetailResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.findOrderAndOrderDetailResultMap();
        for (Order order : list){
            System.out.println(order);
        }
    }


    @Test
    public void testFindOrderUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        // todo, DEBUG模式查看list中user属性是否有值
        List<Order> list = orderMapper.findOrderUserLazyLoading();
        for (Order order : list){
            User user = order.getUser();
            System.out.println(order);
            System.out.println(user);
        }
    }

}
