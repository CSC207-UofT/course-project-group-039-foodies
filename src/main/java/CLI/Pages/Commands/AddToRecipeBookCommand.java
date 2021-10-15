package main.java.CLI.Pages.Commands;

import main.java.CLI.CommandLineInterface;
import main.java.Utilities.RecipeBookManager;

public class AddToRecipeBookCommand extends Command {

    public AddToRecipeBookCommand() {
        super("add to recipe book", "Adds a viewed recipe to your recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the recipe you want to add");
        String recipeName = CLI.getTextInput();
        RecipeBookManager.addRecipe(CLI.getUser(), recipeName);
    }
}
