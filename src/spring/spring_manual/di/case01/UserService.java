package spring.spring_manual.di.case01;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 15:23
 */
public class UserService {
    private UserDao userDao;

    public String getUsernameList(){
        return userDao.getUsernameList();
    }

    // spring 容器通过 setter 方法初始化 property 对象
    public void setUserDao(UserDao _userDao){
        userDao = _userDao;
    }
}
