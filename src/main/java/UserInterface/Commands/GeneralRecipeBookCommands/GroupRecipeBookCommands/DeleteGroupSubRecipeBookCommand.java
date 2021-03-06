package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UseCases.GroupRecipeBookManager;

/**
 * Allows user to delete group sub-recipe book.
 */
public class DeleteGroupSubRecipeBookCommand extends Command{
    /**
     * Initialize DeleteGroupSubRecipeBookCommand.
     */
    public DeleteGroupSubRecipeBookCommand() {
        super("delete group sub recipe book", "deletes the GroupSubRecipeBook with name provided");
    }

    /**
     * Delete group sub-recipe book.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        Group group = GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername());
        String groupSubRecipeBookName = UI.queryUser("Please enter the name of the sub-recipe book to be deleted");
        GroupRecipeBookManager grouprecipebookmanager = new GroupRecipeBookManager(group);

        if (grouprecipebookmanager.containsSubRecipeBook(groupSubRecipeBookName)) {
            grouprecipebookmanager.removeSubRecipeBook(groupSubRecipeBookName);
            GroupRecipeBookCSVReader.getInstance().deleteSubRecipeBook(group.getGroupName(), groupSubRecipeBookName);
            UI.displayMessage("GroupSubRecipeBook successfully deleted");
        } else {
            UI.displayMessage("The GroupSubRecipeBook you want to delete does not exist. ");
        }
    }
}
