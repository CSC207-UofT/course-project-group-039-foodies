package main.java.Gateways;

import main.java.Entities.PreferenceBook;
import main.java.UseCases.Factories.PreferenceBookFactory;

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
        super(path, new String[]{"username", "omit", "include", "recipes", "ratings"});
    }

    /**
     * Create a new preference book given a user object. Used when a new user signs up.
     * @param user The user object being added.
     */
    public void addPreferenceBook(String user) {
        ArrayList<String> emptyRecipes = new ArrayList<>();
        ArrayList<String> emptyRatings = new ArrayList<>();
        ArrayList<String> emptyOmit = new ArrayList<>();
        ArrayList<String> emptyInclude = new ArrayList<>();
        addPreferenceBook(user, emptyOmit, emptyInclude, emptyRecipes, emptyRatings);
    }

    public void addPreferenceBook(String username, ArrayList<String> omit, ArrayList<String> include, ArrayList<String> recipes,
                                  ArrayList<String> ratings) {
        ArrayList<String> prefInfo = new ArrayList<>();

        prefInfo.add(username);
        prefInfo.add(String.join(";", omit));
        prefInfo.add(String.join(";", include));
        prefInfo.add(String.join(";", recipes));
        prefInfo.add(String.join(";", ratings));

        writeLine(prefInfo);
    }

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

    public void removePreferences(String username, int index, String preference) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                String[] arrayUpdate = line.get(index).split(";");
                ArrayList<String> arraylistUpdate = new ArrayList<>();
                for (String x : arrayUpdate) {
                    if (!(Objects.equals(x, preference))) {
                        arraylistUpdate.add(x);
                    }
                }
                line.remove(index);
                line.add(index, String.join(";", arraylistUpdate));
                writeLine(line);
                break;
            }
        }
    }

    public void removePreferences(String username, int index, String preference, int prefIndex) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                removePreferenceBook(username);
                String[] arrayUpdate = line.get(index).split(";");
                ArrayList<String> arraylistUpdate = new ArrayList<>();
                int counter = 0;
                for (String x : arrayUpdate) {
                    if (!(counter == prefIndex)) {
                        arraylistUpdate.add(x);
                    counter++;
                    }
                }
                line.remove(index);
                line.add(index, String.join(";", arraylistUpdate));
                writeLine(line);
                break;
            }
        }
    }

    public void updateOmit(String username, String RemOrAdd, String foodItem) {
        if (Objects.equals(RemOrAdd, "add")) {
            addPreferences(username, 1, foodItem);
        } else {
            removePreferences(username, 1, foodItem);
        }
    }

    public void updateInclude(String username, String RemOrAdd, String foodItem) {
        if (Objects.equals(RemOrAdd, "add")) {
            addPreferences(username, 2, foodItem);
        } else {
            removePreferences(username, 2, foodItem);
        }
    }

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
            removePreferences(username, 4, String.valueOf(rating), index);
        }
    }


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

    public ArrayList<String> ToArrayList (String preferences) {
        if (Objects.equals(preferences, "")) {
            return new ArrayList<>();
        } else {
            String[] prefs = preferences.split(";");
            return new ArrayList<>(Arrays.asList(prefs));
        }
    }

    public PreferenceBook getPreferenceBook(String username) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                return PreferenceBookFactory.createPreferenceBook(
                        username,
                        getRatings(username),
                        ToArrayList(line.get(1)),
                        ToArrayList(line.get(2))
                );
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

