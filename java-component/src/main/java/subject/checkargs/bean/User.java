package subject.checkargs.bean;

import lombok.Data;

import java.util.Set;

/**
 * @author liyazhou1
 * @date 2019/12/31
 */
@Data
public class User {

    private String Id;

    private String name;

    private Set<Address> addressSet;

}
