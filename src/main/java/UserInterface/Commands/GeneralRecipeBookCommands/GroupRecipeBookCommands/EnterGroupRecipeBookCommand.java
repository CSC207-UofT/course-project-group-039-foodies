package main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to enter group recipe book.
 */
public class EnterGroupRecipeBookCommand extends Command {
    /**
     * Initialize EnterGroupRecipeBookCommand.
     */
    public EnterGroupRecipeBookCommand() {
        super("enter group recipe book",
                "Enters the group recipe book");
    }

    /**
     * Enter group recipe book.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterGroupRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
