package main.java.UserInterface.Commands.GeneralRecipeBookCommands.RecipeBookCommands;

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
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            UI.getPageManager().enterSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(UI);
        } else {
            UI.displayMessage("The subrecipebook requested does not exist");
        }
    }
}

