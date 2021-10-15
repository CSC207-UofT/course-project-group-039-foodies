package main.java.CLI.Commands.RecipeViewerCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.Recipe;
import main.java.Gateways.RecipeGateway;

import java.util.ArrayList;

/**
 * Allows the user to view a new recipe to rate
 */
public class GetNewRecipeCommand extends Command {
    public GetNewRecipeCommand() {
        super("get new recipe", "Gets a new recipe to rate");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {

        /* Creating sample recipes */
        ArrayList<String> SmoothieIng = new ArrayList<String>();
        Object[] SmoothieList = {"Smoothie", "breakfast", 1, SmoothieIng, "1 medium banana (fresh or frozen), 0.5 cup sliced strawberries, blueberries, or chopped mangos,  0.25 cup 2% plain Greek yogurt, 1 tablespoon almond butter, ½ cup baby spinach, ½ cup unsweetened almond milk, Optional: 1-2 basil leaves, 2-3 mint leaves, ½ teaspoon peeled, chopped ginger \n Place in blender and blend until smooth"};

        ArrayList<String> RamenIng = new ArrayList<String>();
        Object[] RamenList = {"Ramen", "lunch", 1, RamenIng, "Sesame oil, Olive oil (or avocado oil), Garlic, Fresh ginger, Chicken or vegetable broth, Rice vinegar, Low sodium soy sauce, Sriracha or hot chili garlic sauce, like Sambal Oelek, Shredded carrots, Shiitake mushrooms (optional)Scallions, Sesame seeds, Soft-boiled egg \n Heat sesame oil and olive oil in a medium-large saucepan over moderate heat (see notes). Add garlic and ginger, and simmer until fragrant, about 2-3 minutes. Do not brown the garlic, or else you'll get a bitter flavor. Add the carrots and mushrooms if you're using them, and simmer until they soften, about a minute, stirring frequently. Add the broth, Sriracha sauce, rice vinegar, and soy sauce. Stir, and bring to a simmer; let it go for about five minutes. Taste, and adjust heat and taste to your liking by adding more Sriracha and soy sauce if needed. While the broth simmers, cook the Ramen noodles in a separate pot as per the package's instructions. (You could cook the noodles in the broth directly, but that makes for a messy transfer to a bowl. It's much easier to transfer drained cooked noodles to a bowl and spoon the broth over top.) Once the noodles are tender, drain and rinse under cool water, place into a soup bowl, and set aside. When the soup is ready, spoon the broth over the noodles. Allow to cool. At this point, make your soft-boiled egg if you're garnishing with one, and add the rest of your toppings to serve. Soft-Boiled Egg - Bring water to a boil in a small saucepan. Add the egg(s), and let them boil for five minutes. In the meantime, prepare an ice bath in a bowl. Once five minutes are up, remove the egg(s) and dunk them into the ice bath for about a minute to cool them off enough to handle. Then, lightly crack and roll them on a flat surface, peel, slice in half, and place on top of your Ramen."};

        /* ArrayList of Recipes */
        Object[][] PrototypeRecipes = {SmoothieList, RamenList};

        RecipeGateway recipeGateway = new RecipeGateway(
                PrototypeRecipes,
                CLI.getRecipeDatabase()
        );

        recipeGateway.BuildRecipe();

        CLI.displayMessage(CLI.getRecipeDatabase().findRecipe("Smoothie").toString());
    }
}
