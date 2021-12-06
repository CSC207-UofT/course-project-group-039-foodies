package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.RecipeViewerCommands.GetNewRecipeCommand;
import main.java.UserInterface.UserInterface;

/**
 * Remove sort from the sub-recipe book.
 */
public class RemoveSavedSortCommand extends Command {
    /**
     * Initialize RemoveSavedSortCommand.
     */
    public RemoveSavedSortCommand() {super("remove sort", "Stops the saved recipe book from being" +
            "sorted");}

    /**
     * Remove sort from the sub-recipe book given by the user.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        String subRecipeBook = UI.queryUser("Input the name of Sub-recipe book that you want to remove sort");
        UI.getUser().getRecipeBook().removeSort(subRecipeBook);
        GetNewRecipeCommand.initializeIterator(UI);
    }
}
