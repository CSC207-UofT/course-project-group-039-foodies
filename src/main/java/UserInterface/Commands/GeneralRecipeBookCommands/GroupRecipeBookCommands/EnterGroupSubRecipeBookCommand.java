package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
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
        String groupName = UI.queryUser("Enter the name of the group");
        Group group = GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername());
        String groupSubRecipeBookName = UI.queryUser("Input the name of the GroupSubRecipeBook you would like to enter");
        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(group);
        if (groupRecipeBookManager.containsSubRecipeBook(groupSubRecipeBookName)) {
            UI.getPageManager().enterGroupSubRecipeBook();
            Command help = new HelpCommand();
            help.runAction(UI);
        } else {
            UI.displayMessage("The GroupSubRecipeBook requested does not exist");
        }
    }
}
