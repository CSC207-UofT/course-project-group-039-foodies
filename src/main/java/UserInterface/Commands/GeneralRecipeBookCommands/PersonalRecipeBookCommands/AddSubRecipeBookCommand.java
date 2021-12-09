package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.Entities.User;
import main.java.Gateways.RecipeBookCSVReader;
import main.java.UseCases.RecipeBookManager;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to add sub-recipe book.
 */
public class AddSubRecipeBookCommand extends Command {
    /**
     * Initialize AddSubRecipeBookCommand.
     */
    public AddSubRecipeBookCommand() {
        super("add a sub recipe book", "Adds a new sub recipe book to the user's recipe book");
    }

    /**
     * Add sub-recipe book.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBookName = UI.queryUser("Enter the name of the new sub recipe book");
        String subRecipeBookDesc = UI.queryUser("Enter a description for the new sub recipe book");

        RecipeBookManager recipebookmanager = new RecipeBookManager(UI.getUser());
        recipebookmanager.addSubRecipeBook(subRecipeBookName, subRecipeBookDesc);

        User user = UI.getUser();
        String username = user.getUsername();
        if (!RecipeBookCSVReader.getInstance().isSubRecipeBook(username, subRecipeBookName)) {
            RecipeBookCSVReader.getInstance().addNewSubRecipeBook(user, subRecipeBookName, subRecipeBookDesc);
            UI.displayMessage("New SubRecipeBook with name " + subRecipeBookName + " and description " + subRecipeBookDesc
                    + " created successfully");
        } else {
            UI.displayMessage("A SubRecipeBook with the name " + subRecipeBookName + " already exists");
        }
    }
}
