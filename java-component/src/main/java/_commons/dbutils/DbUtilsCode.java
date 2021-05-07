package _commons.dbutils;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-26 17:12
 */
public class DbUtilsCode {
    // org.apache.commons.dbutils;
    AbstractQueryRunner abstractQueryRunner = null;
    QueryRunner queryRunner = null;
    DbUtils dbUtils = null;

    ResultSetHandler rsh = null;


    // org.apache.commons.dbutils.handlers;
    BeanHandler beanHandler = null;
    BasicRowProcessor basicRowProcessor = null;
    BeanProcessor beanProcessor = null;


    BeanListHandler beanListHandler = null;

}
