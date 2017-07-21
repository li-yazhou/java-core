package book.fkjava.ch14_annotation.demo2;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 19:58
 */
@Table("user")
public class Filter {
    @Column(name="id", type="int")
    private int id;

    @Column(name="user_name")
    private String userName;

    @Column(name="nick_name")
    private String nickName;

    @Column(name="age", type="int")
    private int age;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    @Column(name="phone_num")
    private String phoneNum;

    public Filter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
