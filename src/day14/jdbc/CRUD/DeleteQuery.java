package day14.jdbc.CRUD;

/**
 * Created by IVG on 10.10.15.
 */
public class DeleteQuery extends AbstractQuery {

    public DeleteQuery() {}

    @Override
    public String getQuery() {
        return "DELETE FROM users WHERE id = 4";
    }

    @Override
    public String getPrepareQuery() {
        return "DELETE FROM users WHERE id = ?";
    }
}
