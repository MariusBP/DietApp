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

    private final Person testPerson = new Person("Test", "Testerton", 66, 77, DietPreference.CARNIVORE, "Shellfish", WeightGoal.GAIN_WEIGHT, Lifestyle.SEDENTARY);

    @Test
    public void testInsertPerson() {
        databaseHandler.insertPerson(testPerson);

        Person insertedPerson = databaseHandler.fetchPerson("Test", "Testerton");
        assertNotNull(insertedPerson);
        assertEquals("Test", insertedPerson.getFirstName());
        assertEquals("Testerton", insertedPerson.getLastName());
        assertEquals(66, insertedPerson.getAge());
        assertEquals(77, insertedPerson.getWeight());
    }

    @Test
    void fetchPerson() {
        databaseHandler.insertPerson(testPerson);
        Person testPerson = databaseHandler.fetchPerson("Test" , "Testerton");
        assertEquals("Test Testerton", testPerson.getFullName());
    }
}