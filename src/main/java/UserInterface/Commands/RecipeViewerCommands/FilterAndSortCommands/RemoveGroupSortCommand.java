package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UseCases.Utilities.RecipeCollectionFacade;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Remove filter from RecipeBook.
 */
public class RemoveGroupSortCommand extends Command {
    /**
     * Initialize RemoveSortCommand.
     */
    public RemoveGroupSortCommand() {
        super("remove sort", "Stops the recipe book from being sorted");
    }

    /**
     * Remove sort given by the user from RecipeBook.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        RecipeCollectionFacade.removeSort(UI.getRecipeCollection());
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
