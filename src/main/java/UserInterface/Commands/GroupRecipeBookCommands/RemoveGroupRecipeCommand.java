package main.java.UserInterface.Commands.GroupRecipeBookCommands;

import main.java.UseCases.GroupSubRecipeBookManager;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.UserInterface;


public class RemoveGroupRecipeCommand extends Command {
    /**
     * Allows the user to remove a group recipe from the group sub recipe book
     */
    public RemoveGroupRecipeCommand() {
        super("remove group recipe", "Removes a group recipe from the group sub recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupRecipeName = UI.queryUser("Input the name of the group recipe to remove");
        String groupSubRecipeBookName = UI.queryUser("Please confirm the name of GroupSubRecipeBook to remove the group recipe from");

        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(UI.getGroup());
        GroupSubRecipeBookManager groupSubRecipeBookManager = new GroupSubRecipeBookManager(
                groupRecipeBookManager.findSubRecipeBook(groupSubRecipeBookName));
        if (groupSubRecipeBookManager.containsRecipe(groupRecipeName)) {
            groupRecipeBookManager.removeRecipe(groupSubRecipeBookName,groupRecipeName);
            GroupRecipeBookCSVReader.getInstance().updateRecipeBookCSV(UI.getGroup().getGroupName(),
                    groupRecipeBookManager.findSubRecipeBook(groupSubRecipeBookName));
            UI.displayMessage("Group recipe successfully deleted");
        } else {
            UI.displayMessage("Recipe not found in the group recipe book.");
        }
    }
}
