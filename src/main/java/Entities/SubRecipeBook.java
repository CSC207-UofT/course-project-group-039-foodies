package main.java.Entities;

/** A category/ sub recipe book found in user's overall recipe book. Stores the user's saved recipes for this category.
 */
public class SubRecipeBook {
    public final RecipeCollection recipes;
    public final String name;
    public final String description;

    /**
     * Instantiate an empty SubRecipeBook with no name or description provided.
     */
    public SubRecipeBook() {
        this.recipes = new RecipeCollection();
        this.name = "SubRecipe Book";
        this.description = " ";
    }

    /**
     * Instantiate an empty SubRecipeBook with name - name.
     *
     * @param  name - user provided name for the Recipe Book
     */
    public SubRecipeBook(String name) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = " ";
    }

    /**
     * Instantiate an empty SubRecipeBook with name and description.
     *
     * @param name - user provided name of the RecipeBook
     * @param description - user provided description for the RecipeBook
     */
    public SubRecipeBook(String name, String description) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = description;
    }

    /**
     * Return the name of the SubRecipeBook.
     *
     * @return the name of the SubRecipeBook
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the description of the SubRecipeBook.
     *
     * @return the description of the SubRecipeBook
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Add a recipe to the SubRecipeBook.
     *
     * @param recipe - the Recipe object to be added
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.addRecipe(recipe);
    }

    /**
     * Remove the recipe with recipeCode from the SubRecipeBook.
     *
     * @param recipeCode - a unique Integer code identifier for Recipe
     */
    public void removeRecipe(Integer recipeCode) {
        this.recipes.removeRecipe(recipeCode);
    }

    /**
     * Remove a recipe from the SubRecipeBook.
     *
     * @param recipe - the Recipe to delete from the SubRecipeBook
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all recipes in the user's SubRecipeBook.
     *
     * @return - return all the recipes
     */
    public Recipe[] getRecipes() {
        return recipes.getRecipes();
    }

    /**
     * Return the codes of all Recipes in the user's SubRecipeBook.
     *
     * @return - return the codes of recipes found in user's SubRecipeBook
     */
    public Integer[] getCodes() {
        return recipes.getRecipeCodes();
    }

    /**
     * Retrieve the Recipe with recipeCode.
     *
     * @param recipeCode - a unique Integer code identifier for Recipe
     * @return - return the Recipe with recipeCode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.recipes.findRecipe(recipeCode);
    }

    /**
     * Retrieve the recipe with name - name.
     *
     * @param recipeName - the name of the Recipe to return
     * @return the recipe with name - name
     */
    public Recipe getRecipe(String recipeName) {
        return this.recipes.findRecipe(recipeName);
    }

    /**
     * Check if the recipe is contained in the SubRecipeBook.
     *
     * @param recipe - the Recipe to check for in SubRecipeBook
     * @return true if and only if the Recipe is found in the SubRecipeBook and false otherwise
     */
    public boolean containsRecipe(Recipe recipe) {
        return this.recipes.containsRecipe(recipe);
    }

    /**
     * Check if the Recipe with name - name is contained in the SubRecipeBook.
     *
     * @param name the name of the recipe to check for
     * @return true if and only if the Recipe with name - name is found in the SubRecipeBook and false otherwise.
     */
    public boolean containsRecipe(String name) {
        return this.recipes.containsRecipe(name);
    }

    /**
     * Return the number of recipes in the SubRecipeBook.
     *
     * @return an int indicating the number of recipes in the SubRecipeBook.
     */
    public int size() {
        return this.recipes.size();
    }

}