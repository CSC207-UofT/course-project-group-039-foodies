package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.Entities.GroupSubRecipeBook;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.GroupCSVReader;

/**
 * Allows user to list group sub-recipe books.
 */
public class ListGroupSubRecipeBooksCommand extends Command {
    /**
     * Initialize ListGroupSubRecipeBooksCommand.
     */
    public ListGroupSubRecipeBooksCommand() {
        super("show group sub-recipe books", "show all the GroupSubRecipeBooks " +
                "contained in GroupRecipeBook");
    }


    /**
     * List group sub-recipe books.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        UI.displayMessage("Your groups are: \n" +
                GroupCSVReader.getInstance().getJoinedGroups(username));
        String groupName = UI.queryUser("Enter the name of the group you want to view");

        GroupRecipeBookManager groupRecipeBookManager =
                new GroupRecipeBookManager(GroupCSVReader.getInstance().getGroup(groupName, username));
        for (GroupSubRecipeBook groupSubRecipeBook: groupRecipeBookManager.getSubRecipeBooks()) {
            UI.displayMessage(groupSubRecipeBook.getName());
        }
    }
}

