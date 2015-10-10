package day14.jdbc.CRUD;

/**
 * Created by IVG on 10.10.15.
 */
public class UpdateQuery extends AbstractQuery {

    public UpdateQuery() {}

    @Override
    public String getQuery() {
        return "UPDATE users SET name = 'Vlad', age = 10 WHERE id = 1";
    }

    @Override
    public String getPrepareQuery() {
        return "UPDATE users SET name = ?, age = ? WHERE id = ?";
    }
}
