package com.github.mariusbp.dietapp;


import classes.DatabaseHandler;
import classes.Person;

public class Main {
    public static void main(String[] args) {
        Person geralt = DatabaseHandler.fetchPerson("Geralt", "of Rivia");
        System.out.println(geralt.getFullName());
    }
}
