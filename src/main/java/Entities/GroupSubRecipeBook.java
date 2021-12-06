package main.java.Entities;

/** A category/ sub recipe book found in group's overall recipe book. Stores the group's saved recipes for this category.
 */
public class GroupSubRecipeBook {
    public final RecipeCollection recipes;
    public final String name;
    public final String description;

    /**
     * Instantiate an empty group sub-recipe book with no name or description provided.
     */
    public GroupSubRecipeBook() {
        this.recipes = new RecipeCollection();
        this.name = "Group SubRecipe Book";
        this.description = " ";
    }

    /**
     * Instantiate an empty group sub-recipe book with name.
     *
     * @param  name - user provided name for the GroupSubRecipeBook
     */
    public GroupSubRecipeBook(String name) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = " ";
    }

    /**
     * Instantiate an empty group sub-recipe book with name and description.
     *
     * @param name - user provided name of the GroupSubRecipeBook
     * @param description - user provided description for the GroupSubRecipeBook
     */
    public GroupSubRecipeBook(String name, String description) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the name of the GroupSubRecipeBook.
     * @return String representing the name of the GroupSubRecipeBook.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the description of the GroupSubRecipeBook.
     * @return String representing the description of the GroupSubRecipeBook.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Add a Recipe object to the GroupSubRecipeBook.
     * @param recipe - the recipe object to be added
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.addRecipe(recipe);
    }

    /**
     * Remove the recipe with recipeCode from the GroupSubRecipeBook.
     * @param recipeCode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipeCode) {
        this.recipes.removeRecipe(recipeCode);
    }

    /**
     * Remove a recipe from the GroupSubRecipeBook.
     * @param recipe - the recipe to delete
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all recipes in the user's GroupSubRecipeBook
     * @return - return the recipes
     */
    public Recipe[] getRecipes() {
        return recipes.getRecipes();
    }

    /**
     * Return the codes of all recipes in the user's GroupSubRecipeBook
     * @return - return the codes
     */
    public Integer[] getCodes() {
        return recipes.getRecipeCodes();
    }

    /**
     * Retrieve the recipe with recipeCode.
     * @param recipeCode - a unique String code identifier for Recipe
     * @return - return the recipe with recipeCode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.recipes.findRecipe(recipeCode);
    }

    /**
     * Retrieve the recipe with name.
     * @param recipeName - the name of the recipe to return
     * @return a Recipe object with name
     */
    public Recipe getRecipe(String recipeName) {
        return this.recipes.findRecipe(recipeName);
    }

    /**
     * Check if a recipe exists in the RecipeCollection.
     * @param recipe - the Recipe object to check
     * @return a boolean representing whether the recipe exists in RecipeCollection
     */
    public boolean containsRecipe(Recipe recipe) {
        return this.recipes.containsRecipe(recipe);
    }

    /**
     * Check if a recipe exists in the RecipeCollection.
     * @param name - the name of the recipe to check
     * @return a boolean representing whether the recipe exists in RecipeCollection
     */
    public boolean containsRecipe(String name) {
        return this.recipes.containsRecipe(name);
    }

    /**
     * Return the number of recipes in the GroupSubRecipeBook.
     * @return an int indicating the number of recipes in the GroupSubRecipeBook.
     */
    public int size() {
        return this.recipes.size();
    }
}

