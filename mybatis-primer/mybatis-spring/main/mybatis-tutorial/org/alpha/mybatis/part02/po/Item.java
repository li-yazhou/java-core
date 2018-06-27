package org.alpha.mybatis.part02.po;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @version 0.0.1
 * @since 2018/2/11 12:22
 */
public class Item {

    private int itemId;
    private double price;
    private String name;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
