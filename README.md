# DatabaseHandler Project

## Overview
This project provides a simple Java-based database handler for managing person-related data, including attributes like name, age, weight, lifestyle, diet preferences, and allergies. The project integrates with an OracleDB database, utilizing JDBC for database operations.

## Features
- Insert a person's data into the database
- Fetch a person's data from the database
- Insert ingredients and meals into the database
- Fetch a meal from the database
- Uses environment variables for database credentials
- Supports enum-based values for `Lifestyle`, `DietPreference`, and `WeightGoal`

## Technologies Used
- Java 23
- OracleDB
- Docker
- JDBC

## Environment Variables
To configure database access, set the following environment variables:
- `DB_URL` – The database connection URL
- `DB_USERNAME` – The database username
- `DB_PASSWORD` – The database password

## Classes and Enums
### `DatabaseHandler`
Handles database interactions for inserting and fetching `Person` records.
### `MealDatabaseHandler`
Handles interactions for inserting and fetching `Meal` records.

#### Methods:
- `insertPerson(Person newPerson)`: Inserts a new person into the database.
- `fetchPerson(String firstName, String lastName)`: Retrieves a person’s data based on their name.
- `insertMeal(String name, int calories, int prepTime, String dietPreference, String description)`: Inserts a new meal into the database.
- `fetchMeal(String mealName)`: Retrieves a meal by name, and prints it to console.
- `fetchMealsByPreferences(String dietPreference, List<String> allergies)`: Fetches a list of meals matching the allergies and diet preference supplied. 

### `Diet`
Represents a person's dietary preferences, including:
- `String allergies`
- `DietPreference diet`
- `WeightGoal goal`

### `DietPreference` (Enum)
Defines different diet preferences:
- `NONE`
- `CARNIVORE`
- `VEGETARIAN`
- `VEGAN`
- `PESCATARIAN`

### `Lifestyle` (Enum)
Defines levels of physical activity:
- `SEDENTARY`
- `OCCASIONALLYACTIVE`
- `OFTENACTIVE`
- `VERYACTIVE`

## Usage
### Insert a Person
Call `insertPerson(newPerson)` to add a person to the database.
```java
Person person = new Person("John", "Doe", 30, 75.5, Lifestyle.OFTENACTIVE, DietPreference.VEGAN, WeightGoal.LOSE_WEIGHT, "Nuts");
DatabaseHandler.insertPerson(person);
```

### Fetch a Person
Call `fetchPerson("John", "Doe")` to retrieve a person’s information.
```java
Person person = DatabaseHandler.fetchPerson("John", "Doe");
if (person != null) {
    System.out.println("Person found: " + person.getFirstName() + " " + person.getLastName());
}
```
