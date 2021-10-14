import java.util.ArrayList;
import java.util.HashMap;

/** A user's recipe book. Stores the user's saved recipes
 *
 */
public class RecipeBook {
    private HashMap<String, Recipe> recipebook;


    public RecipeBook() {
        this.recipebook = new HashMap<>();
    }

    public void addRecipe(String recipecode, Recipe recipe) {
        this.recipebook.put(recipecode, recipe);
    }

    public void removeRecipe(String recipecode) {
        this.recipebook.remove(recipecode);
    }

    public Recipe getRecipe(String recipecode) {
        return this.recipebook.get(recipecode);
    }

}

