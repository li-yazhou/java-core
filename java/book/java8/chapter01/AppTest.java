package book.java8.chapter01;

import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 14:28
 */



public class AppTest {
    private class Apple{
        private double weight;
        public Apple(){}
        public Apple(double weight){
            this.weight = weight;
        }
        public double getWeight() {
            return weight;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }
    }

    private List<Apple> getAppleColl(){
        List<Apple> list = new LinkedList<>();
        Random random  = new Random();
        for (int i = 0; i < 10; i ++)
            list.add(new Apple(random.nextInt(10) * random.nextDouble()));
        return list;
    }

    @Test
    public void sort(){
        List<Apple> list = getAppleColl();
        // list.sort();
    }

    @Test
    public void file(){
        String path = ".";
        File[] hiddenFiles = new File(path).listFiles(File::isHidden);
        for (File file : hiddenFiles)
            System.out.println(file.getName());
    }
}




















