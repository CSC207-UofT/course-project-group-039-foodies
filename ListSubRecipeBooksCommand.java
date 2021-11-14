package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;

public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show subrecipebooks", "show all the SubRecipeBooks contained in RecipeBook");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeBookManager recipeBookManager = new RecipeBookManager(CLI.getUser());
        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
            CLI.displayMessage(subrecipebook.getName());
        }
    }
}

