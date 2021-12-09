package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Entities.Recipe;
import main.java.Gateways.GroupCSVReader;
import main.java.Gateways.PreferenceBookCSVReader;
import main.java.Gateways.RecipeCSVReader;
import main.java.UseCases.GroupRecipeBookManager;
import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows the user to rate a group recipe
 */
public class RateGroupRecipeCommand extends Command{
    public RateGroupRecipeCommand() {
        super("rate group recipe", "Rates a group recipe");
    }

    @Override
    public void runAction(UserInterface UI) {
        String groupName = UI.queryUser("Enter the name of the group");
        String groupRecipeName = UI.queryUser("Enter the name of the group recipe to rate");
        GroupRecipeBookManager grouprecipeBookManager = new GroupRecipeBookManager(GroupCSVReader.getTestInstance().getGroup(groupName, UI.getUser().getUsername()));
        UI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername()));

        if (grouprecipeBookManager.containsRecipe(groupRecipeName) && !(UI.getPreferenceBook().contains("rating",
                groupRecipeName))) {
            getRating(UI, groupRecipeName);
        } else if (UI.getPreferenceBook().contains("rating",
                groupRecipeName)) {
            UI.displayMessage("You have already rated this recipe");
        } else {
            UI.displayMessage("Group recipe book does not contain " + groupRecipeName);
        }
    }

    static void getRating(UserInterface UI, String groupRecipeName) {
        double rating = Double.parseDouble(UI.queryUser("Enter rating from 1-5"));
        Recipe recipe = RecipeCollectionFacade.findRecipe(UI.getRecipeCollection(), groupRecipeName); //getting recipe from RecipeCollection
        recipe.addRating(rating); //recipe object is updated
        RecipeCSVReader.getInstance().addRating(groupRecipeName, recipe.rating, recipe.ratingCount); //csv is updated
        PreferenceBookCSVReader.getInstance().updateRatings(UI.getUser().getUsername(), "add",
                groupRecipeName, rating);
        UI.displayMessage("Recipe successfully rated");
    }
}

