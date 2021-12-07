package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;
import main.java.Entities.Group;
import main.java.Entities.Recipe;
import main.java.Entities.User;
import main.java.Gateways.GroupCSVReader;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UseCases.GroupSubRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class ListGroupSubRecipeBookRecipesCommand extends Command{
    public ListGroupSubRecipeBookRecipesCommand() {
        super("show recipes in subrecipebook", "Lists the recipes of the SubRecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        User user = UI.getUser();
        String username = user.getUsername();
        Group group = GroupCSVReader.getInstance().getGroup(groupName, username);

        String subRecipeBookName = UI.queryUser("Please confirm the recipe book you would like to see recipes for");
        GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(group);
        if (groupRecipeBookManager.containsSubRecipeBook(subRecipeBookName)) {
            GroupSubRecipeBookManager subRecipeBookManager =
                    new GroupSubRecipeBookManager(groupRecipeBookManager.findSubRecipeBook(subRecipeBookName));
            for (Recipe recipe : subRecipeBookManager.getRecipes()) {
                UI.displayMessage(recipe.toString());
            }
        } else {
            UI.displayMessage("The subrecipebook that you requested does not exist");
        }
    }
}
