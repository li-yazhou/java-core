package subject.checkargs;

import lombok.NonNull;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import subject.checkargs.bean.User;

/**
 * @author liyazhou1
 * @date 2019/12/31
 */
public class ValidateDemo {


    @Test
    public void validateTrue() {

        User user = new User();
        user.setId("10001");

        Validate.isTrue(user != null);
        Validate.isTrue(user.getName() != null, "attr name must not be null");
    }

}
