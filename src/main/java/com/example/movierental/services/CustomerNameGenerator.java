package com.example.movierental.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class CustomerNameGenerator {
    private final static String[] allNames = {"Aaren", "Aarika", "Abagael", "Abagail", "Abbe", "Abbey", "Abbi",
            "Abbie", "Abby", "Abbye", "Abigael", "Abigail", "Abigale", "Abra", "Ada", "Adah", "Adaline", "Adan",
            "Adara", "Adda", "Addi", "Addia", "Addie", "Addy", "Adel", "Adela", "Adelaida", "Adelaide", "Adele",
            "Adelheid", "Adelice", "Adelina", "Adelind", "Adeline", "Adella", "Adelle", "Adena", "Adey", "Adi",
            "Adiana", "Adina", "Adora", "Adore", "Adoree", "Adorne", "Adrea", "Adria", "Adriaens", "Adrian", "Adriana"
            , "Adriane", "Adrianna", "Adrianne", "Adriena", "Adrienne", "Aeriel", "Aeriela", "Aeriell", "Afton", "Ag"
            , "Agace", "Agata", "Agatha", "Agathe", "Aggi", "Aggie", "Aggy", "Agna", "Agnella", "Agnes", "Agnese",
            "Agnesse", "Agneta", "Agnola", "Agretha", "Aida", "Aidan", "Aigneis", "Aila", "Aile", "Ailee", "Aileen",
            "Ailene", "Ailey", "Aili", "Ailina", "Ailis", "Ailsun", "Ailyn", "Aime", "Aimee", "Aimil", "Aindrea",
            "Ainslee", "Ainsley", "Ainslie", "Ajay", "Alaine", "Alameda", "Alana", "Alanah", "Alane", "Alanna",
            "Alayne", "Alberta", "Albertina", "Albertine", "Albina", "Alecia", "Aleda", "Aleece", "Aleen", "Alejandra"
            , "Alejandrina", "Alena", "Alene", "Alessandra", "Aleta", "Alethea", "Alex", "Alexa", "Alexandra",
            "Alexandrina", "Alexi", "Alexia", "Alexina", "Alexine", "Alexis", "Alfi", "Alfie", "Alfreda", "Alfy",
            "Ali", "Alia", "Alica", "Alice", "Alicea", "Alicia", "Alida", "Alidia", "Alie", "Alika", "Alikee", "Alina"
            , "Aline", "Alis", "Alisa"};

    public String generateCustomerName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        int randomNum = new Random().nextInt(allNames.length);
        return allNames[randomNum];
    }
}
