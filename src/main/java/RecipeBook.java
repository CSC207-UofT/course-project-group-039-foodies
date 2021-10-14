import java.util.ArrayList;
import java.util.HashMap;

/** A user's recipe book. Stores the user's saved recipes
 *
 */
public class RecipeBook {
    private final HashMap<String, Recipe> recipebook;

    /**
     * Instantiate an empty Recipe Book
     */
    public RecipeBook() {
        this.recipebook = new HashMap<>();
    }

    /**
     * Add a Recipe recipe with code recipe code to the Recipe Book
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @param recipe - the recipe
     */
    public void addRecipe(String recipecode, Recipe recipe) {
        this.recipebook.put(recipecode, recipe);
    }

    /**
     * Remove the recipe with recipecode from recipebook.
     *
     * @param recipecode - a unique String code identifier for Recipe
     */
    public void removeRecipe(String recipecode) {
        this.recipebook.remove(recipecode);
    }

    /**
     *
     * @param recipecode - a unique String code identifier for Recipe
     * @return - return the recipe with recipecode
     */
    public Recipe getRecipe(String recipecode) {
        return this.recipebook.get(recipecode);
    }

}

