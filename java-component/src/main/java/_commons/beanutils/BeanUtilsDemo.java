package _commons.beanutils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author liyazhou1
 * @date 2019/11/22
 */
@Slf4j
public class BeanUtilsDemo {


    @Test
    public void castToCat() throws InvocationTargetException, IllegalAccessException {
        Animal animal = new Animal();
        animal.setName("A N I M A L");
        log.info("Animal = [{}]", animal);

        Cat cat = animal.toCat();
        log.info("Cat = [{}]", cat);
    }



    @Test
    public void castToAnimal() throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        cat.setColor("B L A C K");
        cat.setName("C A T");
        log.info("cat = [{}]]", cat);
        Animal animal = cat.toAnimal();
        log.info("animal = [{}]", animal);
    }

}


