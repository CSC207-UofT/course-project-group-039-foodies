package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to delete sub-recipe book.
 */
public class DeleteSubRecipeBookCommand extends Command {
    /**
     * Initialize DeleteSubRecipeBookCommand.
     */
    public DeleteSubRecipeBookCommand() {
        super("delete sub recipe book", "deletes the sub-recipe book with name provided");
    }

    /**
     * Delete sub-recipe book.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Please enter the name of the sub-recipe book to be deleted");
        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());

        if (recipebookmanager.containsSubRecipeBook(subRecipeBookName)) {
            recipebookmanager.removeSubRecipeBook(subRecipeBookName);
            RecipeBookCSVReader.getInstance().deleteSubRecipeBook(UI.getUser(), subRecipeBookName);
            UI.displayMessage("SubRecipeBook successfully deleted");
        } else {
            UI.displayMessage("The SubRecipeBook you want to delete does not exist. ");
        }
    }
}
