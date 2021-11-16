package main.java.UserInterface.Commands.RecipeBookCommands;

import main.java.Entities.RecipeBook;
import main.java.Entities.SubRecipeBook;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show subrecipebooks", "show all the SubRecipeBooks contained in RecipeBook");
    }

    @Override
    public void runAction(UserInterface UI) {
        RecipeBook recipebook = UI.getUser().getRecipeBook();
//        RecipeBook recipebook = RecipeBookCSVReader.getInstance().getUserRecipeBook(UI.getUser());
        RecipeBookManager recipeBookManager = new RecipeBookManager(recipebook);
        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
            UI.displayMessage(subrecipebook.getName());
        }
    }
}

