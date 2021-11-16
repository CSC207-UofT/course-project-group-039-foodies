package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

public class RemoveSortCommand extends Command {

    public RemoveSortCommand() {
        super("remove sort", "Stops the recipe book from being sorted");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getRecipeCollection().removeSort();
    }
}
