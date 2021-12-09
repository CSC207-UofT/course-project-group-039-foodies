package main.java.UserInterface.Commands.GroupRecipeBookCommands;

import main.java.Entities.Recipe;
import main.java.Entities.Group;
import main.java.Entities.GroupSubRecipeBook;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.GroupRecipeBookCSVReader;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;


/**
 * Allows user to add to group recipe book.
 */
public class AddToGroupRecipeBookCommand extends Command {
    public AddToGroupRecipeBookCommand() {
        super("add to group subrecipebook", "Adds a viewed recipe to your group recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        String recipeName = UI.queryUser("Enter the name of the recipe you want to add");

        Recipe recipe = RecipeCollectionFacade.findRecipe(UI.getRecipeCollection(), recipeName);
        if (recipe == null) {
            UI.displayMessage("This recipe does not exist");
        } else {
            String groupName = UI.queryUser("Enter the name of the group you would like to add recipe to");
            String username = UI.getUser().getUsername();
            Group group = GroupCSVReader.getInstance().getGroup(groupName, username);
            GroupRecipeBookManager groupRecipeBookManager = new GroupRecipeBookManager(group);

            String subGroupRecipeBookName = groupName + UI.queryUser("Input the name of the subrecipe book " +
                    "you would like to add recipe to");
            if (groupRecipeBookManager.containsSubRecipeBook(subGroupRecipeBookName)) {
                GroupSubRecipeBook groupSubRecipeBook = groupRecipeBookManager.findSubRecipeBook(subGroupRecipeBookName);
                groupRecipeBookManager.addRecipe(subGroupRecipeBookName, recipe);
                GroupRecipeBookCSVReader.getInstance().updateRecipeBookCSV(group.getGroupName(), groupSubRecipeBook);
                UI.displayMessage("Recipe added successfully");
            }else {
                UI.displayMessage("The subrecipebook you requested does not exist");
            }
        }
    }
}
