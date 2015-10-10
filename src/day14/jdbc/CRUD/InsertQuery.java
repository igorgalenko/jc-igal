package day14.jdbc.CRUD;

/**
 * Created by IVG on 07.10.15.
 */
public class InsertQuery extends AbstractQuery {

    public InsertQuery() {}

    @Override
    public String getQuery() {
        return "INSERT INTO users (name, age, email) VALUES ('Obama', 51, 'black_man@gmail.com')";
    }

    @Override
    public String getPrepareQuery() {
        return "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";
    }

}
