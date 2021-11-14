package main.java.CLI.Commands.RecipeBookCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;
import main.java.CLI.Commands.HelpCommand;
import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;

public class EnterSubRecipeBookCommand extends Command {
    public EnterSubRecipeBookCommand() {
        super("enter subrecipebook", "Enter the SubRecipeBook of given name");
    }

    @Override
    public void runAction(CommandLineInterface CLI) {
        CLI.displayMessage("Input the name of the SubRecipeBook you would like to enter");
        String subrecipebookname = CLI.getTextInput();
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(CLI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        if (recipebookmanager.containsSubRecipeBook(subrecipebookname)) {
            CLI.getPageManager().enterSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(CLI);
        } else {
            CLI.displayMessage("The subrecipebook requested does not exist");
        }
    }
}
// how to enter into a specific recipebook.
