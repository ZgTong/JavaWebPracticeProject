package com.tzg.test;

import com.tzg.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        Connection conn  = JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.closeConnection(conn);
    }
}
