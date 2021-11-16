package main.java.Gateways;

import main.java.Entities.*;
import main.java.UseCases.RecipeBookManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class RecipeBookCSVReader extends CSVReader {
    private final static RecipeBookCSVReader instance = new RecipeBookCSVReader(
            System.getProperty("user.dir") + "/src/main/java/Gateways/databases/recipebooksfile.csv"
    ); // a singleton

    private final static RecipeBookCSVReader testInstance = new RecipeBookCSVReader(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/recipebookTests.csv"
    ); // a singleton for testing safely

    public static RecipeBookCSVReader getInstance() {
        return instance;
    }

    public static RecipeBookCSVReader getTestInstance() {
        return testInstance;
    }

    /**
     * Create a RecipeBookCSVReader of the csv file with directory path path and
     * a list of string indicating the columns.
     *
     * @param path - the directory path of the csv file.
     */
    protected RecipeBookCSVReader(String path) {
        super(path, new String[]{"username", "username - subrecipebookname", "subrecipebookdesc", "recipelist"});
    }

    /**
     * Add a SubRecipeBook category to the subrecipebook list for user, when there are no recipes in the subrecipebook.
     * @param user - the user to which the sub-recipe book belongs
     * @param subrecipebookname - the name of subrecipebook that was created.
     * @param subrecipebookdesc - the subrecipebook desc
     */
    public void addnewSubRecipeBook(User user, String subrecipebookname, String subrecipebookdesc) {
        addSubRecipeBook(user.getUsername(), subrecipebookname, subrecipebookdesc);
    }

    /**
     * Helper function used to add the new subrecipebook to the CSV file
     * @param username - the username of the user whom the subrecipebook belongs
     * @param subrecipebookname - the name of the subrecipebook
     * @param subrecipebookdesc - the description of the subrecipebook
     */
    private void addSubRecipeBook(String username, String subrecipebookname, String subrecipebookdesc) {
        ArrayList<String> newsubrecipebookinfo = new ArrayList<>();
        String username_subrecipebookname = username + " - " + subrecipebookname;
        newsubrecipebookinfo.add(username);
        newsubrecipebookinfo.add(username_subrecipebookname);
        newsubrecipebookinfo.add(subrecipebookdesc);
        newsubrecipebookinfo.add(" ");

        writeLine(newsubrecipebookinfo);
    }

    /**
     * Checks if the subrecipebook exists with a certain username and subrecipebookname.
     * @param username - the username to check
     * @param subrecipebookname - the name of the subrecipebook
     * @return A boolean representing whether there is a subrecipebook
     */
    public boolean isSubRecipeBook(String username, String subrecipebookname) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(1).equals(username + " - " + subrecipebookname)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Update the list of recipes for a subrecipebook of a particular user.
     * @param user - the username of the user
     * @param subrecipebook - the name of the subrecipebook to add to
     */
    public void updateRecipeBookCSV(User user, SubRecipeBook subrecipebook) {
        String username = user.getUsername();
        String subrecipebookname = subrecipebook.getName();
        String subrecipebookdesc = subrecipebook.getDescription();
        // remove the current line
        removeLine(username + " - " + subrecipebookname, "username - subrecipebookname");

        // add the updated subrecipebook
        addSubRecipeBook(username, subrecipebookname, subrecipebookdesc, subrecipebook.getRecipes());


    }

    private void addSubRecipeBook(String username, String subrecipebookname, String subrecipebookdesc, Recipe[] recipes) {
        ArrayList<String> subrecipebookinfo = new ArrayList<>();
        subrecipebookinfo.add(username);
        subrecipebookinfo.add(username + " - " + subrecipebookname);
        subrecipebookinfo.add(subrecipebookdesc);
        ArrayList<String> recipelist = new ArrayList<>();
        for (Recipe recipe: recipes) {
            recipelist.add(recipe.getName());
        }
        subrecipebookinfo.add(String.join(", ", recipelist));

        writeLine(subrecipebookinfo);
    }

    /**
     * Delete the SubRecipeBook from the list of subrecipes.
     * @param user - the user who the sub-recipe book corresponds to
     * @param subrecipebookname - the subrecipebook to be deleted.
     */
    public void deleteSubRecipeBook(User user, String subrecipebookname) {
        removeLine(user.getUsername() + " - " + subrecipebookname, "username - subrecipebookname");
    }

    /**
     * Return the lists of recipes in the subrecipebook with name subrecipebookname for user.
     * @param user - the user whose recipebook is to be returned
     * @param subrecipebook - the subrecipebook from which the recipes to be returned are found.
     *
     * @return - the SubRecipeBook
     */
    public RecipeCollection getSubRecipeBookRecipesList(User user, SubRecipeBook subrecipebook) {
    for (ArrayList<String> line : readFile())
        if (line.get(1).equals(user.getUsername() + " - " + subrecipebook.getName())) {
            ArrayList<String> recipenames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
            return makerecipelists(recipenames);
        }
    return null;
    }

    public RecipeCollection getSubRecipeBookRecipesList(String username, SubRecipeBook subrecipebook) {
        for (ArrayList<String> line : readFile())
            if (line.get(1).equals(username + " - " + subrecipebook.getName())) {
                ArrayList<String> recipenames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
                return makerecipelists(recipenames);
            }
        return null;
    }

    /**
     * Generate the RecipeCollection containing the set of recipes in the subrecipebook
     * @param recipenames - an array list of the names of recipes
     * @return - a collection of recipes
     */
    private RecipeCollection makerecipelists(ArrayList<String> recipenames) {
        RecipeCollection recipes = new RecipeCollection();
        RecipeCollection recipelists = RecipeCSVReader.getInstance().getRecipes();
        for (String recipename: recipenames) {
            if (!recipename.equals(" ")) {
                Recipe recipe = recipelists.findRecipe(recipename);
                recipes.addRecipe(recipe);
            }
        }
        return recipes;
    }

    /**
     * Return a list of the SubRecipesBooks for a particular user.
     * @param user - the user who the subrecipebooks correspond to.
     * @return an arraylist containing the subrecipebooks of user
     */
    public RecipeBook getUserRecipeBook(User user) {
        HashMap<SubRecipeBook, RecipeCollection> subrecipebooks = new HashMap<>();
        for (ArrayList<String> line: readFile()) {
            if (line.get(0).equals(user.getUsername())) {
                // create the subrecipebook
                String[] usernamesubrecipebooknameinfo = line.get(1).split(" - ");
                String subrecipebookname = usernamesubrecipebooknameinfo[1];
                String subrecipebookdesc = line.get(2);
                SubRecipeBook subrecipebook = new SubRecipeBook(subrecipebookname, subrecipebookdesc);
                // get the recipes in the subrecipebook
                RecipeCollection subrecipebookrecipes = getSubRecipeBookRecipesList(user,subrecipebook);
                // add to the subrecipebook - recipes mapping
                subrecipebooks.put(subrecipebook, subrecipebookrecipes);
            }
        }
        return createrecipebook(subrecipebooks);
    }

    public RecipeBook getUserRecipeBook(String username) {
        HashMap<SubRecipeBook, RecipeCollection> subrecipebooks = new HashMap<>();
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                // create the subrecipebook
                String[] usernamesubrecipebooknameinfo = line.get(1).split(" - ");
                String subrecipebookname = usernamesubrecipebooknameinfo[1];
                String subrecipebookdesc = line.get(2);
                SubRecipeBook subrecipebook = new SubRecipeBook(subrecipebookname, subrecipebookdesc);
                // get the recipes in the subrecipebook
                RecipeCollection subrecipebookrecipes = getSubRecipeBookRecipesList(username, subrecipebook);
                // add to the subrecipebook - recipes mapping
                subrecipebooks.put(subrecipebook, subrecipebookrecipes);
            }
        }
        return createrecipebook(subrecipebooks);
    }

    private RecipeBook createrecipebook(HashMap<SubRecipeBook, RecipeCollection> subrecipebooks) {
        RecipeBook recipebook = new RecipeBook();
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        for (SubRecipeBook subrecipebook: subrecipebooks.keySet()) {
            recipebookmanager.addSubRecipeBook(subrecipebook.getName(), subrecipebook.getDescription());
            for (Recipe recipe : subrecipebooks.get(subrecipebook)) {
                recipebookmanager.addRecipe(subrecipebook.getName(), recipe);
            }
        } return recipebook;
    }


//        for (ArrayList<String> line: readFile()) {
//            if (line.get(0).equals(user.getUsername())) {
//                String[] usernamesubrecipebooknamesplit = line.get(1).split(" - ");
//                String subrecipebookname = usernamesubrecipebooknamesplit[1];
//                // create a list of the recipes in subrecipebook
//                ArrayList<Recipe> recipes = new ArrayList<>();
//                RecipeCollection recipedatabase = RecipeCSVReader.getInstance().getRecipes();
//                for (String recipename: line.get(2).split(",")) {
//                    recipes.add(recipedatabase.findRecipe(recipename));
//                }
//                subrecipebooks.put(subrecipebookname, recipes);
//            }
//        }
//        return makerecipebook(subrecipebooks);
//    }
//
//    private RecipeBook makerecipebook(HashMap<String, ArrayList<Recipe>> subrecipebooks) {
//        RecipeBook recipebook = new RecipeBook();
//        for(String subrecipebookname: subrecipebooks.keySet()) {
//            recipebook.addSubRecipeBook();
//            for (Recipe recipe: subrecipebooks.get(subrecipebookname)) {
//                recipebook.addRecipe();
//            }
//        }
//    }


    // find all of the subrecipe books
    // regenerate all of the subrecipe books
    // re-add all of the recipes in each subrecipe book to each of the recipe books


}
