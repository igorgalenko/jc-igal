package day14.jdbc.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IVG on 10.10.15.
 */
public class DBConnection {

//    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/mydbtest";
    private final String USER_NAME = "root";
    private final String PASS = "root";

    public Connection getConnection() {

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS)) {

            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}
