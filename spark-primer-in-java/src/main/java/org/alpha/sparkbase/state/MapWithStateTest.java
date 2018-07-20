package org.alpha.sparkbase.state;

import com.alibaba.fastjson.JSONObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function3;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.State;
import org.apache.spark.streaming.StateSpec;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaMapWithStateDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.junit.Test;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Brief: TODO
 * Author: liyazhou1
 * Date: 2018/6/22
 */
public class MapWithStateTest {


    public static void main(String... args) {

        JavaDStream<Product> dStream = null;

        JavaPairDStream<ProductCategory, Product> streamOfPairs = dStream.mapToPair(
                product -> new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product)
        );

        Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>> mappingFunc = new Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>>() {
            @Override
            public Tuple2<ProductCategory, Double> call(ProductCategory category, Optional<Product> productOptional, State<Double> doubleState) throws Exception {
                double sum = doubleState.exists() ? doubleState.get() : 0.0D;
                double current = productOptional.isPresent() ? productOptional.get().getPrice() : 0;
                sum += current;
                doubleState.update(sum);
                return new Tuple2<>(category, sum);
            }
        };

        StateSpec<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> stateSpec = StateSpec.function(mappingFunc);

        // todo, 返回历史所有的状态值，也即是包括本次没有出现的key对应的状态？
        JavaMapWithStateDStream<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> streamOfCategoryAmount = streamOfPairs.mapWithState(stateSpec);

        streamOfCategoryAmount.foreachRDD(rdd -> {
                    System.out.println("Batch size = " + rdd.count());
                    rdd.foreach(x -> System.out.println("category = " + x._1() + ", amount = " + x._2()));
                }
        );
    }

    public void mapWithStateDemo() {
        JavaDStream<Product> dStream = null;
        /*
        JavaPairDStream<ProductCategory, Product> streamOfPairs = dStream.mapToPair(
                new PairFunction<Product, ProductCategory, Product>() {
                    @Override
                    public Tuple2<ProductCategory, Product> call(Product product) throws Exception {
                        return new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product);
                    }
                }
        );
        */
        JavaPairDStream<ProductCategory, Product> streamOfPairs = dStream.mapToPair(
                product -> new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product)
        );


        /*
        // 统计所有商品的总金额
        Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>>
                mappingFunction = (category, item, state) -> {
            double sum = state.exists() ? state.get() : 0.0D;
            double current = item.isPresent()? item.get().getPrice() : 0;
            sum += current;
            state.update(sum);
            return new Tuple2<>(category, sum);
        };
        */

        StateSpec<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> stateSpec = StateSpec.function(new Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>>() {
            @Override
            public Tuple2<ProductCategory, Double> call(ProductCategory category, Optional<Product> productOptional, State<Double> doubleState) throws Exception {
                double sum = doubleState.exists() ? doubleState.get() : 0.0D;
                double current = productOptional.isPresent() ? productOptional.get().getPrice() : 0;
                sum += current;
                doubleState.update(sum);
                return new Tuple2<>(category, sum);
            }
        });
        JavaMapWithStateDStream<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> streamOfCategoryAmount = streamOfPairs.mapWithState(stateSpec);

        streamOfCategoryAmount.foreachRDD(rdd -> {
                    System.out.println("Batch size = " + rdd.count());
                    rdd.foreach(x -> System.out.println(x));
                }
        );
    }




    /*
        T E S T...   [cannot resolve method]
        -------------------------------------------------------------------------------------
    **/
    private Product parse(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String name = jsonObject.getString("name");
        double price = jsonObject.getDouble("price");
        int year = jsonObject.getIntValue("year");
        return new Product(name, price, year);
    }


    @Test
    public void testMapWithState() {
        SparkConf conf = new SparkConf().setAppName("T E S T ... MapWithState");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rddOfRecords = sc.parallelize(Arrays.asList(
                "{\"name\":\"name1\", \"price\":\"10001\", \"year\":\"1001\"}",
                "{\"name\":\"name1\", \"price\":\"10002\", \"year\":\"1001\"}",
                "{\"name\":\"name1\", \"price\":\"10002\", \"year\":\"1002\"}",
                "{\"name\":\"name1\", \"price\":\"10002\", \"year\":\"1002\"}",

                "{\"name\":\"name2\", \"price\":\"20001\", \"year\":\"2001\"}",
                "{\"name\":\"name2\", \"price\":\"20001\", \"year\":\"2001\"}",

                "{\"name\":\"name3\", \"price\":\"30001\", \"year\":\"3001\"}"
        ));

        /*
        // JavaDStream<Product> streamsOfProducts = streamOfRecords.map(x -> parse(x));
        JavaRDD<Product> rddOfProducts = rddOfRecords.map(x -> parse(x));

        JavaPairRDD<ProductCategory, Product> rddOfPairs = rddOfProducts.mapToPair(
                item -> new Tuple2<>(new ProductCategory(item.getName(), item.getYear()), item)
        );
        */

        JavaDStream<Product> dStream = null;
        /*
        JavaPairDStream<ProductCategory, Product> streamOfPairs = dStream.mapToPair(
                new PairFunction<Product, ProductCategory, Product>() {
                    @Override
                    public Tuple2<ProductCategory, Product> call(Product product) throws Exception {
                        return new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product);
                    }
                }
        );
        */
        JavaPairDStream<ProductCategory, Product> streamOfPairs = dStream.mapToPair(
                product -> new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product)
        );

        // 统计所有商品的总金额
        Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>>
             mappingFunction = (category, item, state) -> {
                    double sum = state.exists() ? state.get() : 0.0D;
                    double current = item.isPresent()? item.get().getPrice() : 0;
                    sum += current;
                    state.update(sum);
                    return new Tuple2<>(category, sum);
        };

        /*
        JavaMapWithStateDStream<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>> streamOfCategoryAmount =
                streamOfPairs.mapWithState(StateSpec.function(mappingFunction));
        */
        // cannot resolve method
        /*
        JavaMapWithStateDStream<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> streamOfCategoryAmount = streamOfPairs.mapWithState(StateSpec.function(mappingFunction));

        streamOfCategoryAmount.foreachRDD(rdd -> {
                    System.out.println("Batch size = " + rdd.count());
                    rdd.foreach(x -> System.out.println(x));
                }
        );
        */
    }


    public void testMapWithState2() {
        JavaDStream<Product> dStream = null;
        JavaPairDStream<ProductCategory, Product> pairDStream = dStream.mapToPair(
                new PairFunction<Product, ProductCategory, Product>() {
                    @Override
                    public Tuple2<ProductCategory, Product> call(Product product) throws Exception {
                        return new Tuple2<>(new ProductCategory(product.getName(), product.getYear()), product);
                    }
                }
        );

        final Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>> mappingFunc =
                new Function3<ProductCategory, Optional<Product>, State<Double>, Tuple2<ProductCategory, Double>>() {
                    @Override
                    public Tuple2<ProductCategory, Double> call(ProductCategory productCategory, Optional<Product> product, State<Double> doubleState) throws Exception {
                        double price = product.isPresent() ? product.get().getPrice() : 0;
                        double sum = doubleState.exists() ? doubleState.get() : 0;
                        sum += price;
                        doubleState.update(sum);
                        Tuple2<ProductCategory, Double> output = new Tuple2<>(productCategory, sum);
                        return output;
                    }
                };
        // cannot resolve method
        // JavaMapWithStateDStream<ProductCategory, Product, Double, Tuple2<ProductCategory, Double>> stateDStream = pairDStream.mapWithState(StateSpec.function(mappingFunc));

        // stateDStream.print();
    }



    public void test() {
        JavaDStream<String> words = null;
        JavaPairDStream<String, Integer> wordsDStream = words.mapToPair(
                new PairFunction<String, String, Integer>() {
                    @Override
                    public Tuple2<String, Integer> call(String s) {
                        return new Tuple2<String, Integer>(s, 1);
                    }
                });


        final Function3<String, Optional<Integer>, State<Integer>, Tuple2<String, Integer>> mappingFunc =
                new Function3<String, Optional<Integer>, State<Integer>, Tuple2<String, Integer>>() {
                    @Override
                    public Tuple2<String, Integer> call(String word, Optional<Integer> one, State<Integer> state) {
                        int sum = one.or(0) + (state.exists() ? state.get() : 0);
                        Tuple2<String, Integer> output = new Tuple2<String, Integer>(word, sum);
                        state.update(sum);
                        return output;
                    }
                };


        /*
        Function3<String, Optional<Integer>, State<Integer>, String> mappingFunction1 =
                new Function3<String, Optional<Integer>, State<Integer>, String>() {
                    @Override
                    public String call(String v1, Optional<Integer> v2, State<Integer> v3) throws Exception {
                        return "abc";
                    }
                };

        // StateSpec<String, Integer, Integer, String> sta = StateSpec.function(mappingFunction1); // cannot resolve method
        // StateSpec<String, Integer, Integer, String> sta = StateSpec.function(new MappingFunction()); // cannot resolve method
        StateSpec<String, Integer, Integer, String> sta = StateSpec.function(new Function3<String, org.apache.spark.api.java.Optional<Integer>, State<Integer>, String>() {
            @Override
            public String call(String v1, org.apache.spark.api.java.Optional<Integer> v2, State<Integer> v3) throws Exception {
                return "ABC";
            }
        });
        */


        // StateSpec<String, Integer, Integer, Tuple2<String, Integer>>  stateSpec = StateSpec.function(mappingFunc);
        // DStream made of get cumulative counts that get updated in every batch
        // JavaMapWithStateDStream<String, Integer, Integer, Tuple2<String, Integer>> stateDStream = wordsDStream.mapWithState(stateSpec);
        // stateDStream.print();
    }
}
