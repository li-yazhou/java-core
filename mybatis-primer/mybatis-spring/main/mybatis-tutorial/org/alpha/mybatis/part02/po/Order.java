package org.alpha.mybatis.part02.po;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/8 12:22
 */
public class Order {

    private int order_id;
    private int user_id; // order.user_id = user.id
    private String no;
    private Date createTime;
    private String note;

    // 添加用户信息
    private User user;

    // 添加订单明细
    private List<OrderDetail> orderDetailList;



    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", no='" + no + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' + "\n\t" +
                ", user=" + user + "\n\t" +
                // ", orderDetailList=" + Arrays.toString(orderDetailList.toArray()) +
                '}' + '\n';
    }
}
