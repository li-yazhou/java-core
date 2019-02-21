# 实现自己的ORM框架

写作时间：2017年08月20日 18:58:41



---

本文将介绍简单的ORM框架的实现过程。为了能够顺利的读懂本文，你需要有JDBC、注解和反射的基础知识。
先看看效果，一条语句实现插入和更新操作。

```
// 创建SimpleDbPipe对象
SimpleDbPipe<Student> dbPipe = new SimpleDbPipe<Student>();
// 创建一个带插入数据库中的对象
Student student = new Student(1001, "zhouzhou", 22);
// 将对象（记录）保存到数据库中
dbPipe.add(student);

// 更新id为1001的记录
student = new Student(1001, "new_zhouzhou", 24);
// 更新数据库中的记录
dbPipe.update(student);
```




### 01 创建数据库和表
说明，这里使用的是MySQL数据库，版本号是 5.6。
假如，我们有一张关于学生基本信息的表，它包括学生的id，姓名，年龄和生日等四个字段。
创建数据库和表的SQL语句如下：

```
create database dbpipe;
create table student(
    student_id int(11) not null auto_increment,
    name varchar(32) not null,
    age int(11),
    birthday date,
    primary key(student_id)
);
```


----------


### 02 表对应的类
为了能够以对象的形式操作数据库中的表，我们需要创建一个跟表相对应的类Student。
如下：
```
public class Student {
    private int studentNo;
    private String name;
    private int age;
    private Calendar birthday;

    public Student(){ super(); }
    public Student(int studentNo, String name, int age){
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
    }

	// setter/getter方法
	
```


----------


## 03 关联表和类——注解
为了能够实现ORM，我们的类需要和表关联起来，其中需要关联的信息包括

 1. 表名和类名
 2. 表中的字段和类中的属性

为了能够使操作数据库的程序通过类获得表的名称，我们需要开发一个使用在类名的注解，这个注解将实现类名和表名的一一对应的关系。

```
package simpleorm.core;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String name();
}
```

这个Table注解只可以使用在类上，它有一个方法，用来获得和类名对应的表的名称。

接下来，我们需要实现第二点，把表中的字段和类中的属性关联起来。在数据库中键，尤其是id，是有别于普通的字段的，据此我们可以把字段分为两种类型：id和普通的字段。

我们可以开发一个标识id的注解

```
package simpleorm.core;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:44
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
    String name();
    String type() default "int";
    int length() default 20;
    int increment() default 1;
}
```
@Id注解包括四个方法，通过它们可以获得表中id的名称，id 的类型，以及id字段的长度，如果是id类型是int型的整数，可以获得自动增长量。

另外，对于一般的字段，我们也可以开发一个如下的注解标识。

```
package simpleorm.core;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:44
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String name();
    String type() default "string";
    int length() default 20;
}
```

@Column只包含有获得表的名称、类型和长度的三个方法。


----------


## 04 实现表和类的关联
以上，我们已经创建了表和类，开发了关联两者的注解，所以可以改造之前的Student类，以实现表和类的关联。

```
package simpleorm.test;

import simpleorm.core.Column;
import simpleorm.core.Id;
import simpleorm.core.Table;

import java.util.Calendar;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
@Table(name="student")
public class Student {
    @Id(name = "student_id")
    private int studentNo;
    @Column(name = "name")
    private String name;
    @Column(name = "age", type = "int")
    private int age;
    @Column(name = "birthday", type = "Calendar")
    private Calendar birthday;

    public Student(){ super(); }
    public Student(int studentNo, String name, int age){
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
    }

	// setter和getter方法
}    
```


----------


## 05 操作数据库- JdbcUtils工具类
为了能够连接以及操作数据库中的表，我们需要一个访问数据库的类。这个类中包含有获得数据库连接的方法，操作数据库的方法executeUpdate，以及释放资源的方法。

为了能够很好的说明ORM的实现过程，这里并没有使用配置文件，数据库连接池等比较好的访问数据库的方式。比如，此处的getConn方法实现了获取连接的功能，虽然它的性能并不好，但这不是本文重点关注的内容。

public static int excuteUpdate(String sql, Object[] params) 这个方法，可以执行增加、删除和修改的SQL语句。

```
package simpleorm.core;

import java.sql.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:07
 */
public class JdbcUtils {

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///dbpipe", "root", "root");
        }catch(Exception e){
            System.out.println("获取连接对象失败.");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 增删改
     * @param sql 预编译SQL语句
     * @param params 参数
     * @return 受影响的记录数目
     */
    public static int excuteUpdate(String sql, Object[] params){
        Connection connection = null;
        PreparedStatement pstmt =null;
        int result = -1;
        try {
            connection = getConn();
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i ++){
                pstmt.setObject(i+1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("更新数据出现异常.");
            System.out.println(e.getMessage());
        } finally {
            release(pstmt, connection);
        }
        return result;  // 更新数据失败
    }


    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}

```


----------


## 06 简单的ORM框架-SimpleDbPipe

通过层层铺垫，终于来到了本文的重点部分。下面我们将实现以对象的形式往数据库中添加数据的方法。

要想操作数据，归根节点还是要使用这座独木桥JDBC，以上05-JdbcUtils中封装了一个操作数据库中表的方法excuteUpdate，它的签名如下：    
>public static int excuteUpdate(String sql, Object[] params)

它需要两个参数，sql和params，它们分别表示预编译SQL语句和SQL中的参数。

因此，为了能够操作数据库，我们需要得到这两个参数。现在，我们的目的是以对象的形式操作数据库，也就意味着我们只有表所对应的对象这一个参数。

很显然，我们可以通过对象的getter方法获取到params数组参数。

上面的第4步使用注解实现表和类的关联，所以我们可以使用反射技术获得到数据库中表的信息，也就能够生成SQL语句。

这样，我们就获得了跟jdbc需要的两个参数。
代码步长，大概思路是

----------


### 以对象的形式插入一条记录

以下，实现了以对象的形式向数据库中添加一条记录的方法 add。
整个方法分为两个步骤：

一是，获得预编译的插入记录的SQL语句sql
>使用反射获得类上@Table注解，调用name()方法可以获得表的名称；
使用反射获得类中字段的个数，也就相当于知道了预编译的插入记录的SQL语句中的占位符的个数。
只要有表名和字段的个数就可以拼凑出预编译的SQL语句，类似于 “insert into student values(?,?,?,?)”。

二是，获得预编译SQL语句中占位符对应的参数 params
>使用字节码的getDeclaredFields()方法获得Field[]数组
>数组中的每一个Field对象执行fields[i].get(obj)即可得到占位符对应的参数

最后，执行 JdbcUtils.excuteUpdate(sql, params) ，就完成了以对象的形式向数据库中插入一条记录。

```
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
    
    String sql = getInsertSql(tableName, fields.length);
    Object[] params = getSqlParams(element, fields);
    System.out.println("insertSql = " + sql);
    System.out.println(Arrays.toString(params));
    return  JdbcUtils.excuteUpdate(sql, params);
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
```


----------


### 以对象的形式更新一条记录

以下，实现了以对象的形式向数据库中更新一条记录的方法 update。
和add方法一样，这个方法分为两个步骤：

一是，获得预编译的更新记录的SQL语句sql
>使用反射获得类上@Table注解，调用name()方法可以获得表的名称；
>使用反射获得类中的每个字段，进而获得类的字段上注解@Id或者@Column，之后可以获得字段对应的表中的列名。
这样就可以拼凑出预编译的SQL更新记录的语句，类似于 
“update student set  name = ? , age = ? , birthday = ? where student_id = ?”。

二是，获得预编译SQL语句中占位符对应的参数 params
>使用字节码的getDeclaredFields()方法获得Field[]数组
>数组中的每一个Field对象执行fields[i].get(obj)即可得到占位符对应的参数

最后，执行 JdbcUtils.excuteUpdate(sql, params) ，就完成了以对象的形式更新数据库中的一条记录。


```
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
     return JdbcUtils.excuteUpdate(sql, params);
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
```

我们将add和update这两个方法封装在SimpleDbPipe类中了。


----------


## 07 测试

### 使用ORM框架


```
// 创建SimpleDbPipe对象
SimpleDbPipe<Student> dbPipe = new SimpleDbPipe<Student>();
// 创建一个带插入数据库中的对象
Student student = new Student(1001, "zhouzhou_" + i, i * 2);
// 将对象（记录）保存到数据库中
dbPipe.add(student);

// 更新id为1001的记录
student = new Student(1001, "new_zhouzhou_" + i, i * 2);
// 更新数据库中的记录
dbPipe.update(student);
```
使用SimpleDbPipe，可以实现只用一句话达到增删改的目的，它大大简化了访问数据库的操作。


----------


### 单元测试

下面我们进行单元测试

```
package orm.simpleorm.test;

import org.junit.Test;
import simpleorm.core.SimpleDbPipe;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-20 16:19
 */
public class SimpleDbPipeTest {
    private static SimpleDbPipe<Student> dbPipe = new SimpleDbPipe<Student>();

    @Test
    public void addTest(){
        Student student = null;
        for (int i = 0; i < 10; i ++){
            student = new Student(i, "zhouzhou_" + i, i * 2);
            dbPipe.add(student);
        }
    }

    @Test
    public void updateTest(){
        Student student = null;
        for (int i = 0; i < 10; i ++){
            student = new Student(i, "new_zhouzhou_" + i, i * 2);
            dbPipe.update(student);
        }
    }
}

```

执行addTest()方法后，查询数据库中student表的结果如下：

```
+------------+------------+------+----------+
| student_id | name       | age  | birthday |
+------------+------------+------+----------+
|          1 | zhouzhou_1 |    2 | NULL     |
|          2 | zhouzhou_2 |    4 | NULL     |
|          3 | zhouzhou_3 |    6 | NULL     |
|          4 | zhouzhou_4 |    8 | NULL     |
|          5 | zhouzhou_5 |   10 | NULL     |
|          6 | zhouzhou_6 |   12 | NULL     |
|          7 | zhouzhou_7 |   14 | NULL     |
|          8 | zhouzhou_8 |   16 | NULL     |
|          9 | zhouzhou_9 |   18 | NULL     |
+------------+------------+------+----------+
```
可见，有9条记录被我们插入到student表中了。

----------


执行updateTest()方法时，查询数据库中的结果如下：

```
+------------+----------------+------+----------+
| student_id | name           | age  | birthday |
+------------+----------------+------+----------+
|          1 | new_zhouzhou_1 |    2 | NULL     |
|          2 | new_zhouzhou_2 |    4 | NULL     |
|          3 | new_zhouzhou_3 |    6 | NULL     |
|          4 | new_zhouzhou_4 |    8 | NULL     |
|          5 | new_zhouzhou_5 |   10 | NULL     |
|          6 | new_zhouzhou_6 |   12 | NULL     |
|          7 | new_zhouzhou_7 |   14 | NULL     |
|          8 | new_zhouzhou_8 |   16 | NULL     |
|          9 | new_zhouzhou_9 |   18 | NULL     |
+------------+----------------+------+----------+
```
可见，student表中的所有的name列被成功地更新了。


----------


## 展望
这里，我们仅仅讲解了添加和更新对象两个方法。依据以上的思路，我们可以实现删除对象、查询对象等操作。此外，也可以考虑添加提交、回滚等事务功能。


----------


## 附录
SimpleDbPipe是本文的核心代码，如下：

```
package simpleorm.core;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:01
 */
public class SimpleDbPipe<E> {

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
        return  JdbcUtils.excuteUpdate(sql, params);
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
        System.out.println("update sql = " + sql);
        System.out.println("params = " + Arrays.toString(params));
        return JdbcUtils.excuteUpdate(sql, params);
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
}
```
