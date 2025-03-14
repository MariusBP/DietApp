package classes;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestcontainersTest {

    @Test
    void testOracleContainerStarts() {
        try (OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe:21-slim")) {
            oracle.start();
            assertTrue(oracle.isRunning());
        }
    }
}
