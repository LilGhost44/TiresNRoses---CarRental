package Database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    private static final Logger logger = LogManager.getLogger(TestConnection.class);

        public static void main(String[] args) throws SQLException {
            Connection conn = DatabaseConnection.getConnection();

            if (conn != null) {
                logger.info("Connected to Oracle database!");
            } else {
                logger.error("Connection failed.");
            }
        }

}
