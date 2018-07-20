package org.alpha.sparkbase.state;

import java.io.Serializable;

/**
 * Brief: TODO
 * Author: liyazhou1
 * Date: 2018/6/25
 */
public class Product implements Serializable {

    private String name;

    private double price;

    private int year;


    public Product(String name, double price, int year) {
        this.name = name;
        this.price = price;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
