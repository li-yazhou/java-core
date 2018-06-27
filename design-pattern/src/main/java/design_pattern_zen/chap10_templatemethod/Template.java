/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-05 8:50
 */
public abstract class Template {
    public abstract void step01();
    public abstract void step02();

    public void templateMethod(){
        step01();
        step02();
    }
}

