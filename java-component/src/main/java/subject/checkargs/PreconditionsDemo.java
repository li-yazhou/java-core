package subject.checkargs;

import static com.google.common.base.Preconditions.checkNotNull;
import org.junit.Test;
import subject.checkargs.bean.User;

/**
 * @author liyazhou1
 * @date 2019/12/31
 */
public class PreconditionsDemo {


    @Test
    public void checkNotNullTest() {

        User user = new User();
        user.setId("10001");

        checkNotNull(user);
        checkNotNull(user.getId());
        checkNotNull(user.getName());

    }
}
