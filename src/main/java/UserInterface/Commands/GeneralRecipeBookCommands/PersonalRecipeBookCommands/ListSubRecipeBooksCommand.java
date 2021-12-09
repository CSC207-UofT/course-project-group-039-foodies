package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Gateways.RecipeBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show sub recipe books", "show all the SubRecipeBooks contained in RecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        String username = UI.getUser().getUsername();
        UI.displayMessage("The following are your sub-recipe books: \nAllRecipes \n" +
                RecipeBookCSVReader.getInstance().getSubRecipeBook(username));
//
//        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
//        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
//            UI.displayMessage(subrecipebook.getName());
        }
    }

