package V2.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

        public static void main(String[] args) throws SQLException {
            Connection conn = DatabaseConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to Oracle database!");
            } else {
                System.out.println("Connection failed.");
            }
        }

}
