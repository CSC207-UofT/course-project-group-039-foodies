package main.java.CLI.Commands.RecipeBookCommands.ModifyOutputCommands;
import main.java.CLI.CommandLineInterface;
import main.java.Modifiers.Filters.AllergyFilter;
import main.java.Modifiers.Filters.Filter;
import main.java.Modifiers.Filters.FoodTypeFilter;
import main.java.Modifiers.Filters.ServingsFilter;



public class FilterRecipeBookCommand extends ModifyOutputCommand<FilterOption> {
    public FilterRecipeBookCommand() {
        super("filter recipe book", "Filters the recipes in the recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        Filter filter = null;

        switch (chooseOption(
                CLI,
                FilterOption.class,
                "Input 'allergy' to filter out an allergen from the recipebook, " +
                        "'foodtype' to filter in a type of food, and " +
                        "'servings' to filter the number of servings."
        )) {
            case allergy:
                CLI.displayMessage("Input the name of the ingredient to filter out");
                String ingredient = CLI.getTextInput();
                filter = new AllergyFilter(ingredient);
                break;
            case foodtype:
                CLI.displayMessage("Input the name of the food type to filter in");
                String foodtype = CLI.getTextInput();
                filter = new FoodTypeFilter(foodtype);
                break;
            case servings:
                CLI.displayMessage("Input the number of servings you need");
                int servings = Integer.parseInt(CLI.getTextInput());
                filter = new ServingsFilter(servings);
                break;
        }

        CLI.getRecipeCollection().addFilter(filter);
    }
}
