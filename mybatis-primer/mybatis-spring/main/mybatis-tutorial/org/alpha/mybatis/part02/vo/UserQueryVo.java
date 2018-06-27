package org.alpha.mybatis.part02.vo;

import org.alpha.mybatis.part02.po.Order;
import org.alpha.mybatis.part02.pojo.UserCustom;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/8 12:21
 */
public class UserQueryVo {

    private UserCustom userCustom;

    // 传入多个id
    private List<Integer> ids;

    private Order order;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
