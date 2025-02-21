package classes;

import java.sql.*;

public class AddPersonToDatabase {
    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static void insertPerson(Person newPerson) {
        String sql = "INSERT INTO ? (first_name, last_name, age, weight, lifestyle, diet_preference, weight_goal, allergies) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, USER);
            pstmt.setString(2, newPerson.getFirstName());
            pstmt.setString(3, newPerson.getLastName());
            pstmt.setInt(4, newPerson.getAge());
            pstmt.setDouble(5, newPerson.getWeight());
            pstmt.setString(6, newPerson.getLifestyle().toString());
            pstmt.setString(7, newPerson.getDietPreferences().toString());
            pstmt.setString(8, newPerson.getWeightGoal().toString());
            pstmt.setString(9, newPerson.getAllergies());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new person was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting person: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
