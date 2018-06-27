package edu.dbu.util;
import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-19 20:28
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws Exception{
        Connection conn = JDBCUtil.getConnection();
        Assert.assertNotNull(conn);
        System.out.println(conn);
    }
}
