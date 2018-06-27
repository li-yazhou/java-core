package org.alpha.mybatis.part02.pojo;

import org.alpha.mybatis.part02.po.Order;
import org.alpha.mybatis.part02.po.User;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/9 20:48
 */

/**
 * 通过此类映射订单和用户查询的结果，让此类继承包括订单信息的Order类
 */
public class OrderCustom extends Order{
    // Order属性...

    // 订单中包含用户的信息
    private String username;
    private String gender;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return this.getOrder_id() + ", OrderCustom{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
