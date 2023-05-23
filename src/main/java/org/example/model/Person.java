package org.example.model;

import java.util.ArrayList;

public class Person {
    public String firstName;
    public String lastName;
    public ArrayList<UKGvalues> personValues;

    public Person(String FirstName, String LastName, ArrayList<UKGvalues> PersonValues){
        firstName = FirstName;
        lastName = LastName;
        personValues = PersonValues;
    }
}
