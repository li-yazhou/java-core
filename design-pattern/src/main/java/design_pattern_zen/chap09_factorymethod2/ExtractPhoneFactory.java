/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 20:13
 */
public abstract class ExtractPhoneFactory {

    /**
     * 手机生产线
     * @param clazz 手机的设计方案
     * @param <T> 手机类型
     * @return 根据该类型手机的设计方案生产出来的手机
     */
    public abstract <T extends Phone> T createPhone(Class<T> clazz);
}
