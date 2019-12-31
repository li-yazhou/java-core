package subject.checkargs;

import lombok.NonNull;
import org.junit.Test;
import subject.checkargs.bean.User;

/**
 * @author liyazhou1
 * @date 2019/12/31
 */
public class LombokDemo {


    @Test
    public void nonNull() {
        String[]  ids = {"10001", null};
        for (int i = 0; i < ids.length; i++) {
            User user = getUser(ids[i]);
            System.out.println("user = " + user);
        }
    }


    private User getUser(@NonNull String id) {

        System.out.println("id = " + id);
        User user = new User();
        user.setId(id);
        return user;
    }
}
