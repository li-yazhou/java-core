package jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/10/19
 */
public class MemoryAnalysis {

    static class Entity {
        Long id;
        String name;
        Entity(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Entity> list = new LinkedList<>();
        long i = 0;
        for (;;) {
            Entity entity = new Entity(i, "name" + i);
            list.add(entity);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (list.size() == 5) {
                list.clear();
            }
        }

    }

}
