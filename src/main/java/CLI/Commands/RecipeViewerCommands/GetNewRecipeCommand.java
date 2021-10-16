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
        ArrayList<String> SmoothieIng = new ArrayList<>();
        Object[] SmoothieList = {"Smoothie\n", "breakfast", 1, SmoothieIng, "1 medium banana (fresh or frozen)\n0.5 cup sliced strawberries, blueberries, or chopped mangos\n0.25 cup 2% plain Greek yogurt\n1 tablespoon almond butter\n½ cup baby spinach\n½ cup unsweetened almond milk\nOptional: 1-2 basil leaves\n2-3 mint leaves\n½ teaspoon peeled\nchopped ginger \n\nPlace in blender and blend until smooth"};

        ArrayList<String> RamenIng = new ArrayList<>();
        Object[] RamenList = {"Ramen\n", "lunch", 1, RamenIng, "Sesame oil\nOlive oil (or avocado oil)\nGarlic\nFresh ginger\nChicken or vegetable broth\nRice vinegar\nLow sodium soy sauce\nSriracha or hot chili garlic sauce, like Sambal Oelek\nShredded carrots\nShiitake mushrooms (optional)\nScallions\nSesame seeds\nSoft-boiled egg \n\nHeat sesame oil and olive oil in a medium-large saucepan over moderate heat (see notes). Add garlic and ginger, and simmer until fragrant, about 2-3 minutes. Do not brown the garlic, or else you'll get a bitter flavor. Add the carrots and mushrooms if you're using them, and simmer until they soften, about a minute, stirring frequently. Add the broth, Sriracha sauce, rice vinegar, and soy sauce. Stir, and bring to a simmer; let it go for about five minutes. Taste, and adjust heat and taste to your liking by adding more Sriracha and soy sauce if needed. While the broth simmers, cook the Ramen noodles in a separate pot as per the package's instructions. (You could cook the noodles in the broth directly, but that makes for a messy transfer to a bowl. It's much easier to transfer drained cooked noodles to a bowl and spoon the broth over top.) Once the noodles are tender, drain and rinse under cool water, place into a soup bowl, and set aside. When the soup is ready, spoon the broth over the noodles. Allow to cool. At this point, make your soft-boiled egg if you're garnishing with one, and add the rest of your toppings to serve. Soft-Boiled Egg - Bring water to a boil in a small saucepan. Add the egg(s), and let them boil for five minutes. In the meantime, prepare an ice bath in a bowl. Once five minutes are up, remove the egg(s) and dunk them into the ice bath for about a minute to cool them off enough to handle. Then, lightly crack and roll them on a flat surface, peel, slice in half, and place on top of your Ramen."};

        ArrayList<String> CapreseMacNCheeseIng = new ArrayList<>();
        Object[] CapreseMacNCheeseList = {"Caprese Mac N Cheese\n", "dinner", 1, CapreseMacNCheeseIng, "milk\ncheese\nspinach\nsalt\nbutter\nflour\nmacaroni\npepper\npaprika\ntomato\nbasil \n\nMake a quick sauce with flour, butter, milk, and cheese — then throw in cooked pasta. Fold in some spinach, top with some more cheese, and bake until bubbling. Dress it up: Before baking, top with sliced tomatoes and fresh mozzarella — and as soon as it comes out of the oven, garnish with torn basil."};

        ArrayList<String> AvocadoChipsIng = new ArrayList<>();
        Object[] AvocadoChipsList = {"Avocado Chips\n", "snack", 1, AvocadoChipsIng, "1 large ripe avocado\n¼c freshly grated Parmesan\n1 tsp lemon juice\n½ tsp garlic powder\n½tsp italian seasoning\nkosher salt\nfreshly ground black pepper \n\nPreheat oven to 325° and line two baking sheets with parchment paper. In a medium bowl, mash avocado with a fork until smooth. Stir in Parmesan, lemon juice, garlic powder, and Italian seasoning. Season with salt and pepper. Place heaping teaspoon-size scoops of mixture on baking sheet, leaving about 3” apart between each scoop. Flatten each scoop to 3' wide across with the back of a spoon or measuring cup. Bake until crisp and golden, about 30 minutes, then let cool completely. Serve at room temperature."};

        ArrayList<String> RicePuddingIng = new ArrayList<>();
        Object[] RicePuddingList = {"Baked Rice Pudding\n", "dessert", 1, RicePuddingIng, "Butter, softened, to grease\n100g arborio or carnaroli rice)\n720ml pure (thin) cream\n1 cup (250ml) milk,\n50g caster sugar\n1 vanilla bean, scraped\n1/4 whole nutmeg, finely grated\n250g raspberries\n1 tsp pure icing sugar\nsifted \n\nPreheat the oven to 140°C. Grease a 6-cup (1.5L) baking dish with butter. 2.Place the rice in a sieve and wash well under cold running water. Drain. 3.Place the cream, milk, sugar and vanilla pod and seeds in a small heavy-based saucepan over low heat. Stir until well combined and cook until hot. Discard the vanilla pod. 4.Scatter the rice over prepared baking dish. Pour in the hot cream mixture and stir to combine. Place dish on a baking tray and bake, stirring every 30 minutes, for 1 hour 40 minutes or until rice is tender. Remove from oven and scatter with nutmeg. Increase oven to 190°C, return rice and bake, without stirring, for a further 15 minutes or until golden. Remove from oven and stand for 20 minutes. 5. Meanwhile, gently toss raspberries and icing sugar in a bowl. Stand for 20 minutes. Scatter warm pudding with raspberries to serve."};

        ArrayList<String> PancakesIng = new ArrayList<>();
        Object[] PancakesList = {"Pancakes\n", "breakfast", 2, PancakesIng, """
flour - 2 cups
baking powder - 3 tbsp
salt - 0.5 tsp
sugar - 4 tbsp
milk - 2 cups
egg - 1
vanilla extract - 1 tsp
oil - 1 tbsp
butter - for cooking
maple syrup - to taste

Mix dry ingredients in a bowl. Add milk, vanilla extract, egg yolk, and oil and mix to incorporate. Whisk egg white in a seperate bowl until soft peaks are formed, add to pancake batter and mix. Place a frying pan with a bit of butter on medium heat and ladle the pancake mixture onto the pan forming medium sized disks. Cook the pancakes for 2 minutes on each side. Serve with maple syrup."""};

        /* ArrayList of Recipes */
        Object[][] PrototypeRecipes = {SmoothieList, RamenList, CapreseMacNCheeseList, AvocadoChipsList, PancakesList, RicePuddingList};

        RecipeGateway recipeGateway = new RecipeGateway(
                PrototypeRecipes,
                CLI.getRecipeDatabase()
        );

        recipeGateway.BuildRecipe();

        CLI.displayMessage(CLI.getRecipeDatabase().getNextRecipe().toString());
    }
}
