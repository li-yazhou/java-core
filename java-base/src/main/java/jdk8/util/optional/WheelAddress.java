package jdk8.util.optional;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/26 16:05
 */
public class WheelAddress {

    private String country;
    private String city;

    public WheelAddress() {
    }

    public WheelAddress(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "WheelAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
