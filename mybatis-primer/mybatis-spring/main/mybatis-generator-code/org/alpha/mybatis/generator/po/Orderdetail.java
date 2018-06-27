package org.alpha.mybatis.generator.po;

public class Orderdetail {
    private Integer orderdetailId;

    private Integer orderId;

    private Integer itemid;

    private Integer number;

    private Double discount;

    public Integer getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(Integer orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}