package main.java.Gateways;

import main.java.Entities.PreferenceBook;

import java.util.*;

public class PreferenceBookCSVReader extends CSVReader {
    private final static PreferenceBookCSVReader instance = new PreferenceBookCSVReader(
            System.getProperty("user.dir") + "/src/main/java/Gateways/databases/preferences.csv"
    ); // a singleton

    private final static PreferenceBookCSVReader testInstance = new PreferenceBookCSVReader(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/preferencesTest.csv"
    ); // a singleton for testing safely

    public static PreferenceBookCSVReader getInstance() {
        return instance;
    }

    public static PreferenceBookCSVReader getTestInstance() {
        return testInstance;
    }

    protected PreferenceBookCSVReader(String path) {
        super(path, new String[]{"username", "omit", "include", "recipes", "ratings", "diet"});
    }

    /**
     * Create a new preference book given a user object. Default empty preferences when a new user signs up.
     * @param username The user being added.
     */
    public void addPreferenceBook(String username) {
        ArrayList<String> emptyRecipes = new ArrayList<>();
        ArrayList<String> emptyRatings = new ArrayList<>();
        ArrayList<String> emptyOmit = new ArrayList<>();
        ArrayList<String> emptyInclude = new ArrayList<>();
        String defaultDiet = "No Diet";
        addPreferenceBook(username, emptyOmit, emptyInclude, emptyRecipes, emptyRatings, defaultDiet);
    }

    /**
     * Create a new PreferenceBook given all attributes.
      * @param username The username linked to the PreferenceBook
     * @param omit ArrayList of omitted ingredients
     * @param include ArrayList of included ingredients
     * @param recipes Arraylist or recipe names that are rated
     * @param ratings ArrayList of ratings
     * @param diet Diet type
     */
    public void addPreferenceBook(String username, ArrayList<String> omit, ArrayList<String> include, ArrayList<String> recipes,
                                  ArrayList<String> ratings, String diet) {
        ArrayList<String> prefInfo = new ArrayList<>();

        prefInfo.add(username);
        prefInfo.add(String.join(";", omit));
        prefInfo.add(String.join(";", include));
        prefInfo.add(String.join(";", recipes));
        prefInfo.add(String.join(";", ratings));
        prefInfo.add(diet);

        writeLine(prefInfo);
    }

    /**
     * Add an item to preferences
     * @param username The username of PreferenceBook being altered
     * @param index index of desired preference in csv file
     * @param preference preference to be added
     */
    public void addPreferences(String username, int index, String preference) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                String update = line.get(index) + ";" + preference;
                line.remove(index);
                line.add(index, update);
                writeLine(line);
                break;
            }
        }
    }

    /**
     * same as addPreferences function, but specifically for Diet preferences
     * @param username The username of PreferenceBook being altered
     * @param preference preference to be added
     */
    public void addPreferencesDiet(String username, String preference) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                line.remove(5);
                line.add(5, preference);
                writeLine(line);
                break;
            }
        }
    }

    /**
     * Remove a preference at a certain index
     * @param username The username of PreferenceBook being altered
     * @param index index of desired preference in csv file
     * @param preference preference to be added
     */
    public void removePreferences(String username, int index, String preference) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                String[] arrayupdate = line.get(index).split(";");
                ArrayList<String> arraylistupdate = new ArrayList<>();
                for (String x : arrayupdate) {
                    if (!(Objects.equals(x, preference))) {
                        arraylistupdate.add(x);
                    }
                }
                line.remove(index);
                line.add(index, String.join(";", arraylistupdate));
                writeLine(line);
                break;
            }
        }
    }

    /**
     * remove preference item based on its index in the preference
     * @param username The username of PreferenceBook being altered
     * @param index index of desired preference in csv file
     * @param prefIndex preference to be added
     */
    public void removePreferences(String username, int index, int prefIndex) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                String[] arrayupdate = line.get(index).split(";");
                ArrayList<String> arraylistupdate = new ArrayList<>();
                int counter = 0;
                for (String x : arrayupdate) {
                    if (!(counter == prefIndex)) {
                        arraylistupdate.add(x);
                    counter++;
                    }
                }
                line.remove(index);
                line.add(index, String.join(";", arraylistupdate));
                writeLine(line);
                break;
            }
        }
    }

    /**
     * update the omit column in the csv file.
     * @param username username linked to PreferenceBook
     * @param RemOrAdd remove or add rating
     * @param foodItem food item to add or remove
     */
    public void updateOmit(String username, String RemOrAdd, String foodItem) {
        if (Objects.equals(RemOrAdd, "add")) {
            addPreferences(username, 1, foodItem);
        } else {
            removePreferences(username, 1, foodItem);
        }
    }

    /**
     * update the include column in the csv file.
     * @param username username linked to PreferenceBook
     * @param RemOrAdd remove or add rating
     * @param foodItem item to remove or add
     */
    public void updateInclude(String username, String RemOrAdd, String foodItem) {
        if (Objects.equals(RemOrAdd, "add")) {
            addPreferences(username, 2, foodItem);
        } else {
            removePreferences(username, 2, foodItem);
        }
    }

    /**
     * update ratings column in csv file
     * @param username username linked to PreferenceBook
     * @param RemOrAdd remove or add rating
     * @param recipe name of recipe being rating
     * @param rating rating
     */
    public void updateRatings(String username, String RemOrAdd, String recipe, Double rating) {
        if (Objects.equals(RemOrAdd, "add")) {
            addPreferences(username, 3, recipe);
            addPreferences(username, 4, String.valueOf(rating));
        } else {
            int index = 0;
            for (ArrayList<String> line : readFile()) {
                if (line.get(0).equals(username)) {
                    index += getIndex(recipe, line.get(4).split(";"));
                }
            }
            removePreferences(username, 3, recipe);
            removePreferences(username, 4, index);
        }
    }

    /**
     * repace old diet with new diet
     * @param username username linked to PreferenceBook
     * @param diet new diet
     * @param oldDiet old diet
     */
    public void updateDiet(String username, String diet, String oldDiet) {
        removePreferences(username, 5, oldDiet);
        addPreferencesDiet(username, diet);
    }

    /**
     * helper method for getting the index of a recipe in an array
     * @param recipe needed recipe name
     * @param recipes array of recipe names
     * @return int index of recipe name
     */
    public int getIndex(String recipe, String[] recipes) {
        int counter = -1;
        for (String i : recipes) {
            counter++;
            if (Objects.equals(i, recipe)) {
                return counter;
            }
        }
        return counter;
    }
    /**
     * collects all individual ratings into a hashmap
     * @return the hashmap
     */
    public HashMap<String, Double> getRatings(String username) {
        HashMap<String, Double> ratingMap = new HashMap<>();
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                String[] recipes = line.get(3).split(";");
                String[] ratings = line.get(4).split(";");
                if (ratings.length == 1) {
                    return ratingMap;
                } else {
                    for (int i = 1; i < recipes.length; i++) {
                        ratingMap.put(recipes[i], Double.valueOf(ratings[i]));
                    }
                }
            }
        }
        return ratingMap;
    }

    /**
     * getter method for diet attribute
     * @param username username linked to PreferenceBook
     * @return String name of diet
     */
    public String getDiet(String username) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return line.get(5);
            }
        }
        return "";
    }

    /**
     * helper method that turns a string of preferences separated by the delimeter ; to an ArrayList
     * @param preferences string of preferences separated by semicolon
     * @return ArrayList of preferences
     */
    public ArrayList<String> ToArrayList (String preferences) {
        if (Objects.equals(preferences, "")) {
            return new ArrayList<>();
        } else {
            String[] prefs = preferences.split(";");
            return new ArrayList<>(Arrays.asList(prefs));
        }
    }

    /**
     * gets PreferenceBook object of a user by building it from csv data
     * @param username username linked to PreferenceBook
     * @return the users PreferenceBook
     */
    public PreferenceBook getPreferenceBook(String username) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                PreferenceBook newBook = new PreferenceBook(username, ToArrayList(line.get(1)), ToArrayList(line.get(2)));
                newBook.addRating(getRatings(username));
                newBook.addDiet(getDiet(username));
                return newBook;
            }
        }
        return null;
    }

    /**
     * Removes a preference book from the database
     * @param user The name of the recipe to remove
     */
    public void removePreferenceBook(String user) {
        removeLine(user, "username");
    }

}

