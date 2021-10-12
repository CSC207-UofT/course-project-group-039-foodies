public class Recipe {
    String foodName;
    String foodType;
    int servings;
    Arraylist ingredients;
    String instructions;
    int ratingTotal;
    Arraylist ratingList;

    public Recipe(String foodName, String foodType, int servings, Arraylist ingredients, String instructions) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String toString() {
        String recipeString = this.foodName + "\n" + this.instructions;
        return recipeString;
    }

}
