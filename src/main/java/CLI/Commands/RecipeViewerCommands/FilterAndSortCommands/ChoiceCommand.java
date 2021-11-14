package main.java.CLI.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.CLI.CommandLineInterface;
import main.java.CLI.Commands.Command;

/**
 * An abstract class that represents a command where the user must make a choice from an enum
 * @param <T> The Enum of all options available
 */
public abstract class ChoiceCommand<T extends Enum<T>> extends Command {
    public ChoiceCommand(String name, String description) {
        super(name, description);
    }

    /**
     * Display a message repeatedly until the user inputs an enum that is recognised.
     * The choice of the user is returned.
     * @param CLI The User Interface
     * @param enumType The class of the Enum of all choices
     * @param choiceMessage The message displayed when the user is making a choice
     * @return The choice of the user
     */
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
