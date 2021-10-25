package main.java.Gateways;

import main.java.Entities.Recipe;
import main.java.Entities.RecipeDatabase;
import main.java.UseCases.RecipeFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class RecipeCSVReader {
    private static final String databasePath = System.getProperty("user.dir")
            + "\\src\\main\\java\\Gateways\\databases\\recipes.csv";

    /**
     * Adds a recipe to recipes.csv
     * @param recipe The recipe to add
     * @throws IOException when the csv file is not found
     */
    public static void saveRecipe(Recipe recipe) throws IOException {
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
     * @throws IOException when the csv file is not found
     */
    public static void saveRecipe(String name, String type, int servings, ArrayList<String> ingredients,
                                  String instructions) throws IOException{
        ArrayList<String> recipeData = new ArrayList<>();
        recipeData.add(name);
        recipeData.add(type);
        recipeData.add(String.valueOf(servings));
        recipeData.addAll(ingredients);
        recipeData.add(fixInstructions(instructions));
        recipeData.add("\n");
        Files.write(
                Paths.get(databasePath),
                String.join(",", recipeData).getBytes(),
                StandardOpenOption.APPEND
        );
    }

    /**
     * Returns all the recipes stored in the database
     * @return A RecipeDatabase of all the recipes stored
     * @throws IOException when the csv file is missing
     */
    public static RecipeDatabase getRecipes() throws IOException {
        BufferedReader recipeCSV = new BufferedReader(new FileReader(databasePath));
        String row = recipeCSV.readLine();
        RecipeDatabase recipes = new RecipeDatabase();
        while (row != null){
            row = recipeCSV.readLine();
            String[] data = row.split(",");
            recipes.addRecipe(createRecipe(data));
        }
        recipeCSV.close();
        return recipes;
    }

    /**
     * Parse a line of the CSV file into a recipe
     * @param data A line of the CSV file
     * @return A recipe the line represents
     */
    private static Recipe createRecipe(String[] data) {
        String name = data[0];
        String type = data[1];
        int servings = Integer.parseInt(data[2]);
        ArrayList<String> ingredients = getIngredients(data);

        String instructions = readInstructions(data[data.length - 1]);
        return RecipeFactory.createRecipe(name, type, servings, ingredients, instructions);
    }

    /**
     * Gets the ingredients from a line of the CSV file.
     * Starting from index 3, the ingredients are listed until the word 'end ingredients'
     * is read.
     * @param data A line of the CSV file
     * @return A list of the ingredients within it
     */
    private static ArrayList<String> getIngredients(String[] data) {
        int checkIndex = 3;
        ArrayList<String> ingredients = new ArrayList<>();
        while (!data[checkIndex].equals("end ingredients")) {
            ingredients.add(data[checkIndex]);
            checkIndex++;
        }

        return ingredients;
    }

    /**
     * Fixes the instructions so that a String with newlines can be stored on one line of the csv
     * @param instruction A String representing the instructions
     * @return A String representing the instructions that can be stored in a csv
     */
    private static String fixInstructions(String instruction) {
        return instruction.replace("\n", "\\n");
    }

    /**
     * Fixes the instructions read from the csv file so that the newlines are restored.
     * @param instructions A String representing the instructions stored in the csv
     * @return A String representing the instructions correctly formatted
     */
    private static String readInstructions(String instructions) {
        return instructions.replace("\\n", "\n");
    }
}
