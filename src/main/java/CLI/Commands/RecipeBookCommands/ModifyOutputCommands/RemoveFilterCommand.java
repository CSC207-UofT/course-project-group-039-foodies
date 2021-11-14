package main.java.CLI.Commands.RecipeBookCommands.ModifyOutputCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Modifiers.Filters.AllergyFilter;
import main.java.Modifiers.Filters.Filter;
import main.java.Modifiers.Filters.FoodTypeFilter;
import main.java.Modifiers.Filters.ServingsFilter;

public class RemoveFilterCommand extends ModifyOutputCommand<FilterOption> {
    public RemoveFilterCommand() {
        super("remove filter", "Removes a filter that has been added");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        Filter filter = null;

        switch (chooseOption(
                CLI,
                FilterOption.class,
                "Input 'allergy' to remove a filter that filters out an allergen from the recipebook, " +
                        "'foodtype' to remove a filter that filters in a type of food, and " +
                        "'servings' to remove a filter that filters the number of servings."
        )) {
            case allergy:
                CLI.displayMessage("Input the name of the ingredient that the filter to remove filters out");
                String ingredient = CLI.getTextInput();
                filter = new AllergyFilter(ingredient);
                break;
            case foodtype:
                CLI.displayMessage("Input the name of the food type that the filter to remove filters in");
                String foodtype = CLI.getTextInput();
                filter = new FoodTypeFilter(foodtype);
                break;
            case servings:
                CLI.displayMessage("Input the number of servings that the filter to remove filters in");
                int servings = Integer.parseInt(CLI.getTextInput());
                filter = new ServingsFilter(servings);
                break;
        }

        CLI.getRecipeCollection().removeFilter(filter);

        CLI.getRecipeCollection().addFilter(filter);
    }
}