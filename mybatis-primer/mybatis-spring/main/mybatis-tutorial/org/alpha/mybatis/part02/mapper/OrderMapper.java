package org.alpha.mybatis.part02.mapper;

import org.alpha.mybatis.part02.po.Order;
import org.alpha.mybatis.part02.pojo.OrderCustom;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/9 20:55
 */
public interface OrderMapper {

    List<OrderCustom> findOrderUser() throws Exception;

    List<Order> findOrderUserResultMap() throws Exception;

    // 查询订单（关联用户）及订单明细
    List<Order> findOrderAndOrderDetailResultMap() throws Exception;

    // 查询订单关联查询用户，用户信息延迟加载
    List<Order> findOrderUserLazyLoading() throws Exception;
}
