package day14.jdbc.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IVG on 10.10.15
 */
public class Main {

    private static final boolean USING_STATEMENT = true;
    private static Connection connection;

    public static void main(String[] args) {

        connection = new DBConnection().getConnection();

        executeQuery(new InsertQuery());
        executeQuery(new UpdateQuery());
        executeQuery(new DeleteQuery());

    }

    private static void executeQuery(AbstractQuery query) {

        if (USING_STATEMENT) {

            try (Statement statement = connection.createStatement()) {

                statement.executeUpdate(query.getQuery());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {

            try (PreparedStatement statement = connection.prepareStatement(query.getPrepareQuery())) {

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
