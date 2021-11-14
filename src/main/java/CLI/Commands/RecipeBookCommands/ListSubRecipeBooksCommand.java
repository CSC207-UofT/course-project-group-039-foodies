package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.Entities.RecipeBook;

public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show subrecipebooks", "show all the SubRecipeBooks contained in RecipeBook");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
            CLI.displayMessage(subrecipebook.getName());
        }
    }
}

