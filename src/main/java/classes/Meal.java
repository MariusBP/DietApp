package classes;

public class Meal {
    String name;
    Integer calories;
    String prepTime;
    Ingredient[] ingredients;
    DietPreference dietPreference;
    String allergens;
    String description;

    public Meal(String name, Integer calories, String prepTime, Ingredient[] ingredients, DietPreference dietPreference, String description) {
        this.name = name;
        this.calories = calories;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.dietPreference = dietPreference;
        this.description = description;

        this.allergens = getAllergensFromIngredients();
    }

    private String getAllergensFromIngredients() {
        StringBuilder allergens = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            allergens.append(ingredient.allergens).append(", ");
        }
        return allergens.toString();
    }
}
