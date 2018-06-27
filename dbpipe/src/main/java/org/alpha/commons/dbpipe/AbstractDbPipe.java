package org.alpha.commons.dbpipe;

import org.alpha.commons.dbpipe.auxiliary.PageBean;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:00
 */
public abstract class AbstractDbPipe<E> {


//    ResultSet executeQuery(String rawSql);
//
//    /**
//     * 原始的更新操作
//     * @param rawSql 插入、修改或者删除记录的sql语句
//     * @return 受影响的记录数目
//     */
//    int executeUpdate(String rawSql);
//
//    /**
//     * 批量地执行sql语句
//     * @param rawSqls sql语句数组
//     * @return 执行每条语句而受到影响的记录数目
//     */
//    int[] batch(String[] rawSqls);
//
//
//    /**
//     * 批量地执行sql语句
//     * @param rawSqls sql语句数组
//     * @param params 每条sql语句的占位符对应的参数
//     * @return 执行每条语句而受到影响的记录数目
//     */
//    int[] batch(String[] rawSqls, Object[][] params);
//
//    /**
//     * 添加一个对象
//     * @param element 要添加的对象
//     * @return 添加成功返回 1，否则返回 0
//     */
//    int add(E element);
//
//
//    /**
//     * 更新一个对象
//     * @param element 待更新的对象
//     * @return 若成功更新则返回1，否则返回0
//     */
//    int update(E element);
//
//
//    /**
//     * 更新一个对象，若对象不存在可以选择插入
//     * @param element 待更新的对象
//     * @param bool 当更新的对象不存在时，若该参数为true，则插入该对象，否则不插入该对象
//     * @return 若更新成功则返回 1，否则返回 0
//     */
//    int update(E element, boolean bool);
//
//    /**
//     * 根据id删除一个对象
//     * @param id 待删除对象的id
//     * @param clazz 待删除对象的字节码
//     * @return 删除成功返回 1，否则返回 0
//     */
//    int delete(Integer id, Class<E> clazz);
//
//    /**
//     * 根据id删除一个对象
//     * @param id 待删除对象的id
//     * @param clazz 待删除对象的字节码
//     * @return 删除成功返回 1，否则返回 0
//     */
//    int delete(String id, Class<E> clazz);
//
//    /**
//     * 根据id删除一个对象并将其返回
//     * @param id 待删除对象的id
//     * @param clazz 待删除对象的字节码
//     * @return 若成功删除该对象则将其返回，否则返回 null
//     */
//    E remove(Integer id, Class<E> clazz);
//
//    /**
//     * 根据id删除一个对象并将其返回
//     * @param id 待删除对象的id
//     * @param clazz 待删除对象的字节码
//     * @return 若成功删除该对象则将其返回，否则返回 null
//     */
//    E remove(String id, Class<E> clazz);
//
//    /**
//     * 根据id查找一个对象
//     * @param id 待查找对象的id
//     * @param clazz 待查找对象的字节码
//     * @return 若成功查找对象则将其返回，否则返回 null
//     */
//    E query(Integer id, Class<E> clazz);
//
//    /**
//     * 根据id查找一个对象
//     * @param id 待查找对象的id
//     * @param clazz 待查找对象的字节码
//     * @return 若成功查找对象则将其返回，否则返回 null
//     */
//    E query(String id, Class<E> clazz);
//
//    Object[] queryToArray(String sql);
//
//    List<E> queryToList(String sql, Class<E> clazz);
//
//    Set<E> queryToSet(String sql, Class<E> clazz);
//
//    PageBean<E> query(int pageSize, int pageIndex, Class<E> clazz);
//
//    /**
//     * 查找该类对应的表中记录的数目（对应记录的数目）
//     * @param clazz 对象的字节码
//     * @return 该类对应表中记录的数目
//     */
//    int count(Class<E> clazz);
//
//
//    /**
//     * 查找最大的id
//     * @return
//     */
//    // int getLastAutoIncrementId(Class<E> clazz);
//    int getMaxId(Class<E> clazz);
}
