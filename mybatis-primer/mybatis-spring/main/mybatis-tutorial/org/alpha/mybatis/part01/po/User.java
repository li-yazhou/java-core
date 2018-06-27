package org.alpha.mybatis.part01.po;

import java.util.Date;

/**
 * User.java与mybatis-config/sqlmap/User.xml对应
 *
 * User.java中的字段和表user中的字段对应
 */
public class User {

    private int id;
    private String username;
    private String gender;
    private Date birthday;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addresss) {
        this.address = addresss;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", brithday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
