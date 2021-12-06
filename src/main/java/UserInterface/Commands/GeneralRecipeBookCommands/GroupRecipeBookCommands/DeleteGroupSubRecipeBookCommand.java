package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UseCases.GroupRecipeBookManager;


public class DeleteGroupSubRecipeBookCommand extends Command{
    public DeleteGroupSubRecipeBookCommand() {
        super("delete GroupSubRecipeBook", "deletes the GroupSubRecipeBook with name provided");
    }

    public void runAction(UserInterface UI) {
        String groupSubRecipeBookName = UI.queryUser("Please enter the name of the sub-recipe book to be deleted");
        GroupRecipeBookManager grouprecipebookmanager = new GroupRecipeBookManager(UI.getGroup());

        if (grouprecipebookmanager.containsSubRecipeBook(groupSubRecipeBookName)) {
            grouprecipebookmanager.removeSubRecipeBook(groupSubRecipeBookName);
            GroupRecipeBookCSVReader.getInstance().deleteSubRecipeBook(UI.getGroup().getGroupName(), groupSubRecipeBookName);
            UI.displayMessage("GroupSubRecipeBook successfully deleted");
        } else {
            UI.displayMessage("The GroupSubRecipeBook you want to delete does not exist. ");
        }
    }
}