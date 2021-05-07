package _commons.beanutils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@Setter @Getter
@ToString
public class Animal {

    private String name;
    private Integer age;

    public Cat toCat() throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        BeanUtils.copyProperties(cat, this);
        return cat;
    }
}
