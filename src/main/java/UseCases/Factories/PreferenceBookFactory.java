package main.java.UseCases.Factories;

import main.java.Entities.PreferenceBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PreferenceBookFactory {
    public static PreferenceBook createRecipeCollection(String username, HashMap<String, Double> ratings,
                                                          ArrayList<String> omit, ArrayList<String> include) {
        PreferenceBook newBook = new PreferenceBook(username, omit, include);
        newBook.addRatings(ratings);
        return newBook;
    }
}
