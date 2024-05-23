package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Shishupal@2004";

    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}
