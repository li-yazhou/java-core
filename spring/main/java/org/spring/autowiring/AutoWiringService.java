package org.spring.autowiring;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 8:04
 */
public class AutoWiringService {
    private AutoWiringDAO autoWiringDAO;

    public AutoWiringService(){}
    public AutoWiringService(AutoWiringDAO autoWiringDAO){
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO){
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String arg){
        this.autoWiringDAO.say(arg);
    }
}
