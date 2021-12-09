package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;
import main.java.Entities.Group;
import main.java.Entities.GroupRecipeBook;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.Entities.Recipe;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to list all recipes in the group recipe book
 */
public class ListGroupRecipeBooksCommand extends Command{
    /**
     * Initialize ListGroupRecipeBooksCommand.
     */
    public ListGroupRecipeBooksCommand() {
        super("list all recipes",
                "Lists all recipes in the group recipe book");
    }

    /**
     * List all group recipe books.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        Group group = GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername());
        GroupRecipeBook grouprecipebook = GroupRecipeBookCSVReader.getInstance().getGroupRecipeBook(group);
        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(grouprecipebook);

        if (groupRecipeBookManager.getRecipes().length == 0) {
            UI.displayMessage("Your recipe book is empty.");
        } else {
            for (Recipe recipe : groupRecipeBookManager.getRecipes()) {
                UI.displayMessage(recipe.toString());
            }
        }
    }
}

