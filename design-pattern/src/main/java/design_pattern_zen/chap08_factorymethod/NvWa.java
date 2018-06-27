package design_pattern_zen.chap08_factorymethod;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-28 11:17
 */
public class NvWa {

    public static void main(String[] args){
        AbstractHumanFactory factory = new HumanFactory();
        Human yellowMan = factory.createHuman(YellowHuman.class);
        yellowMan.color();
        yellowMan.talk();

        System.out.println();

        Human blackMan = factory.createHuman(BlackHuman.class);
        blackMan.color();
        blackMan.talk();

        System.out.println();

        Human whiteMan = factory.createHuman(WhiteHuman.class);
        whiteMan.color();
        whiteMan.talk();

        System.out.println();

        // 新扩展的类，只需要新建一个实现了 Human类（产品规范）的产品类即可
        Human newMan = factory.createHuman(NewHuman.class);
        newMan.color();
        newMan.talk();

    }
}
