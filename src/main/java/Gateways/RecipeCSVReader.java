package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeCollection;
import main.java.UseCases.RecipeFactory;
import main.java.UseCases.Utilities.RecipeCollectionFacade;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeCSVReader extends CSVReader {
    private final static RecipeCSVReader instance = new RecipeCSVReader(
            System.getProperty("user.dir") + "/src/main/java/Gateways/databases/recipes.csv"
    ); // a singleton

    private final static RecipeCSVReader testInstance = new RecipeCSVReader(
            System.getProperty("user.dir") + "/src/test/java/GatewaysTests/recipesTest.csv"
    ); // a singleton for testing safely

    public static RecipeCSVReader getInstance() {
        return instance;
    }

    public static RecipeCSVReader getTestInstance() {
        return testInstance;
    }

    private RecipeCSVReader(String path) {
        super(path, new String[]{"name", "type", "servings", "ingredients", "instructions", "rating", "ratingcount"});
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
        recipeData.add("-1"); //rating, -1 means not yet rated
        recipeData.add("0"); //rating count

        writeLine(recipeData);
    }

    /**
     * Returns all the recipes stored in the database
     * @return A RecipeDatabase of all the recipes stored
     */
    public RecipeCollection getRecipes() {
        RecipeCollection recipes = new RecipeCollection();
        for (ArrayList<String> line : readFile()) {
            //adding ratings
            double rating, ratingCount;
            if (line.size() == 7) { //recipe already has previous ratings
                rating = Double.parseDouble(line.get(5));
                ratingCount = Double.parseDouble(line.get(6));
            } else { //recipe hasn't been rated yet
                rating = -1.0;
                ratingCount = 0.0;
            }
            Recipe newRecipe = RecipeFactory.createRecipe(
                    line.get(0),
                    line.get(1),
                    Integer.parseInt(line.get(2)),
                    new ArrayList<>(Arrays.asList(line.get(3).split(","))),
                    line.get(4),
                    rating,
                    ratingCount
            );



            //add to collection
            RecipeCollectionFacade.addRecipe(recipes, newRecipe);
        }

        return recipes;
    }

    /**
     * Add a cumulative rating to a recipe
     */
    public void addRating(String recipeName, double rating, double ratingCount) {
        for (ArrayList<String> line : readFile()) {
            if (line.get(0).equals(recipeName)) {
                removeRecipe(recipeName);
                if (line.size() == 7) {
                    line.remove(6);
                    line.remove(5);
                }
                //already calculated rating/count
                line.add(String.valueOf(rating));
                line.add(String.valueOf(ratingCount));
                writeLine(line);
                break;
            }
        }
    }


    /**
     * Removes a recipe from the database
     * @param name The name of the recipe to remove
     */
    public void removeRecipe(String name) {
        removeLine(name, "name");
    }
}
