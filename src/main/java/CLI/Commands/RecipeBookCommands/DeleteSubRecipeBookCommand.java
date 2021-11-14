package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.RecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;

public class DeleteSubRecipeBookCommand extends Command {

    public DeleteSubRecipeBookCommand() {
        super("delete subrecipebook", "deletes the subrecipe book with name provided");
    }

    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Please enter the name of the sub-recipe book to be deleted");
        String subrecipebookname = CLI.getTextInput();

        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);

        if (recipebookmanager.containsSubRecipeBook(subrecipebookname)) {
            recipebookmanager.removeSubRecipeBook(subrecipebookname);
            RecipeBookCSVReader.getInstance().deleteSubRecipeBook(CLI.getUser(), subrecipebookname);
            CLI.displayMessage("SubRecipeBook successfully deleted");
        } else {
            CLI.displayMessage("The SubRecipeBook you want to delete does not exist. ");
        }
    }
}
