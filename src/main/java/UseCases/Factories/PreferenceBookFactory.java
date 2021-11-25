package main.java.UseCases.Factories;

import main.java.Entities.PreferenceBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PreferenceBookFactory {
    /**
     * Create a PreferenceBook
     * @param username The username of the User corresponding to the preference book
     * @param ratings The ratings already given by the User
     * @param omit The ingredients to omit
     * @param include The ingredients to include
     * @return A preferenceBook correctly initialized
     */
    public static PreferenceBook createPreferenceBook(String username, HashMap<String, Double> ratings,
                                                      ArrayList<String> omit, ArrayList<String> include) {
        PreferenceBook newBook = new PreferenceBook(username, omit, include);
        newBook.addRatings(ratings);
        return newBook;
    }
}
