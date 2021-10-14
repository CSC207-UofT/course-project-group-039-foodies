public class Recipe {
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

    /**public Recipe(int recipeCode) {
        this.recipeCode = recipeCode;
        this.foodName = new String();
        this.foodType = new String();
        this.servings = 0;
        this.ingredients = new ArrayList<String> ();
        this.instructions = new String(); */
    }

    public String toString() {
        String recipeString = this.foodName + "\n" + this.instructions;
        return recipeString;
    }

}
