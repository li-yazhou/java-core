package org.alpha.javabase.jdk8.util.optional;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/26 16:02
 */
public class Bike {

    private Wheel frontWheel;

    private Wheel rearWheel;

    public Bike() {
    }

    public Bike(Wheel frontWheel, Wheel rearWheel) {
        this.frontWheel = frontWheel;
        this.rearWheel = rearWheel;
    }

    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public void setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
    }

    public Wheel getRearWheel() {
        return rearWheel;
    }

    public void setRearWheel(Wheel rearWheel) {
        this.rearWheel = rearWheel;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "frontWheel=" + frontWheel +
                ", rearWheel=" + rearWheel +
                '}';
    }
}
