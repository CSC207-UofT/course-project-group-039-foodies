package main.java.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PreferenceBook{
    private final String username;
    private final ArrayList<String> omit;
    private final ArrayList<String> include;
    private HashMap<String, Double> ratingMap;
    private String diet;


    /**
     * create a PreferenceBook for a user
     * @param username username of user
     */
    public PreferenceBook(String username) {
        this.username = username;
        this.omit = new ArrayList<>();
        this.include = new ArrayList<>();
        this.ratingMap = new HashMap<>();
        this.diet = "No Diet";
    }

    /**
     * create a default PreferenceBook for a user given an empty omit and include ArrayList
     * @param username username of user
     * @param omit ingredients to omit
     * @param include ingredients to include
     */
    public PreferenceBook(String username, ArrayList<String> omit, ArrayList<String> include) {
        this.username = username;
        this.omit = omit;
        this.include = include;
        this.ratingMap = new HashMap<>();
        this.diet = "No Diet";
    }

    /**
     * Add a rating to the PreferenceBook
     * @param recipe recipe being rated
     * @param rating numeric rating
     */
    public void addRating(Recipe recipe, Double rating) {
        ratingMap.put(recipe.getName(), rating);
    }

    public void addDiet(String diet) { this.diet = diet; }

    public void addRating(HashMap<String, Double> ratings) { this.ratingMap = ratings; }

    public String getDiet() { return diet; }

    public ArrayList<String> getOmit() { return omit; }

    public ArrayList<String> getInclude() { return include; }

    /**
     * Checks if an item is in a preference category
     * @param OmitInclRating preference category
     * @param item an ingredient or recipe name
     * @return true if item is in given category
     */
    public boolean contains(String OmitInclRating, String item) {
        if (Objects.equals(OmitInclRating, "omit")) {
            return (this.omit.contains(item));
        } else if (Objects.equals(OmitInclRating, "include")) {
            return (this.include.contains(item));
        } else {
            return (this.ratingMap.containsKey(item));
        }
    }
}
