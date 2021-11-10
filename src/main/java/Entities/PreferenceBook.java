package main.java.Entities;

import main.java.Entities.User;

import java.util.HashMap;

public class PreferenceBook{
    private final User user;
    private final String type;
    private final String omit;
    private final String include;
    private final String time;
    private final HashMap<String, Double> ratingMap;

    public PreferenceBook(User user) {
        this.user = user;
        this.type = "";
        this.omit = "";
        this.include = "";
        this.time = "";
        this.ratingMap = new HashMap<>();

    }

    public void addRating(Recipe recipe, Double rating) {
        ratingMap.put(recipe.getName(), rating);
    }

}
