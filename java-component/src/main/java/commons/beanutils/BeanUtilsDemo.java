package commons.beanutils;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author liyazhou1
 * @date 2019/11/22
 */
@Slf4j
public class BeanUtilsDemo {


    @Test
    public void copyProperties() throws InvocationTargetException, IllegalAccessException {
        Animal animal = new Animal();
        animal.setName("A N I M A L");
        log.info("Animal = [{}]", animal);

        Cat cat = animal.castToCat();
        log.info("Cat = [{}]", cat);

    }

}

@Setter @Getter
@ToString
class Animal {

    private String name;

    public Cat castToCat() throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        BeanUtils.copyProperties(cat, this);
        return cat;
    }
}

@Setter @Getter
@ToString(callSuper = true)
class Cat extends Animal {

    private Integer age;
}