package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeDatabase;
import main.java.UseCases.RecipeFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeCSVReader extends CSVReader {

    private final static RecipeCSVReader instance = new RecipeCSVReader(); // a singleton

    public static RecipeCSVReader getInstance() {
        return instance;
    }

    private RecipeCSVReader() {
        super(System.getProperty("user.dir")
                + "\\src\\main\\java\\Gateways\\databases\\recipes.csv");
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
    public RecipeDatabase getRecipes() {
        RecipeDatabase recipes = new RecipeDatabase();
        for (ArrayList<String> line : readFile()) {
            Recipe newRecipe = RecipeFactory.createRecipe(
                    line.get(0),
                    line.get(1),
                    Integer.parseInt(line.get(2)),
                    new ArrayList<>(Arrays.asList(line.get(2).split(","))),
                    line.get(3)
            );
            recipes.addRecipe(newRecipe);
        }

        return recipes;
    }
}
