package main.java.CLI.Commands.RecipeBookCommands.ModifyOutputCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

public abstract class ModifyOutputCommand<T extends Enum<T>> extends Command {
    public ModifyOutputCommand(String name, String description) {
        super(name, description);
    }

    protected T chooseOption(CommandLineInterface CLI, Class<T> enumType, String choiceMessage) {
        T option = null;
        boolean choseOption = false;

        while (!choseOption) {
            CLI.displayMessage(choiceMessage);
            try {
                option = Enum.valueOf(enumType, CLI.getTextInput());
                choseOption = true;
            } catch (IllegalArgumentException ignored) {
                CLI.displayMessage("Input not recognized. Try again.");
            }
        }

        return option;
    }

    @Override
    public abstract void runAction(CommandLineInterface CLI);
}
