package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
   //jdbc:oracle:thin:@HOST:PORT:SID
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USER = "emma";
    private static final String PASS = "23221030";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
