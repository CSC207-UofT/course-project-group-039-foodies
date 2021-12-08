package main.java.Gateways.RecipeAPI;

import main.java.Entities.RecipeCollection;
import main.java.Gateways.RecipeCSVReader;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class RecipeGateway {
    /**
     * Builds a RecipeGateway to convert raw recipe files to Recipe object and store them in the recipe database.
     */
    RecipeCollection recipes;
    String apiKey = "3e3f6a9ae4b24bec81a0588db64551bf";  // needed for authentication

    public RecipeGateway(RecipeCollection recipes) {
        this.recipes = recipes;
    }

    /**
     * Gets recipes from the Spoonacular API and adds them to recipe.csv
     *
     * Do not use this method for large values of number, it is prone to stackOverFlows.
     * Use safeGetNewRecipes instead.
     *
     * @param number The number of recipes to add to the database
     */
    public void getNewRecipes(int number) {
        JSONObject parsedLine = requestJSON(number);

        for (int i = 0; i < number; i++) {
            assert parsedLine != null;
            JSONObject parsedRecipe = parsedLine.get("recipes").index(i);

            RecipeCSVReader.getInstance().saveRecipe(
                    parsedRecipe.get("title").toString(),
                    getType(parsedRecipe),
                    Integer.parseInt(parsedRecipe.get("servings").toString()),
                    getIngredients(parsedRecipe),
                    parsedRecipe.get("instructions").toString()
            );
        }
    }

    /**
     * Gets recipes from Spoonacular API and adds them to recipes.csv
     * Does this by calling getNewRecipes multiple times, avoiding stackOverFlow errors.
     *
     * @param number The number of new recipes to be added
     */
    public void safeGetNewRecipes(int number) {
        for (int i = 0; i < number; i += 3) {
            getNewRecipes(3);
        }
        int remaining = number % 3;
        if (remaining != 0) {
            getNewRecipes(remaining);
        }
    }

    /**
     * Makes an HTTP GET request and returns a JSONObject representing the gathered data
     * @param number The number of recipes to request
     * @return A JSONObject representing the received data
     */
    private JSONObject requestJSON(int number) {
        try {
            URI recipeURL = new URI(
                    "https://api.spoonacular.com/recipes/random?apiKey="
                            + apiKey + "&instructionsRequired=true&number=" + number + "&addRecipeInformation=true"
            );

            HttpRequest request = HttpRequest.newBuilder().uri(recipeURL).GET().build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JSONParser jsonParser = new JSONParser(response.body());
            return jsonParser.parseLine();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Creates a list of all the ingredients in the recipe from the JSONObject
     * @param parsedRecipe The recipe JSONObject taken from the request
     * @return The arraylist of ingredients
     */
    private ArrayList<String> getIngredients(JSONObject parsedRecipe) {
        ArrayList<String> ingredients = new ArrayList<>();
        for (JSONObject ingredient : parsedRecipe.get("extendedIngredients")) {
            ingredients.add(ingredient.get("name").toString());
        }

        return ingredients;
    }

    /**
     * Returns the type of recipe taken from the JSONObject
     * @param parsedRecipe The JSONObject taken from the request
     * @return The string representing the type, if it exists
     */
    private String getType(JSONObject parsedRecipe) {
        JSONObject dishTypes = parsedRecipe.get("dishTypes");
        if (dishTypes.size() == 0) {
            return "";
        } else {
            return dishTypes.index(0).toString();
        }
    }

    public static void main(String[] args) {
        RecipeGateway rg = new RecipeGateway(new RecipeCollection());

        rg.safeGetNewRecipes(100);
    }
}

