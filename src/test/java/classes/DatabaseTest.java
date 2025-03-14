package classes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.OracleContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseTest {

    protected static OracleContainer oracleContainer;
    protected static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        oracleContainer = new OracleContainer("gvenzl/oracle-xe:21-slim");
        oracleContainer.start();

        connection = DriverManager.getConnection(
                oracleContainer.getJdbcUrl(),
                oracleContainer.getUsername(),
                oracleContainer.getPassword()
        );
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null) connection.close();
        if (oracleContainer != null) oracleContainer.stop();
    }
}
