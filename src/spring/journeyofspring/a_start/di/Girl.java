package spring.journeyofspring.a_start.di;

import spring.journeyofspring.a_start.ioc.Boy;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 17:17
 */
public class Girl {
    private Boy boy;  // 协作对象，待注入的对象

    // spring 容器通过 setter 方法注入（初始化）协作对象
    public void setBoy(Boy _boy){
        boy = _boy;
    }

    public void display(){
        boy.display();
    }

}
