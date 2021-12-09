package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Remove sort from the AllRecipes book.
 */
public class RemoveAllSavedRecipesSortCommand extends Command {
    /**
     * Initialize RemoveSavedSortCommand.
     */
    public RemoveAllSavedRecipesSortCommand() {super("remove sort", "Stops the saved recipe book from being" +
            "sorted");}

    /**
     * Remove sort from AllRecipesBook.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        UI.getUser().getRecipeBook().removeSort("AllRecipes");
        GetNewRecipeCommand.initializeIterator(UI);
    }
}