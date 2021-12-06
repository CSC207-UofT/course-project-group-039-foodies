package main.java.UserInterface.Commands.GeneralRecipeBookCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;


public class EnterGeneralRecipeBookCommand extends Command{
    public EnterGeneralRecipeBookCommand() {
        super("enter recipe book",
                "Enters group or personal recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterGeneralRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}

