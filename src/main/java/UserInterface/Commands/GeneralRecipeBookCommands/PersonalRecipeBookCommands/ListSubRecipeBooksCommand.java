package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Entities.SubRecipeBook;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to list sub-recipe books.
 */
public class ListSubRecipeBooksCommand extends Command {
    public ListSubRecipeBooksCommand() {
        super("show sub recipe books", "show all the SubRecipeBooks contained in RecipeBook");
    }

    /**
     * List sub-recipe books.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        RecipeBookManager recipeBookManager = new RecipeBookManager(UI.getUser());
        for (SubRecipeBook subrecipebook: recipeBookManager.getSubRecipeBooks()) {
            UI.displayMessage(subrecipebook.getName());
        }
    }
}

