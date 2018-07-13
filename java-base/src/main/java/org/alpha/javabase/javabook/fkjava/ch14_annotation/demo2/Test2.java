package org.alpha.javabase.javabook.fkjava.ch14_annotation.demo2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 20:03
 */
public class Test2 {

    @Test
    public void testQuery(){
        Filter filter01 = new Filter();
        filter01.setId(10);

        Filter filter02 = new Filter();
        filter02.setUserName("zz");  // 模糊查询

        Filter filter03 = new Filter();
        filter03.setEmail("zz@163.com,zz@qq.com,zz@126.com");

        String sql01 = query(filter01);
        String sql02 = query(filter02);
        String sql03 = query(filter03);
        System.out.println(sql01);
        System.out.println(sql02);
        System.out.println(sql03);

    }

    /**
     * 根据条件返回sql语句
     * @param filter 条件
     * @return sql语句
     */
    private String query(Filter filter){
        StringBuilder sql = new StringBuilder();
        Class clazz = filter.getClass();

        // 表名
        boolean exists = clazz.isAnnotationPresent(Table.class);
        if (!exists) return null;
        Table table = (Table) clazz.getAnnotation(Table.class);
        sql.append("select * from ").append(table.value()).append(" where 0 = 0");

        // 字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
            combineSql(sql, clazz, field, filter);

        return sql.toString();
    }

    private void combineSql(StringBuilder sql, Class clazz, Field field, Filter filter){
        boolean columnExists = field.isAnnotationPresent(Column.class);
        if (!columnExists) return;
        Column column = field.getAnnotation(Column.class);
        String columnName = column.name();  // 该field对应的表中的列名
        String columnType = column.type();

        // 获取field的值
        String fieldName = field.getName();
        String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        String columnValue = "";
        try {
            Method getMethod = clazz.getMethod(getMethodName);
            columnValue += getMethod.invoke(filter);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // TODO, 整型字段不能等于0，若等于则忽略
        if ("null".equals(columnValue) || "0".equals(columnValue)) return;

        if ("int".equals(columnType)) sql.append(" and ").append(columnName).append(" = ").append(columnValue);

        if ("string".equals(columnType)) {
            if (columnValue.contains(",")){
                sql.append(" and ").append(columnName).append(" in(");
                String[] values = columnValue.split(",");
                for (String value : values)
                    sql.append("`").append(value).append("`").append(",");
                sql.deleteCharAt(sql.length()-1);
                sql.append(")");
            }else{
                sql.append(" and ").append(columnName).append(" = `").append(columnValue).append("`");
            }
        }
    }

}
