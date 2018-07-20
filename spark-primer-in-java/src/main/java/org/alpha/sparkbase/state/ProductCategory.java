package org.alpha.sparkbase.state;

/**
 * Brief: TODO
 * Author: liyazhou1
 * Date: 2018/6/25
 */
public class ProductCategory {

    // 以商品名称和生产年份作为分类指标
    private String productName;

    private int year;

    public ProductCategory(String productName, int year) {
        this.productName = productName;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategory that = (ProductCategory) o;

        if (year != that.year) return false;
        return productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + year;
        return result;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productName='" + productName + '\'' +
                ", year=" + year +
                '}';
    }
}
