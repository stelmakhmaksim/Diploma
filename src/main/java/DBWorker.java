import java.sql.*;

/**
 * Created by Maks on 3/22/2017.
 */
public class DBWorker {
    private final String URL = "jdbc:postgresql://localhost:5432/IE";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "0309";


    private Connection connection = null;

    public DBWorker() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
