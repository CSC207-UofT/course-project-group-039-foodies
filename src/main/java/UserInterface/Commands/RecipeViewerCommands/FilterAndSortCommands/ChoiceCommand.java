package main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands;

import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

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
     * @param UI The User Interface
     * @param enumType The class of the Enum of all choices
     * @param choiceMessage The message displayed when the user is making a choice
     * @return The choice of the user
     */
    protected T chooseOption(UserInterface UI, Class<T> enumType, String choiceMessage) {
        T option = null;
        boolean choseOption = false;

        while (!choseOption) {
            try {
                option = Enum.valueOf(enumType, UI.queryUser(choiceMessage));
                choseOption = true;
            } catch (IllegalArgumentException ignored) {
                UI.displayMessage("Input not recognized. Try again.");
            }
        }

        return option;
    }

    @Override
    public abstract void runAction(UserInterface UI);
}
