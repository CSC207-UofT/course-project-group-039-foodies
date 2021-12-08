package main.java.Gateways;

import main.java.Entities.*;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;

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
     * Create a RecipeBookCSVReader of the csv file with directory path- path and
     * a list of string indicating the columns.
     *
     * @param path - the directory path of the csv file.
     */
    protected RecipeBookCSVReader(String path) {
        super(path, new String[]{"username", "username - subRecipeBookName", "subRecipeBookDesc", "recipeList"});
    }

    /**
     * Add a SubRecipeBook category to the sub-recipe book list for user, when there are no recipes in the sub-recipe book.
     *
     * @param user - the user to which the sub-recipe book belongs
     * @param subRecipeBookName - the name of sub-recipe book that was created.
     * @param subRecipeBookDesc - the sub-recipe book description
     */
    public void addNewSubRecipeBook(User user, String subRecipeBookName, String subRecipeBookDesc) {
        addSubRecipeBook(user.getUsername(), subRecipeBookName, subRecipeBookDesc);
    }

    /**
     * Helper function used to add the new sub-recipe book to the CSV file.
     *
     * @param username - the username of the user whom the sub-recipe book belongs
     * @param subRecipeBookName - the name of the sub-recipe book
     * @param subRecipeBookDesc - the description of the sub-recipe book
     */
    private void addSubRecipeBook(String username, String subRecipeBookName, String subRecipeBookDesc) {
        ArrayList<String> newSubRecipeBookInfo = new ArrayList<>();
        String usernameSubRecipeBookName = username + " - " + subRecipeBookName;
        newSubRecipeBookInfo.add(username);
        newSubRecipeBookInfo.add(usernameSubRecipeBookName);
        newSubRecipeBookInfo.add(subRecipeBookDesc);
        newSubRecipeBookInfo.add(" ");

        writeLine(newSubRecipeBookInfo);
    }

    /**
     * Checks if the sub-recipe book exists with a certain username and subRecipeBookName.
     *
     * @param username - the username to check
     * @param subRecipeBookName - the name of the sub-recipe book
     * @return true iff there is a sub-recipe book with the name subRecipeBookName for a user with name username
     */
    public boolean isSubRecipeBook(String username, String subRecipeBookName) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(1).equals(username + " - " + subRecipeBookName)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Update the list of recipes for a sub-recipe book of a particular user.
     *
     * @param user - the username of the user
     * @param subRecipeBook - the name of the sub-recipe book to add to
     */
    public void updateRecipeBookCSV(User user, SubRecipeBook subRecipeBook) {
        String username = user.getUsername();
        String subRecipeBookName = subRecipeBook.getName();
        String subRecipeBookDesc = subRecipeBook.getDescription();
        // remove the current line
        removeLine(username + " - " + subRecipeBookName, "username - subRecipeBookName");

        // add the updated subRecipeBook
        addSubRecipeBook(username, subRecipeBookName, subRecipeBookDesc, subRecipeBook.getRecipes());


    }

    private void addSubRecipeBook(String username, String subRecipeBookName, String subRecipeBookDesc, Recipe[] recipes) {
        ArrayList<String> subRecipeBookInfo = new ArrayList<>();
        subRecipeBookInfo.add(username);
        subRecipeBookInfo.add(username + " - " + subRecipeBookName);
        subRecipeBookInfo.add(subRecipeBookDesc);
        ArrayList<String> recipeList = new ArrayList<>();
        for (Recipe recipe: recipes) {
            recipeList.add(recipe.getName());
        }
        if (recipeList.size() == 0) {
            subRecipeBookInfo.add(" ");
        } else {
            subRecipeBookInfo.add(String.join(", ", recipeList));
        }

        writeLine(subRecipeBookInfo);
    }

    /**
     * Delete the sub-recipe book from the list of sub-recipe books.
     *
     * @param user - the user who the sub-recipe book corresponds to
     * @param subRecipeBookName - the sub-recipe book to be deleted
     */
    public void deleteSubRecipeBook(User user, String subRecipeBookName) {
        removeLine(user.getUsername() + " - " + subRecipeBookName, "username - subRecipeBookName");
    }


    /**
     * Return a list of recipes found in a sub-recipe book for user with username.
     *
     * @param username - the name of the user
     * @param subRecipeBook - the sub-recipe book whose recipes are returned
     * @return a list of the recipes in sub-recipe book
     */
    public RecipeCollection getSubRecipeBookRecipesList(String username, SubRecipeBook subRecipeBook) {
        for (ArrayList<String> line : readFile())
            if (line.get(1).equals(username + " - " + subRecipeBook.getName())) {
                ArrayList<String> recipeNames = new ArrayList<>(Arrays.asList(line.get(3). split(", ")));
                return makeRecipeLists(recipeNames);
            }
        return null;
    }

    /**
     * Generate the RecipeCollection containing the set of recipes in the sub-recipe book.
     *
     * @param recipeNames - an array list of the names of recipes
     * @return - a collection of recipes
     */
    private RecipeCollection makeRecipeLists(ArrayList<String> recipeNames) {
        RecipeCollection recipes = new RecipeCollection();
        RecipeCollection recipeLists = RecipeCSVReader.getInstance().getRecipes();
        for (String recipeName: recipeNames) {
            if (!recipeName.equals(" ")) {
                Recipe recipe = RecipeCollectionFacade.findRecipe(recipeLists, recipeName);
                RecipeCollectionFacade.addRecipe(recipes, recipe);
            }
        }
        return recipes;
    }

    /**
     * Return the recipe book for a user with username.
     *
     * @param username - the name of the user whose recipe book to get
     * @return a RecipeBook corresponding to a user.
     */
    public RecipeBook getUserRecipeBook(String username) {
        HashMap<SubRecipeBook, RecipeCollection> subRecipeBooks = new HashMap<>();
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(username)) {
                // create the sub-recipe book
                String[] usernameSubRecipeBookNameInfo = line.get(1).split(" - ");
                String subRecipeBookName = usernameSubRecipeBookNameInfo[1];
                String subRecipeBookDesc = line.get(2);
                SubRecipeBook subrecipebook = new SubRecipeBook(subRecipeBookName, subRecipeBookDesc);
                // get the recipes in the sub-recipe book
                RecipeCollection subRecipeBookRecipes = getSubRecipeBookRecipesList(username, subrecipebook);
                // add to the sub-recipe book - recipes mapping
                subRecipeBooks.put(subrecipebook, subRecipeBookRecipes);
            }
        }
        return createRecipeBook(subRecipeBooks);
    }

    private RecipeBook createRecipeBook(HashMap<SubRecipeBook, RecipeCollection> subrecipebooks) {
        RecipeBook recipebook = new RecipeBook();
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        for (SubRecipeBook subrecipebook: subrecipebooks.keySet()) {
            recipebookmanager.addSubRecipeBook(subrecipebook.getName(), subrecipebook.getDescription());
            for (Recipe recipe : subrecipebooks.get(subrecipebook)) {
                recipebookmanager.addRecipe(subrecipebook.getName(), recipe);
            }
        } return recipebook;
    }
}
