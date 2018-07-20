package org.alpha.sparkbase.state;

import org.apache.spark.api.java.function.Function3;

/**
 * <p>Description: <p/>
 * <p>
 * User: liyazhou1
 * Date: 2018/6/26
 */
public class MappingFunction implements Function3<String, Integer, Integer, String> {

    @Override
    public String call(String v1, Integer v2, Integer v3) throws Exception {
        return "a string.";
    }
}
