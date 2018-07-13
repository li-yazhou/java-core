package org.alpha.javabase.util;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @date 2017-07-16 11:13
 */
public class BlankObjectUtil {
    /**
     * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
     * @param obj 对象
     * @return boolean
     */
    public static boolean isBlank(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        /* Object[] 可以代表无穷维度的数组，需要以递归的方法验证 */
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isBlank(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<String>> _2dimArrayList = new ArrayList<>(new ArrayList<>());
        Object[] objects = {
                null,
                "",
                new ArrayList(),
                new HashSet(),
                new HashMap(),
                new ArrayList<>(),
                _2dimArrayList,
                "string",
        };

        for(Object obj : objects) {
            System.out.println("obj = " + obj + ", isBlank = " + isBlank(obj));
        }

        ArrayList<String> array = new ArrayList<>();
        array.add("aa");
        _2dimArrayList.add(array);
        System.out.println(_2dimArrayList + ", isBlank = " + isBlank(_2dimArrayList));
    }

}
