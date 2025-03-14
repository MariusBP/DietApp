package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHandlerTest extends DatabaseTest{

    private DatabaseHandler databaseHandler;

    @BeforeEach
    void init() {
        databaseHandler = new DatabaseHandler(connection);
    }

    private final Person testPerson = new Person("Test", "Testerton", 66, 66, DietPreference.CARNIVORE, "Shellfish", WeightGoal.GAIN_WEIGHT, Lifestyle.SEDENTARY);

    @Test
    void testInsertPerson() {
        databaseHandler.insertPerson(testPerson);
    }

    @Test
    void fetchPerson() {
        Person testPerson = databaseHandler.fetchPerson("Test" , "Testerton");
        assertEquals("Test Testerton", testPerson.getFullName());
    }
}