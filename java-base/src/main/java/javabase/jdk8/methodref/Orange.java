package javabase.jdk8.methodref;

/**
 * @author liyazhou1
 * @date 2018/7/28
 */
public class Orange {

    private String color;
    private double weight;

    public Orange() {
    }

    public Orange(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
