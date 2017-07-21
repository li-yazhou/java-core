package book.fkjava.ch08_collection;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 20:01
 */
class Person{
    int age;
    String name;
    public Person(int _age, String _name){ age = _age; name = _name; }

    @Override
    public int hashCode(){
        return age;
    }

    @Override
    public boolean equals(Object obj){
        Person person = (Person) obj;
        return this.name.equals(person.name);
    }


}
public class CollectionTest {

    @Test
    public void setTest(){
        HashSet<Person> hashSet = new HashSet<>();

        // 测试，hashCode不一样，equals相等，是否能添加成功
        // 结果为，能添加成功
        Person p1 = new Person(1, "name1");
        Person p2 = new Person(2, "name1");
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet.size());  // 2
        hashSet.remove(p1);
        System.out.println(hashSet.contains(p1));  // false
        // HashMap


        // 测试，hashCode一样
    }

    @Test
    public void comparatorTest(){
        Comparator<Person> cmp = new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };

        // ArrayList
    }
}
