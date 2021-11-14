package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

public class EnterSubRecipeBookCommand extends Command {
    public EnterSubRecipeBookCommand() {
        super("enter subrecipebook", "Enter the SubRecipeBook of given name");
    }

    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Input the name of the SubRecipeBook you would like to enter");
        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
        RecipeBookManager recipebookmanager = new RecipeBookManager(recipebook);
        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            UI.getPageManager().enterSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(UI);
        } else {
            UI.displayMessage("The subrecipebook requested does not exist");
        }
    }
}
// how to enter into a specific recipebook.
