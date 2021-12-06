package main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.Commands.HelpCommand;
import main.java.UserInterface.UserInterface;

public class EnterRecipeBookCommand extends Command {
    public EnterRecipeBookCommand() {
        super("enter personal recipe book",
                "Enters the personal recipe book");
    }

    @Override
    public void runAction(UserInterface UI) {
        UI.getPageManager().enterRecipeBook();
        Command help = new HelpCommand();
        help.runAction(UI);
    }
}
