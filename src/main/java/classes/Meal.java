package classes;

public class Meal {
    String name;
    Integer calories;
    String prepTime;
    Ingredient[] ingredients;
    String allergens;
    DietPreference dietPreference;
    String description;

    public Meal(String name, Integer calories, String prepTime, Ingredient[] ingredients, DietPreference dietPreference, String allergens, String description) {
        this.name = name;
        this.calories = calories;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.dietPreference = dietPreference;
        this.allergens = allergens;
        this.description = description;
    }
}
