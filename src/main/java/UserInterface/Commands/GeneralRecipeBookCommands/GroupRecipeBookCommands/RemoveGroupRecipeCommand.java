package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
import main.java.UseCases.GroupSubRecipeBookManager;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.UserInterface;


/**
 * Allows user to remove group recipe frome the group sub-recipe book.
 */
public class RemoveGroupRecipeCommand extends Command {
    /**
     * Initialize RemoveGroupRecipeCommand.
     */
    public RemoveGroupRecipeCommand() {
        super("remove group recipe", "Removes a group recipe from the group sub recipe book");
    }

    /**
     * Remove group recipes.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        Group group = GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername());
        String groupRecipeName = UI.queryUser("Input the name of the group recipe to remove");
        String groupSubRecipeBookName = UI.queryUser("Please confirm the name of GroupSubRecipeBook to remove the group recipe from");

        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(group);
        GroupSubRecipeBookManager groupSubRecipeBookManager = new GroupSubRecipeBookManager(
                groupRecipeBookManager.findSubRecipeBook(groupSubRecipeBookName));
        if (groupSubRecipeBookManager.containsRecipe(groupRecipeName)) {
            groupRecipeBookManager.removeRecipe(groupSubRecipeBookName,groupRecipeName);
            GroupRecipeBookCSVReader.getInstance().updateRecipeBookCSV(group.getGroupName(),
                    groupRecipeBookManager.findSubRecipeBook(groupSubRecipeBookName));
            UI.displayMessage("Group recipe successfully deleted");
        } else {
            UI.displayMessage("Recipe not found in the group recipe book.");
        }
    }
}
