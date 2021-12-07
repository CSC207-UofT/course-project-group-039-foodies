package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.Group;
import main.java.Entities.GroupSubRecipeBook;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;

public class ListGroupSubRecipeBooksCommand extends Command {
    public ListGroupSubRecipeBooksCommand() {
        super("show group subrecipebooks", "show all the GroupSubRecipeBooks " +
                "contained in GroupRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        UI.displayMessage("Your groups are: \n" +
                GroupCSVReader.getInstance().getJoinedGroups(username));
        String groupName = UI.queryUser("Enter the name of the group you want to view");
        Group group = GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername());
        GroupRecipeBookManager groupRecipeBookManager =
                new GroupRecipeBookManager(group);
        for (GroupSubRecipeBook groupSubRecipeBook: groupRecipeBookManager.getSubRecipeBooks()) {
            UI.displayMessage(groupSubRecipeBook.getName());
        }
    }
}