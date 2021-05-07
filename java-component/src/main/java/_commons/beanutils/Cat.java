package _commons.beanutils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@Setter
@Getter
@ToString(callSuper = true)
public class Cat extends Animal {

    private String color;

    public Animal toAnimal() throws InvocationTargetException, IllegalAccessException {
        Animal animal = new Animal();
        BeanUtils.copyProperties(animal, this);
        return animal;
    }

}