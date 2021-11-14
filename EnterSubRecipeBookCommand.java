package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;
import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;

public class EnterSubRecipeBookCommand extends Command {
    public EnterSubRecipeBookCommand() {
        super("Enter SubRecipeBook", "Enter the SubRecipeBook of given name");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input the name of the SubRecipeBook you would like to enter");
        String subrecipebookname = CLI.getTextInput();
        RecipeBookManager recipebookmanager = new RecipeBookManager(CLI.getUser());
        if (recipebookmanager.containsSubRecipeBook(subrecipebookname)) {
            SubRecipeBook entersubrecipebook = recipebookmanager.findsubrecipebook(subrecipebookname);
        }
        CLI.getPageManager().enterSubRecipeBook();
        Command help = new HelpCommand();
        help.runAction(CLI);
    }
}
// how to enter into a specific recipebook.
