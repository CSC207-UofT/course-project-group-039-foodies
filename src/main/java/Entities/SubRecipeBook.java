package main.java.Entities;

import main.java.UseCases.Filters.Filter;
import main.java.UseCases.Sorts.Sort;

/** A category / sub recipe book found in user's overall recipe book. Stores the user's saved recipes for this category.
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
     * Instantiate an empty SubRecipeBook with name- name.
     * @param  name - user provided name for the sub-recipe book
     */
    public SubRecipeBook(String name) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = " ";
    }

    /**
     * Instantiate an empty SubRecipeBook with name- name and description- description.
     * @param name - user provided name of the sub-recipe book
     * @param description - user provided description for the sub-recipe book
     */
    public SubRecipeBook(String name, String description) {
        this.recipes = new RecipeCollection();
        this.name = name;
        this.description = description;
    }

    /**
     * Return the name of the SubRecipeBook.
     * @return String representing the name of the sub-recipe book
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the description of the SubRecipeBook.
     * @return String representing the description of the sub-recipe book
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Add a Recipe object to the SubRecipeBook.
     * @param recipe - the Recipe object to be added
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.addRecipe(recipe);
    }

    /**
     * Remove the Recipe with recipeCode from the SubRecipeBook.
     * @param recipeCode - a unique String code identifier for Recipe
     */
    public void removeRecipe(Integer recipeCode) {
        this.recipes.removeRecipe(recipeCode);
    }

    /**
     * Remove a Recipe from the SubRecipeBook.
     * @param recipe - the recipe to delete
     */
    public void removeRecipe(Recipe recipe) {
        removeRecipe(recipe.getRecipeCode());
    }

    /**
     * Return all Recipes in the User's SubRecipeBook.
     * @return - return a list of the recipes
     */
    public Recipe[] getRecipes() {
        return recipes.getRecipes();
    }

    /**
     * Return the codes of all Recipes in the User's SubRecipeBook.
     * @return - return a list of the codes
     */
    public Integer[] getCodes() {
        return recipes.getRecipeCodes();
    }

    /**
     * Retrieve the Recipe with recipeCode.
     * @param recipeCode - a unique Integer code identifier for Recipe
     * @return - return the recipe with recipeCode
     */
    public Recipe getRecipe(Integer recipeCode) {
        return this.recipes.findRecipe(recipeCode);
    }

    /**
     * Retrieve the Recipe with name- name.
     * @param recipeName - the name of the recipe to return
     * @return a recipe object with name- name
     */
    public Recipe getRecipe(String recipeName) {
        return this.recipes.findRecipe(recipeName);
    }

    /**
     * Return true iff the Recipe is contained within the SubRecipeBook.
     * @param recipe - the recipe object to check for
     * @return true iff the recipe is contained the sub-recipe book and false otherwise
     */
    public boolean containsRecipe(Recipe recipe) {
        return this.recipes.containsRecipe(recipe);
    }

    /**
     * Return true iff the Recipe with name - name is contained within the SubRecipeBook.
     * @param name - the name of the recipe that we are looking for
     * @return true iff the recipe is found in the sub-recipe book and false otherwise
     */
    public boolean containsRecipe(String name) {
        return this.recipes.containsRecipe(name);
    }

    /**
     * Return the number of Recipes in the SubRecipeBook.
     * @return the number of recipes in the sub-recipe book.
     */
    public int size() {
        return this.recipes.size();
    }


    /**
     * Adds filter to the SubRecipeBook.
     * @param filter instance of a filter that needs to be added.
     */
    public void addFilter(Filter filter) {
        recipes.addFilter(filter);
    }

    /**
     * Removes filter from the SubRecipeBook.
     * @param filterToRemove instance of a filter that needs to be removed.
     */
    public void removeFilter(Filter filterToRemove) {
        recipes.removeFilter(filterToRemove);
    }

    /**
     * Sets sort to the SubRecipeBook.
     * @param sort instance of a sort that needs to be added.
     */
    public void setSort(Sort sort) {
        recipes.setSort(sort);
    }

    /**
     * Removes sort from the SubRecipeBook.
     */
    public void removeSort() {
        recipes.removeSort();
    }
}