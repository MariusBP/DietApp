package com.github.mariusbp.dietapp;

import classes.Person;
import classes.AddPersonToDatabase;
import classes.WeightGoal;
import classes.Lifestyle;
import classes.DietPreference;


public class Main {
    public static void main(String[] args) {
        Person newPerson = new Person("Geralt", "of Rivia", 83, 115,
                 DietPreference.NONE, "none", WeightGoal.MAINTAIN_WEIGHT, Lifestyle.VERYACTIVE);
        AddPersonToDatabase.insertPerson(newPerson);
    }
}
