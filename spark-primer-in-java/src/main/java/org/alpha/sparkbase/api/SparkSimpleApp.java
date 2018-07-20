package org.alpha.sparkbase.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Brief: TODO
 * @author : liyazhou1
 * @date : 2018/6/22
 */
public class SparkSimpleApp implements Serializable{

    @Test
    public void testRDD() {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("test rdd");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList(
                "{\"name\":\"name1\", \"time\":\"10001\", \"factor\":\"1001\"}",
                "{\"name\":\"name2\", \"time\":\"20001\", \"factor\":\"2001\"}",
                "{\"name\":\"name1\", \"time\":\"10002\", \"factor\":\"1002\"}",
                "{\"name\":\"name3\", \"time\":\"30001\", \"factor\":\"3001\"}"
        ));

        int sum = rdd.map(json -> parse(json))
                        .map(dataObject -> dataObject.getFactor())
                        .reduce((x, y) -> x + y);
        System.out.println("sum = " + sum);

        rdd.map(json -> parse(json))
                .groupBy(dataObject -> dataObject.getName());

    }


    private DataObject parse(String json) {
        System.out.println("\n" + json + "\n");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String name = jsonObject.getString("name");
        long time = jsonObject.getLong("time");
        int factor = jsonObject.getIntValue("factor");

        return new DataObject(name, time, factor);
    }


    @Test
    public void testJson() {
        String json = "{\"name\":\"name1\", \"time\":\"10001\", \"factor\":\"1\"}";
        DataObject obj = parse(json);
        System.out.println(obj);
    }

    class DataObject implements Serializable{
        String name;
        long time;
        int factor;

        public DataObject(String name, long time, int factor) {
            this.name = name;
            this.time = time;
            this.factor = factor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getFactor() {
            return factor;
        }

        public void setFactor(int factor) {
            this.factor = factor;
        }

        @Override
        public String toString() {
            return "DataObject{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    ", factor=" + factor +
                    '}';
        }
    }


    @Test
    public void testSum() {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("test sum");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
        long sum = rdd.reduce(
                (x, y) -> x + y
        );
        List<Integer> elementList = rdd.collect();
        System.out.println(StringUtils.join(elementList, ", "));
        System.out.println("sum = " + sum);

        long multiply = rdd.reduce(
                (x, y) -> x * y
        );
        System.out.println("multiply = " + multiply);

    }


    @Test
    public void square() {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Spark App");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /*
        String path = "log.txt";
        JavaRDD<String> inputRDD = sc.textFile(path);
        */
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));

        JavaRDD<Integer> squares = rdd.map(
                x -> x * x
        );

        System.out.println(StringUtils.join(squares.collect(), ", "));
    }



    public static void main(String... args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Spark App");
        JavaSparkContext sc = new JavaSparkContext(conf);

        String path = "log.txt";
        JavaRDD<String> inputRDD = sc.textFile(path);

        /*
        JavaRDD<String> errorsRDD = inputRDD.filter(
                new Function<String, Boolean>() {
                    @Override
                    public Boolean call(String s) throws Exception {
                        return s.contains("error");
                    }
                }
        );


        JavaRDD<String> warningsRDD = inputRDD.filter(
                new Function<String, Boolean>() {
                    @Override
                    public Boolean call(String s) throws Exception {
                        return s.contains("warning");
                    }
                }
        );

        JavaRDD<String> badLinesRDD = errorsRDD.union(warningsRDD);
        */

        JavaRDD<String> badLinesRDD = inputRDD.filter(
                line -> line.contains("error") || line.contains("warning")
        );

        long lineNum = badLinesRDD.count();

        System.out.println("line number = " + lineNum);

        for (String line: badLinesRDD.take(10)) {
            System.out.println(line);
        }
    }
}
