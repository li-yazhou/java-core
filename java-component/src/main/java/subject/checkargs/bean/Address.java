package subject.checkargs.bean;

import lombok.Data;

@Data
public class Address {

    private Integer id;

    private String province;

    private String city;

    private String county;

    private Boolean isDefault;

    private User user;
}