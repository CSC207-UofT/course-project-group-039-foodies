package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.User;
import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class AddGroupSubRecipeBookCommand extends Command {

    public AddGroupSubRecipeBookCommand() {
        super("add a subrecipebook",
                "Adds a new sub recipe book to the user's group recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        User user = UI.getUser();
        String username = user.getUsername();
        Group group = GroupCSVReader.getInstance().getGroup(groupName, username);

        if (!GroupCSVReader.getInstance().getJoinedGroups(username).contains(groupName)) {
            UI.displayMessage("The group does not exist. Please try again with different group name.");
        } else {
            String groupSubRecipeBookName = groupName + " : " +
                    UI.queryUser("Enter the name of the new sub recipe book");
            String groupSubRecipeBookDesc = UI.queryUser("Enter a description for the new sub recipe book");

            GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(group);
            groupRecipeBookManager.addSubRecipeBook(groupSubRecipeBookName, groupSubRecipeBookDesc);

            if (!GroupRecipeBookCSVReader.getInstance().isSubRecipeBook(username, groupSubRecipeBookName)) {
                GroupRecipeBookCSVReader.getInstance().addNewSubRecipeBook(group, groupSubRecipeBookName,
                        groupSubRecipeBookDesc);
                UI.displayMessage("New SubRecipeBook with name " + groupSubRecipeBookName +
                        " and description " + groupSubRecipeBookDesc + " created successfully");
            } else {
                UI.displayMessage("A subrecipebook with the name " + groupSubRecipeBookName + " already exists");
            }
        }
    }
}
