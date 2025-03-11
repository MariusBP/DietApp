package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person testPerson = new Person("Test", "Testerton", 66, 66, DietPreference.CARNIVORE, "shellfish", WeightGoal.GAIN_WEIGHT, Lifestyle.SEDENTARY);

    private Person testPerson2 = new Person("Taserface", "Taserton", 12, 123);
    @Test
    void getFullName() {
        assertEquals("Taserface Taserton", testPerson2.getFullName());
    }

    @Test
    void isNull(){
        assertNull(testPerson2.getLifestyle());
    }

    @Test
    void getFirstName() {
        assertEquals("Test", testPerson.getFirstName());
    }

    @Test
    void setFirstName() {
        testPerson.setFirstName("Test2");
        assertEquals("Test2", testPerson.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Testerton", testPerson.getLastName());
    }

    @Test
    void setLastName() {
        testPerson.setLastName("Testerton2");
        assertEquals("Testerton2", testPerson.getLastName());
    }

    @Test
    void getAge() {
        assertEquals(66, testPerson.getAge());
    }

    @Test
    void setAge() {
        testPerson.setAge(123);
        assertEquals(123, testPerson.getAge());
    }

    @Test
    void getWeight() {
        assertEquals(66, testPerson.getWeight());
    }

    @Test
    void setWeight() {
        testPerson.setWeight(77);
        assertEquals(77, testPerson.getWeight());
    }

    @Test
    void getDietPreferences() {
        assertEquals(DietPreference.CARNIVORE, testPerson.getDietPreferences());
    }

    @Test
    void setDietPreferences() {
        testPerson.setDietPreferences(DietPreference.PESCATARIAN);
        assertEquals(DietPreference.PESCATARIAN, testPerson.getDietPreferences());
    }

    @Test
    void getAllergies() {
        assertEquals("shellfish", testPerson.getAllergies());
    }

    @Test
    void setAllergies() {
        testPerson.setAllergies("peanuts,lactose");
        assertEquals("peanuts,lactose", testPerson.getAllergies());
    }

    @Test
    void getWeightGoal() {
        assertEquals(WeightGoal.GAIN_WEIGHT,testPerson.getWeightGoal());
    }

    @Test
    void setWeightGoal() {
        testPerson.setWeightGoal(WeightGoal.LOSE_WEIGHT);
        assertEquals(WeightGoal.LOSE_WEIGHT, testPerson.getWeightGoal());
    }

    @Test
    void getLifestyle() {
        assertEquals(Lifestyle.SEDENTARY,testPerson.getLifestyle());
    }

    @Test
    void setLifestyle() {
        testPerson.setLifestyle(Lifestyle.OCCASIONALLYACTIVE);
        assertEquals(Lifestyle.OCCASIONALLYACTIVE, testPerson.getLifestyle());
    }
}