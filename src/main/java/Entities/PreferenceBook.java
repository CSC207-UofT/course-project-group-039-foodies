package main.java.Entities;

import main.java.Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class PreferenceBook{
    private final User user;
    private final ArrayList<String> type;
    private final ArrayList<String> omit;
    private final ArrayList<String> include;
    private final ArrayList<String> time;
    private final HashMap<String, Double> ratingMap;

    public PreferenceBook(User user) {
        this.user = user;
        this.type = new ArrayList<>();
        this.omit = new ArrayList<>();
        this.include = new ArrayList<>();
        this.time = new ArrayList<>();
        this.ratingMap = new HashMap<>();

    }

    public PreferenceBook(User user, ArrayList<String> type, ArrayList<String> omit, ArrayList<String> include,
                          ArrayList<String> time) {
        this.user = user;
        this.type = type;
        this.omit = omit;
        this.include = include;
        this.time = time;
        this.ratingMap = new HashMap<>();
    }

    public void addRating(Recipe recipe, Double rating) {
        ratingMap.put(recipe.getName(), rating);
    }

}
