package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.UseCases.RecipeBookManager;

public class DeleteSubRecipeBookCommand extends Command {

    public DeleteSubRecipeBookCommand() {
        super("Delete a SubRecipe Book", "deletes the subrecipe book with name provided");
    }

    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Please enter the name of the sub-recipe book to be deleted");
        String subrecipebookname = CLI.getTextInput();

        RecipeBookManager recipebookmanager = new RecipeBookManager(CLI.getUser());

        if (recipebookmanager.containsSubRecipeBook(subrecipebookname)) {
            recipebookmanager.removeSubRecipeBook(subrecipebookname);
            CLI.displayMessage("SubRecipeBook successfully deleted");
        } else {
            CLI.displayMessage("The SubRecipeBook you want to delete does not exist. ");
        }
    }
}
