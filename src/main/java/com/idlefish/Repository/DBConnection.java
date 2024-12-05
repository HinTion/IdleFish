package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://124.220.48.224:3306/IdleFish?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "ZhangBoluo";
    private static final String PASSWORD = "Zy121212.";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}