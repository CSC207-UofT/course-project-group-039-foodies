package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;


public class EnterGroupSubRecipeBookCommand extends Command {
    public EnterGroupSubRecipeBookCommand() {
        super("enter GroupSubRecipeBook", "Enter the GroupSubRecipeBook of given name");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupSubRecipeBookName = UI.queryUser("Input the name of the GroupSubRecipeBook you would like to enter");
        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(UI.getGroup());
        if (groupRecipeBookManager.containsSubRecipeBook(groupSubRecipeBookName)) {
            UI.getPageManager().enterSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(UI);
        } else {
            UI.displayMessage("The GroupSubRecipeBook requested does not exist");
        }
    }
}
