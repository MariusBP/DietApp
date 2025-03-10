package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDatabaseHandler {

    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    // Method to insert a new meal into the database
    public void addMeal(String name, int calories, int prepTime, String dietPreference, String description) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to insert a new meal
            String sql = "INSERT INTO Meals (name, calories, prepTime, dietPreference, description) VALUES (?, ?, ?, ?, ?)";

            // Prepare the statement
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, calories);
            stmt.setInt(3, prepTime);
            stmt.setString(4, dietPreference);
            stmt.setString(5, description);

            // Execute the insert statement
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new meal was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to fetch a meal from the database by name
    public void fetchMeal(String mealName) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "your_username", "your_password");

            // SQL query to fetch a meal by name
            String sql = "SELECT * FROM Meals WHERE name = ?";

            // Prepare the statement
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, mealName);

            // Execute the query
            rs = stmt.executeQuery();

            // Check if the meal exists and print details
            if (rs.next()) {
                System.out.println("Meal Name: " + rs.getString("name"));
                System.out.println("Calories: " + rs.getInt("calories"));
                System.out.println("Preparation Time: " + rs.getInt("prepTime"));
                System.out.println("Diet Preference: " + rs.getString("dietPreference"));
                System.out.println("Description: " + rs.getString("description"));
            } else {
                System.out.println("No meal found with the name " + mealName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to fetch meals based on a person's preferences
    public List<String> fetchMealsByPreferences(String dietPreference, List<String> allergies) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> meals = new ArrayList<>();

        try {
            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to fetch meals based on preferences
            String sql =
                    """
                    SELECT DISTINCT m.name
                            FROM Meals m
                            JOIN Meal_Ingredients mi ON m.meal_id = mi.meal_id
                            JOIN Ingredients i ON mi.ingredient_id = i.ingredient_id
                            WHERE m.dietPreference = ?
                            AND NOT EXISTS (
                                SELECT 1 FROM Ingredients i2
                                JOIN Meal_Ingredients mi2 ON i2.ingredient_id = mi2.ingredient_id
                                WHERE mi2.meal_id = m.meal_id
                                AND i2.allergens IN ("?,".repeat(allergies.size() - 1) ?)
                            )""";
            // Prepare statement
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, dietPreference); // Set diet preference

            // Set allergens dynamically
            int index = 2;
            for (String allergen : allergies) {
                stmt.setString(index++, allergen);
            }

            // Execute query
            rs = stmt.executeQuery();

            // Process result set
            while (rs.next()) {
                meals.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return meals;
    }

    public static void main(String[] args) {
        MealDatabaseHandler dbHandler = new MealDatabaseHandler();

        // Example usage
        List<String> allergies = new ArrayList<>();
        allergies.add("Dairy");
        allergies.add("Gluten");

        List<String> meals = dbHandler.fetchMealsByPreferences("VEGETARIAN", allergies);

        // Print the meals
        if (meals.isEmpty()) {
            System.out.println("No meals found matching preferences.");
        } else {
            System.out.println("Available Meals:");
            for (String meal : meals) {
                System.out.println("- " + meal);
            }
        }
    }

}
