public class Recipe {
    /** Creates a Recipe object */

    String foodName;
    Integer recipeCode
    String foodType;
    int servings;
    ArrayList<String> ingredients;
    String instructions;

    public Recipe(int recipeCode, String foodName, String foodType, int servings, ArrayList<String> ingredients, String instructions) {
        this.recipeCode = recipeCode;
        this.foodName = foodName;
        this.foodType = foodType;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String toString() {
        /** Returns a formatted Recipe for the user to read */

        String recipeString = this.foodName + "\n" + this.instructions;
        return recipeString;
    }

    public String getFoodType() { return this.foodType; }

}
