package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.RecipeFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeCSVReader extends CSVReader {
    private final static RecipeCSVReader instance = new RecipeCSVReader(
            System.getProperty("user.dir") + "\\src\\main\\java\\Gateways\\databases\\recipes.csv"
    ); // a singleton

    private final static RecipeCSVReader testInstance = new RecipeCSVReader(
            System.getProperty("user.dir") + "\\src\\test\\java\\GatewaysTests\\recipesTest.csv"
    ); // a singleton for testing safely

    public static RecipeCSVReader getInstance() {
        return instance;
    }

    public static RecipeCSVReader getTestInstance() {
        return testInstance;
    }

    private RecipeCSVReader(String path) {
        super(path, new String[]{"name", "type", "servings", "ingredients", "instructions"});
    }

    /**
     * Adds a recipe to recipes.csv
     * @param recipe The recipe to add
     */
    public void saveRecipe(Recipe recipe) {
        saveRecipe(
                recipe.getName(),
                recipe.getFoodType(),
                recipe.getServings(),
                recipe.getIngredients(),
                recipe.getInstructions()
        );
    }

    /**
     * Adds a recipe to recipes.csv given all the required information
     * @param name The name of the recipe
     * @param type The type of the recipe
     * @param servings The number of people it serves
     * @param ingredients The ingredients in the recipe
     * @param instructions The instructions for making the recipe
     */
    public void saveRecipe(String name, String type, int servings, ArrayList<String> ingredients,
                                  String instructions) {
        ArrayList<String> recipeData = new ArrayList<>();
        recipeData.add(name);
        recipeData.add(type);
        recipeData.add(String.valueOf(servings));
        recipeData.add(String.join(",", ingredients));
        recipeData.add(instructions);

        writeLine(recipeData);
    }

    /**
     * Returns all the recipes stored in the database
     * @return A RecipeDatabase of all the recipes stored
     */
    public RecipeCollection getRecipes() {
        RecipeCollection recipes = new RecipeCollection();
        for (ArrayList<String> line : readFile()) {
            Recipe newRecipe = RecipeFactory.createRecipe(
                    line.get(0),
                    line.get(1),
                    Integer.parseInt(line.get(2)),
                    new ArrayList<>(Arrays.asList(line.get(3).split(","))),
                    line.get(4)
            );
            recipes.addRecipe(newRecipe);
        }

        return recipes;
    }

    /**
     * Removes a recipe from the database
     * @param name The name of the recipe to remove
     */
    public void removeRecipe(String name) {
        removeLine(name, "name");
    }
}
