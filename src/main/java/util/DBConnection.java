package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/bookdb?useSSL=false&serverTimezone=UTC";
    private static String jdbcUsername = "root"; // ton user MySQL
    private static String jdbcPassword = ""; // ton mot de passe

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
