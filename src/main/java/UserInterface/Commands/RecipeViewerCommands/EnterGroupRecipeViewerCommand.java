package main.java.UserInterface.Commands.RecipeViewerCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to enter group recipe viewer page.
 */
public class EnterGroupRecipeViewerCommand extends Command {
    public EnterGroupRecipeViewerCommand() {
        super("enter group recipe viewer", "Enters the recipe viewer");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterGroupRecipeViewer();


        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
