package classes;

import java.sql.*;

public class DatabaseHandler {
    private static Connection connection;

    public DatabaseHandler(Connection connection){
        DatabaseHandler.connection = connection;
    }

    public DatabaseHandler(){
        String URL = System.getenv("DB_URL");
        String USER = System.getenv("DB_USERNAME");
        String PASSWORD = System.getenv("DB_PASSWORD");
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertPerson(Person newPerson) {
        String sql = "INSERT INTO person (first_name, last_name, age, weight, lifestyle, diet_preference, weight_goal, allergies) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newPerson.getFirstName());
            pstmt.setString(2, newPerson.getLastName());
            pstmt.setInt(3, newPerson.getAge());
            pstmt.setDouble(4, newPerson.getWeight());
            pstmt.setString(5, newPerson.getLifestyle().toString());
            pstmt.setString(6, newPerson.getDietPreferences().toString());
            pstmt.setString(7, newPerson.getWeightGoal().toString());
            pstmt.setString(8, newPerson.getAllergies());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new person was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting person: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Person fetchPerson(String firstName, String lastName) {
        String sql = "SELECT first_name, last_name, age, weight, lifestyle, diet_preference, weight_goal, allergies FROM person WHERE first_name = ? AND last_name = ?";

        try (
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                try {


                    return new Person(
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("age"),
                            rs.getDouble("weight"),
                            DietPreference.valueOf(rs.getString("diet_preference")),
                            rs.getString("allergies"),
                            WeightGoal.valueOf(rs.getString("weight_goal")),
                            Lifestyle.valueOf(rs.getString("lifestyle"))
                    );
                } catch (IllegalArgumentException | SQLException e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
