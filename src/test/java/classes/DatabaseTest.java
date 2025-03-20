package classes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.OracleContainer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;

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

        try {
            executeSqlFile("src/test/resources/PERSON.sql", connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    static void executeSqlFile(String filePath, Connection connection) throws Exception {
        String sql = new String(Files.readAllBytes(Path.of(filePath))); // Read file content

        try (Statement stmt = connection.createStatement()) {
            String[] statements = sql.split(";");
            for (String statement : statements) {
                statement = statement.trim();
                if (!statement.isEmpty()) {
                    System.out.println("SQL FILE CONTENT: \n" + sql);
                    System.out.println("Executing: " + statement);
                    stmt.execute(statement);
                }
            }
        }
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null) connection.close();
        if (oracleContainer != null) oracleContainer.stop();
    }
}
