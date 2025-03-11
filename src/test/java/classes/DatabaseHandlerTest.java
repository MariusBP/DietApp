package classes;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;
class DatabaseHandlerTest {

    private DatabaseHandler databaseHandler;
    private Person test = new Person("Test", "Testerton", 66, 66, DietPreference.CARNIVORE, "Shellfish", WeightGoal.GAIN_WEIGHT, Lifestyle.SEDENTARY);

    @Test
    void insertPerson() {
        assertEquals(1, 2-1);//TODO
    }

    @Test
    void fetchPerson() {
        Person geralt = DatabaseHandler.fetchPerson("Geralt", "of Rivia");
        assert geralt != null;
        assertEquals( "Geralt of Rivia", geralt.getFullName());
    }
}