package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Meal {
    String name;
    Integer calories;
    String prepTime;
    Ingredient[] ingredients;
    String allergens;
    String lifestyle;
    String description;

    public Meal(String name, Integer calories, String prepTime, Ingredient[] ingredients, String lifestyle, String description) {
        this.name = name;
        this.calories = calories;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.lifestyle = lifestyle;
        this.description = description;

    }
}
