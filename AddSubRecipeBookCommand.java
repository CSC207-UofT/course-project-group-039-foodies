package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;

public class AddSubRecipeBookCommand extends Command {

    public AddSubRecipeBookCommand() {
        super("Add a SubRecipeBook", "Adds a new sub recipe book to the user's recipe book");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Enter the name of the new sub recipe book");
        String subrecipebookname = CLI.getTextInput();

        CLI.displayMessage("Enter a description for the new sub recipe book");
        String subrecipebookdesc = CLI.getTextInput();

        RecipeBookManager recipebookmanager = new RecipeBookManager(CLI.getUser());
        recipebookmanager.addSubRecipeBook(subrecipebookname, subrecipebookdesc);
        CLI.displayMessage("New SubRecipeBook with name " + subrecipebookname + " and description " + subrecipebookdesc
        + " created successfully");
    }
}
