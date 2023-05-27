package com.example.movierental.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import java.util.Random;

@ApplicationScoped
@Alternative
public class GirlCustomerNameGenerator implements CustomerNameGenerator {
    private final static String[] allNames = {"Olivia", "Emma", "Charlotte", "Amelia", "Ava", "Sophia", "Isabella",
            "Mia", "Evelyn", "Harper", "Luna", "Camila", "Gianna", "Elizabeth", "Eleanor", "Ella", "Abigail", "Sofia"
            , "Avery", "Scarlett", "Emily", "Aria", "Penelope", "Chloe", "Layla", "Mila", "Nora", "Hazel", "Madison",
            "Ellie", "Lily", "Nova", "Isla", "Grace", "Violet", "Aurora", "Riley", "Zoey", "Willow", "Emilia",
            "Stella", "Zoe", "Victoria", "Hannah", "Addison", "Leah", "Lucy", "Eliana", "Ivy", "Everly", "Lillian",
            "Paisley", "Elena", "Naomi", "Maya", "Natalie"};

    public String generateCustomerName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        int randomNum = new Random().nextInt(allNames.length);
        return allNames[randomNum];
    }
}
