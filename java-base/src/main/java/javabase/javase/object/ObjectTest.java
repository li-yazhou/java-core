package javabase.javase.object;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 15:40
 */

public class ObjectTest {

    @Test
    public void cloneTest() throws CloneNotSupportedException{
        User u1 = new User(22);
        User u2 = u1.clone();
        System.out.println("u1 == u2 ? " + (u1 == u2));
        System.out.println("u1.address == u2.address ? " + (u1.address == u2.address));
    }
}

class Address implements Cloneable{
    private String detail;
    public Address(String _detail){
        detail = _detail;
    }

    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
    }
}

class User implements Cloneable{
    private int age;
    Address address;
    public User(int _age){
        age = _age;
        address = new Address("沈阳浑南");
    }

    public User clone() throws CloneNotSupportedException{
        return (User)super.clone();
    }
}
