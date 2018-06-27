package org.alpha.commons.dbpipe;

import org.alpha.commons.dbpipe.auxiliary.Column;
import org.alpha.commons.dbpipe.auxiliary.Id;
import org.alpha.commons.dbpipe.auxiliary.Table;
import org.alpha.commons.dbpipe.auxiliary.PageBean;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:01
 */
public class DbPipe<E> extends AbstractDbPipe<E> {

    /**
     * 原始的查询操作
     * @param rawSql 查询记录的sql语句
     * @return 结果集
     */
    public ResultSet executeQuery(String rawSql) {
        return null;
    }

    /**
     * 原始的更新操作
     * @param rawSql 插入、修改或者删除记录的sql语句
     * @return 受影响的记录数目
     */
    public int executeUpdate(String rawSql){
        return -1;
    }

    /**
     * 批量地执行sql语句
     * @param rawSqls sql语句数组
     * @return 执行每条语句而受到影响的记录数目
     */
    public int[] batch(String[] rawSqls) {
        return new int[0];
    }

    /**
     * 批量地执行sql语句
     * @param rawSqls sql语句数组
     * @param params 每条sql语句的占位符对应的参数
     * @return 执行每条语句而受到影响的记录数目
     */
    public int[] batch(String[] rawSqls, Object[][] params) {
        return new int[0];
    }

    /*---------------------------------添加对象到数据库---------------------------------*/
    /**
     * 添加一个对象
     * @param element 要添加的对象
     * @return 添加成功返回 1，否则返回 0
     */
    public int add(E element) {
        if (element == null)
            throw new IllegalArgumentException("插入的元素为空.");
        Class clazz = element.getClass();
        String tableName = getTableName(clazz);
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0)
            throw new RuntimeException(element + "没有属性.");
        // TODO: 2017/7/22 去除属性为null的占位符，下一版本优化
        String sql = getInsertSql(tableName, fields.length);
        Object[] params = getSqlParams(element, fields);
        System.out.println("insertSql = " + sql);
        System.out.println(Arrays.toString(params));
        // return JdbcUtils.excuteUpdate(sql, params);
        int result = -1;
        try {
            // update自动关闭connection
            result = JdbcUtils.getQueryRunner().update(sql, params);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // throw new RuntimeException("插入数据失败异常.");
            System.out.println("插入数据失败.");
        }
        return result;
    }

    /**
     * 根据对象获取sql语句的参数
     * @param element 值对象
     * @param fields 值对象包含的Field
     * @return sql 的参数
     */
    private Object[] getSqlParams(E element, Field[] fields) {
        Object[] params = new Object[fields.length];
        for (int i = 0; i < fields.length; i ++){
            fields[i].setAccessible(true);
            try {
                params[i] = fields[i].get(element);
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                System.out.println("获取" + element + "的属性值失败！");
                // e.printStackTrace();
            }
        }
        return params;
    }

    /**
     * 插入对象的sql语句
     * @param tableName 表名称
     * @param length 字段长度
     * @return 插入记录的sql语句
     */
    private String getInsertSql(String tableName, int length) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append(" values(");
        for (int i = 0; i < length; i ++)  // 添加参数占位符?
            sql.append("?,");
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return sql.toString();
    }

    /**
     * 根据值对象的注解获取其对应的表名称
     * @param clazz 值对象的字节码
     * @return 表名称
     */
    private String getTableName(Class<E> clazz) {
        boolean existTableAnno = clazz.isAnnotationPresent(Table.class);
        if (!existTableAnno)
            throw new RuntimeException(clazz + " 没有Table注解.");
        Table tableAnno = (Table)clazz.getAnnotation(Table.class);
        return tableAnno.name();
    }

    /*---------------------------------更新对象到数据库---------------------------------*/
    /**
     * 更新一个对象
     * @param element 待更新的对象
     * @return 若成功更新则返回1，否则返回0
     */
    public int update(E element) {
        if (element == null)
            throw new IllegalArgumentException("插入的元素为空.");
        Class clazz = element.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0)
            throw new RuntimeException(element + "没有属性.");
        Object[] params = new Object[fields.length];
        String sql = getUpdateSqlAndParams(element, params);
        // System.out.println("update sql = " + sql);
        // System.out.println("params = " + Arrays.toString(params));
        int result = -1;
        try {
            result = JdbcUtils.getQueryRunner().update(sql, params);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("更新数据失败.");
        }
        return result;
    }

    /**
     * 获取更新记录的sql语句和参数
     * @param element 对象
     * @param params 参数数组
     * @return update sql 和 sql语句的参数
     */
    private String getUpdateSqlAndParams(E element, Object[] params) {
        Class clazz = element.getClass();
        String tableName = getTableName(clazz);
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder updateSql = new StringBuilder();
        updateSql.append("update ").append(tableName).append(" set ");
        String idName = "";
        int index = 0; // 记录参数的位置
        for (int i = 0; i < fields.length; i ++){
            fields[i].setAccessible(true);
            // 找到id对应的列名和值
            if (fields[i].isAnnotationPresent(Id.class)){
                idName = fields[0].getAnnotation(Id.class).name();
                try {
                    params[params.length-1] = fields[i].get(element);  // id作为update sql 的最后一个参数
                    if (params[params.length-1] == null)
                        throw new RuntimeException(element + "没有Id属性!");
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                    System.out.println("获取" + element + "的属性值失败！");
                }
            }
            boolean isPresent = fields[i].isAnnotationPresent(Column.class);
            if (isPresent) {
                Column column = fields[i].getAnnotation(Column.class);
                String columnName = column.name();
                updateSql.append(" ").append(columnName).append( " = ? ,");
                // update sql 的参数
                try {
                    params[index++] = fields[i].get(element);  // 添加参数到数组，并更新下标
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                    System.out.println("获取" + element + "的属性值失败！");
                }
            }
        }
        updateSql.deleteCharAt(updateSql.length()-1);
        updateSql.append("where ").append(idName).append(" = ?");
        return updateSql.toString();
    }

    /*---------------------------------添加对象到数据库---------------------------------*/
    /**
     * 更新一个对象，若对象不存在可以选择插入
     * @param element 待更新的对象
     * @param bool 当更新的对象不存在时，若该参数为true，则插入该对象，否则不插入该对象
     * @return 若更新成功则返回 1，否则返回 0
     */
    public int update(E element, boolean bool) {
        int result = update(element);
        int retval = 0;
        if (bool && result == 0) retval = add(element);
        return retval;
    }

    /*---------------------------------从数据库中删除对象（记录）---------------------------------*/
    /**
     * 根据id删除一个对象
     * @param id 待删除对象的id
     * @param clazz 待删除对象的字节码
     * @return 删除成功返回 1，否则返回 0
     */
    public int delete(Integer id, Class<E> clazz) {
        return delete(String.valueOf(id), clazz);
    }

    /*---------------------------------从数据库中删除对象（记录）---------------------------------*/
    /**
     * 根据id删除一个对象
     * @param id 待删除对象的id
     * @param clazz 待删除对象的字节码
     * @return 删除成功返回 1，否则返回 0
     */
    public int delete(String id, Class<E> clazz) {
        String tableName = getTableName(clazz);
        String idName = getIdName(clazz);
        StringBuilder deleteSql = new StringBuilder();
        // "delete from " + tableName + " where " + idName + " = ?";
        deleteSql.append("delete from ").append(tableName).append(" where ").append(idName).append(" = ?");
        int result = -1;
        try {
            result = JdbcUtils.getQueryRunner().update(deleteSql.toString(), id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("从 " + tableName + " 删除 id 为" + id + "的数据失败！");
        }
        return result;
    }

    /**
     * 获取id属性对应的列名，根据值对象的字节码
     * @param clazz 字节码
     * @return id列名
     */
    private String getIdName(Class<E> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        String idName = null;
        for(Field field : fields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(Id.class)){
                idName = field.getAnnotation(Id.class).name();
            }
        }
        if (idName == null)
            throw new RuntimeException(clazz + "没有指定@Id注解!");
        return idName;
    }

    /*---------------------------------从数据库中删除对象（记录）并返回---------------------------------*/
    /**
     * 根据id删除一个对象并将其返回
     * @param id 待删除对象的id
     * @param clazz 待删除对象的字节码
     * @return 若成功删除该对象则将其返回，否则返回 null
     */
    public E remove(Integer id, Class<E> clazz) {
        return remove(String.valueOf(id), clazz);
    }

    /*---------------------------------从数据库中删除对象（记录）并返回---------------------------------*/
    /**
     * 根据id删除一个对象并将其返回
     * @param id 待删除对象的id
     * @param clazz 待删除对象的字节码
     * @return 若成功删除该对象则将其返回，否则返回 null
     */
    public E remove(String id, Class<E> clazz) {
        // TODO: 2017/8/1 设置为原子性操作，如果失败则回滚
        E result = query(id, clazz);
        delete(id, clazz);
        return result;
    }

    /*---------------------------------从数据库中查找对象（记录）并返回---------------------------------*/
    /**
     * 根据id查找一个对象
     * @param id 待查找对象的id
     * @param clazz 待查找对象的字节码
     * @return 若成功查找对象则将其返回，否则返回 null
     */
    public E query(Integer id, Class<E> clazz) {
        return query(String.valueOf(id), clazz);
    }

    /*---------------------------------从数据库中查找对象（记录）并返回---------------------------------*/
    /**
     * 根据id查找一个对象
     * @param id 待查找对象的id
     * @param clazz 待查找对象的字节码
     * @return 若成功查找对象则将其返回，否则返回 null
     */
    public E query(String id, Class<E> clazz) {
        String tableName = getTableName(clazz);
        String idName = getIdName(clazz);
        StringBuilder selectSql = new StringBuilder();
        selectSql.append("select * from ").append(tableName).append(" where ").append(idName).append(" = ?");
        E result = null;
        try {
            result = JdbcUtils.getQueryRunner().query(selectSql.toString(), new BeanHandler<E>(clazz), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*---------------------------------从数据库中查找对象（记录）并存储到List中，后返回---------------------------------*/
    public List<E> queryToList(String sql, Class<E> clazz) {
        List<E> result = null;
        try {
            result = JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<E>(clazz));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql + "，查询失败！");
        }
        return result;
    }

    /*---------------------------------从数据库中查找到的第一行记录存储到数组中，后返回---------------------------------*/
    public Object[] queryToArray(String sql) {
        Object[] result = null;
        try {
            result = JdbcUtils.getQueryRunner().query(sql, new ArrayHandler());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql + ", 查询失败！");
        }
        return result;
    }

    /*---------------------------------从数据库中查找对象（记录）并存储到Set中，后返回---------------------------------*/
    public Set<E> queryToSet(String sql, Class<E> clazz) {
        return new HashSet<E>(queryToList(sql, clazz));
    }

    /*---------------------------------从数据库中分页查询数据并保存到PageBean中，后返回---------------------------------*/
    public PageBean<E> query(int pageSize, int pageIndex, Class<E> clazz) {
        String tableName = getTableName(clazz);
        int count = count(clazz);
        int pageTotal = (count + pageSize - 1)/pageSize;
        if (pageIndex > pageTotal - 1)
            throw new RuntimeException("总页码为 " + count + ", " + pageIndex + " 超出范围.");

        int fromIndex = pageIndex * pageSize;
        int offset = pageSize;
        if (fromIndex + pageSize > count)
            offset = count - fromIndex;

        String sql = "select * from " + tableName + " limit " + fromIndex + ", " + offset;
        List<E> eList = null;
        try {
            eList = JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<E>(clazz));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("分页查询出现异常.");
        }

        return new PageBean<E>(pageSize, pageIndex, pageTotal, count, eList);
    }

    /*---------------------------------从数据库中查询表中的记录总数---------------------------------*/
    /**
     * 查找该类对应的表中记录的数目（对应记录的数目）
     * @param clazz 对象的字节码
     * @return 该类对应表中记录的数目
     */
    public int count(Class<E> clazz) {
        String tableName = getTableName(clazz);
        String sql = "select count(*) from " + tableName;
        long result = -1;
        try {
            result = (Long)JdbcUtils.getQueryRunner().query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int)result;
    }

    /*---------------------------------从数据库中查询表中最大的键---------------------------------*/
    /**
     * 查找最大的id
     * @return 最大的id
     */
    public int getMaxId(Class<E> clazz){
        String tableName = getTableName(clazz);
        String idName = getIdName(clazz);
        String sql = "select max("+ idName +") from " + tableName;
        long result = -1;
        try {
            result = (Long)JdbcUtils.getQueryRunner().query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int)result;
    }
}
