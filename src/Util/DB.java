package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection con=null;
    public static Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/GYM_MANAGEMENT_SYSTEM";
        final String USER = "root";
        final String PSW = "Jai@282003";
        try {
            return con=DriverManager.getConnection(URL,USER, PSW);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
