public class Recipe {
    String foodName;
    String foodType;
    int servings;
    Arraylist ingredients;
    String instructions;
    int rating;

    public Recipe(String foodName, String foodType, int servings, Arraylist ingredients, String instructions) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.rating = 0
    }

    public String toString() {
        String recipeString = this.foodName + "\n" + this.instructions;
        return recipeString;
    }

    public void addRating(int newRating) {
        this.rating = (this.rating + newRating) / 2;
    }
}
