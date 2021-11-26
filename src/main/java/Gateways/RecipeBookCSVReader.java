package main.java.Gateways;

import main.java.Entities.*;
import main.java.UseCases.Factories.RecipeBookFactory;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UseCases.Utilities.UserFacade;

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
        addSubRecipeBook(UserFacade.getUsername(user), subrecipebookname, subrecipebookdesc);
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
        String username = UserFacade.getUsername(user);
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(subrecipebook);
        String subrecipebookname = subRecipeBookManager.getName();
        String subrecipebookdesc = subRecipeBookManager.getDescription();
        // remove the current line
        removeLine(username + " - " + subrecipebookname, "username - subrecipebookname");

        // add the updated subrecipebook
        addSubRecipeBook(username, subrecipebookname, subrecipebookdesc, subRecipeBookManager.getRecipes());


    }

    private void addSubRecipeBook(String username, String subrecipebookname, String subrecipebookdesc, Recipe[] recipes) {
        ArrayList<String> subrecipebookinfo = new ArrayList<>();
        subrecipebookinfo.add(username);
        subrecipebookinfo.add(username + " - " + subrecipebookname);
        subrecipebookinfo.add(subrecipebookdesc);
        ArrayList<String> recipeList = new ArrayList<>();
        for (Recipe recipe: recipes) {
            recipeList.add(recipe.getName());
        }
        if (recipeList.size() == 0) {
            subrecipebookinfo.add(" ");
        } else {
            subrecipebookinfo.add(String.join(", ", recipeList));
        }

        writeLine(subrecipebookinfo);
    }

    /**
     * Delete the SubRecipeBook from the list of subrecipes.
     * @param user - the user who the sub-recipe book corresponds to
     * @param subrecipebookname - the subrecipebook to be deleted.
     */
    public void deleteSubRecipeBook(User user, String subrecipebookname) {
        removeLine(UserFacade.getUsername(user) + " - " + subrecipebookname, "username - subrecipebookname");
    }

    /**
     * Return the lists of recipes in the subrecipebook with name subrecipebookname for user.
     * @param user - the user whose recipebook is to be returned
     * @param subrecipebook - the subrecipebook from which the recipes to be returned are found.
     *
     * @return - the SubRecipeBook
     */
    public RecipeCollection getSubRecipeBookRecipesList(User user, SubRecipeBook subrecipebook) {
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(subrecipebook);

        for (ArrayList<String> line : readFile())
            if (line.get(1).equals(UserFacade.getUsername(user) + " - " + subRecipeBookManager.getName())) {
                ArrayList<String> recipenames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
                return makerecipelists(recipenames);
            }
        return null;
    }

    public RecipeCollection getSubRecipeBookRecipesList(String username, SubRecipeBook subrecipebook) {
        SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(subrecipebook);

        for (ArrayList<String> line : readFile())
            if (line.get(1).equals(username + " - " + subRecipeBookManager.getName())) {
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
                Recipe recipe = RecipeCollectionFacade.findRecipe(recipelists, recipename);
                RecipeCollectionFacade.addRecipe(recipes, recipe);
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
        return getUserRecipeBook(UserFacade.getUsername(user));
    }

    public RecipeBook getUserRecipeBook(String username) {
        HashMap<SubRecipeBook, RecipeCollection> subrecipebooks = new HashMap<>();
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                // create the subrecipebook
                String[] usernamesubrecipebooknameinfo = line.get(1).split(" - ");
                String subrecipebookname = usernamesubrecipebooknameinfo[1];
                String subrecipebookdesc = line.get(2);
                SubRecipeBook subrecipebook = RecipeBookFactory.createSubRecipeBook(
                        subrecipebookname,
                        subrecipebookdesc
                );
                // get the recipes in the subrecipebook
                RecipeCollection subrecipebookrecipes = getSubRecipeBookRecipesList(username, subrecipebook);
                // add to the subrecipebook - recipes mapping
                subrecipebooks.put(subrecipebook, subrecipebookrecipes);
            }
        }
        return createrecipebook(subrecipebooks);
    }

    private RecipeBook createrecipebook(HashMap<SubRecipeBook, RecipeCollection> subrecipebooks) {
        RecipeBook recipebook = RecipeBookFactory.createRecipeBook();
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        for (SubRecipeBook subrecipebook: subrecipebooks.keySet()) {
            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(subrecipebook);

            recipebookmanager.addSubRecipeBook(
                    subRecipeBookManager.getName(),
                    subRecipeBookManager.getDescription()
            );
            for (Recipe recipe : subrecipebooks.get(subrecipebook)) {
                recipebookmanager.addRecipe(subRecipeBookManager.getName(), recipe);
            }
        }
        return recipebook;
    }
}
