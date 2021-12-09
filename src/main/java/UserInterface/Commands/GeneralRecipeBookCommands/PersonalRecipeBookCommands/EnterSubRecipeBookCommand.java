package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to enter sub-recipe book page.
 */
public class EnterSubRecipeBookCommand extends Command {
    public EnterSubRecipeBookCommand() {
        super("enter sub-recipe book", "Enter the SubRecipeBook of given name");
    }

    /**
     * Enter sub-recipe book page.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Input the name of the SubRecipeBook you would like to enter");
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            UI.getPageManager().enterSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(UI);
        } else {
            UI.displayMessage("The sub recipe book requested does not exist");
        }
    }
}


