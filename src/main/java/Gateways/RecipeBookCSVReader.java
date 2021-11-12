package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.Entities.SubRecipeBook;
import main.java.Entities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class RecipeBookCSVReader extends CSVReader {

    /**
     * Create a RecipeBookCSVReader of the csv file with directory path path and
     * a list of string indicating the columns.
     *
     * @param path - the directory path of the csv file.
     */
    protected RecipeBookCSVReader(String path) {
        super(path, new String[]{"username - subrecipebookname", "recipelist"});
    }

    /**
     * Add a SubRecipeBook category to the subrecipebook list for user, when there are no recipes in the subrecipebook.
     * @param user - the user to which the sub-recipe book belongs
     * @param subrecipebook - the subrecipe book that was created.
     */
    public void addnewSubRecipeBook(User user, SubRecipeBook subrecipebook) {
        addSubRecipeBook(user.getUsername(), subrecipebook.getName());
    }

    /**
     * Helper function used to add the new subrecipebook to the CSV file
     * @param username - the username of the user whom the subrecipebook belongs
     * @param subrecipebookname - the name of the subrecipebook
     */
    private void addSubRecipeBook(String username, String subrecipebookname) {
        ArrayList<String> newsubrecipebookinfo = new ArrayList<>();
        String username_subrecipebookname = username + " - " + subrecipebookname;
        newsubrecipebookinfo.add(username_subrecipebookname);
        newsubrecipebookinfo.add(" ");

        writeLine(newsubrecipebookinfo);
    }

    /**
     * Update the list of recipes for a subrecipebook of a particular user.
     * @param user - the username of the user
     * @param subrecipebook - the name of the subrecipebook to add to
     */
    public void updateRecipeBookCSV(User user, SubRecipeBook subrecipebook) {
        String username = user.getUsername();
        String subrecipebookname = subrecipebook.getName();
        // remove the current line
        removeLine(username + " - " + subrecipebookname, "username - subrecipebookname");

        // add the updated subrecipebook
        addSubRecipeBook(user.getUsername(), subrecipebook.getName(), subrecipebook.getRecipes());


    }

    private void addSubRecipeBook(String username, String subrecipebookname, Recipe[] recipes) {
        ArrayList<String> subrecipebookinfo = new ArrayList<>();
        subrecipebookinfo.add(username + " - " + subrecipebookname);
        ArrayList<String> recipelist = new ArrayList<>();
        for (Recipe recipe: recipes) {
            recipelist.add(recipe.getName());
        }
        subrecipebookinfo.add(String.join(", ", recipelist));

        writeLine(subrecipebookinfo);
    }


    /**
     * Return the lists of recipes in the subrecipebook with name subrecipebookname for user.
     * @param user - the user whose recipebook is to be returned
     * @param subrecipebook - the subrecipebook from which the recipes to be returned are found.
     *
     * @return - the SubRecipeBook
     */
    public RecipeCollection getSubRecipeBookList(User user, SubRecipeBook subrecipebook) {
    for (ArrayList<String> line : readFile())
        if (line.get(0).equals(user.getUsername() + " - " + subrecipebook.getName())) {
            ArrayList<String> recipenames = new ArrayList<>(Arrays.asList(line.get(1). split(",")));
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
            Recipe recipe = recipelists.findRecipe(recipename);
            recipes.addRecipe(recipe);
        }
        return recipes;

    }

    /**
     * Delete the SubRecipeBook from the list of subrecipes.
     * @param user - the user who the sub-recipe book corresponds to
     * @param subrecipebook - the subrecipebook to be deleted.
     */
    public void deleteSubRecipeBook(User user, SubRecipeBook subrecipebook) {
        removeLine(user.getUsername() + " - " + subrecipebook.getName(), "username - subrecipebookname");
    }

}
