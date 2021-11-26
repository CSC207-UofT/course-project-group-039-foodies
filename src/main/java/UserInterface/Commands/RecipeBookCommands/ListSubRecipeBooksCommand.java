package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UseCases.SubRecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show subrecipebooks", "show all the SubRecipeBooks contained in RecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
            SubRecipeBookManager subRecipeBookManager = new SubRecipeBookManager(subrecipebook);
            UI.displayMessage(subRecipeBookManager.getName());
        }
    }
}

