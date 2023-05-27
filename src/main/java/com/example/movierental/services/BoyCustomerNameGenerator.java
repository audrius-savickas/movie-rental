package com.example.movierental.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@ApplicationScoped
@Alternative
public class BoyCustomerNameGenerator implements CustomerNameGenerator {
    private final static String[] allNames = {"Liam", "Noah", "Oliver", "Elijah", "James", "William", "Benjamin",
            "Lucas", "Henry", "Theodore", "Jack", "Levi", "Alexander", "Jackson", "Mateo", "Daniel", "Michael",
            "Mason", "Sebastian", "Ethan", "Logan", "Owen", "Samuel", "Jacob", "Asher", "Aiden", "John", "Joseph",
            "Wyatt", "David", "Leo", "Luke", "Julian", "Hudson", "Grayson", "Matthew", "Ezra", "Gabriel", "Carter",
            "Isaac", "Jayden", "Luca", "Anthony", "Dylan", "Lincoln", "Thomas", "Maverick", "Elias", "Josiah",
            "Charles", "Caleb", "Christopher", "Ezekiel", "Miles", "Jaxon", "Isaiah", "Andrew", "Joshua", "Nathan",
            "Nolan", "Adrian", "Cameron", "Santiago", "Eli", "Aaron", "Ryan", "Angel", "Cooper", "Waylon", "Easton",
            "Kai", "Christian", "Landon", "Colton", "Roman", "Axel", "Brooks",};

    public String generateCustomerName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        int randomNum = new Random().nextInt(allNames.length);
        return allNames[randomNum];
    }
}
