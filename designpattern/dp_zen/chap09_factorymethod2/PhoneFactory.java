package dp_zen.chap09_factorymethod2;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 20:15
 */
public class PhoneFactory extends ExtractPhoneFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> clazz) {
        T phone = null;
        try{
            phone = (T)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e){
            System.out.println("it goes wrong when creating phone.");
        }
        return phone;
    }
}
