package org.alpha.mybatis.part02.po;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/9 20:43
 */
public class OrderDetail {

    private int orderdetail_id;
    private int order_id;
    private int itemId;
    private int number;
    private double discount;

    // 添加商品
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderdetail_id() {
        return orderdetail_id;
    }

    public void setOrderdetail_id(int orderdetail_id) {
        this.orderdetail_id = orderdetail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderdetail_id=" + orderdetail_id +
                ", order_id=" + order_id +
                ", itemId=" + itemId +
                ", number=" + number +
                ", discount=" + discount +
                ", item=" + item +
                '}';
    }
}
