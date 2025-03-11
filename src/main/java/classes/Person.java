package classes;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private DietPreference dietPreferences;
    private String allergies;
    private WeightGoal weightGoal;
    private Lifestyle lifestyle;

    public Person(String firstName, String lastName, int age, double weight, DietPreference dietPreferences, String allergies, WeightGoal weightGoal, Lifestyle lifestyle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.dietPreferences = dietPreferences;
        this.allergies = allergies;
        this.weightGoal = weightGoal;
        this.lifestyle = lifestyle;
    }

    public Person(String firstName, String lastName, int age, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;

    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public DietPreference getDietPreferences() {
        return dietPreferences;
    }

    public void setDietPreferences(DietPreference dietPreferences) {
        this.dietPreferences = dietPreferences;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public WeightGoal getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(WeightGoal weightGoal) {
        this.weightGoal = weightGoal;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

}
