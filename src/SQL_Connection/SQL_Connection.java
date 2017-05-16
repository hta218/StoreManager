/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Huynh
 */
public class SQL_Connection {

    private static Connection conn;
    private static final String server = "localhost";
    private static final String port = "1433";
    private static final String username = "sa";
    private static final String instancename = "HUYNHTUANANH218";
    private static final String password = "tuananh1k95";
    private static final String database = "Project";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + server + "\\" + instancename + ":" + port + ";"
                + "databaseName = " + database;
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    
    public static void close() throws SQLException{
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }
}
