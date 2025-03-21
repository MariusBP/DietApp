package classes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {
    Ingredient scampi = new Ingredient("Scampi", "shellfish");
    Ingredient spaghetti = new Ingredient("Spaghetti", "gluten");
    Ingredient heavyCream = new Ingredient("Heavy cream", "lactose");
    Ingredient[] ingredients = {scampi, spaghetti, heavyCream};



    @Test
    void MealContentTest() {
        Meal testMeal = new Meal("Spaghetti al Profumo di mare", 600, "40 minutes", ingredients, DietPreference.PESCATARIAN, "Delicious scampi spaghetti with a creamy garlic sauce");
        assertEquals("Spaghetti al Profumo di mare", testMeal.name);
        assertTrue(testMeal.allergens.contains("lactose"));
        assertEquals(3, testMeal.ingredients.length);
    }

}