package javabase.jdk8.util.optional;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/26 16:02
 */
public class Wheel {

    private WheelAddress wheelAddress;

    public Wheel() {
    }

    public Wheel(WheelAddress wheelAddress) {
        this.wheelAddress = wheelAddress;
    }

    public WheelAddress getWheelAddress() {
        return wheelAddress;
    }

    public void setWheelAddress(WheelAddress wheelAddress) {
        this.wheelAddress = wheelAddress;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "wheelAddress=" + wheelAddress +
                '}';
    }
}
