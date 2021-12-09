package main.java.UserInterface.Commands.GeneralRecipeBookCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

/**
 * Allows user to enter general recipe book page.
 */
public class EnterGeneralRecipeBookCommand extends Command{
    public EnterGeneralRecipeBookCommand() {
        super("enter recipe book",
                "Enters group or personal recipe book");
    }

    /**
     * Enter general recipe book page.
     * @param UI an instance of the user interface.
     */
    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterGeneralRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}

