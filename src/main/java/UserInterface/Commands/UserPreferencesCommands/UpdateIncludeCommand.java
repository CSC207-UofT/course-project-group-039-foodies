package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UseCases.Utilities.UserFacade;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * allows user to update the list of ingredients they want to include in their recommended recipes.
 */
public class UpdateIncludeCommand extends Command {
    public UpdateIncludeCommand() {
        super("update included ingredients", "Remove or add ingredients to include list");
    }

    @Override
    public void runAction(UserInterface UI) {
        String AddOrRem = UI.queryUser(
                "Would you like to remove or add an ingredient to your list of included ingredients?"
        );
        if (AddOrRem.equals("add")) {
            updateInclude(
                    UI,
                    true,
                    "Enter ingredient to include in the recipe selection",
                    "This ingredient is already included"
            );
        } else {
            updateInclude(
                    UI,
                    false,
                    "Enter ingredient to remove from list of included ingredients",
                    "This ingredient is not in your include list"
            );
        }

        //update preference book
        UI.buildPreferences(
                PreferenceBookCSVReader.getInstance().getPreferenceBook(UserFacade.getUsername(UI.getUser()))
        );
    }

    private void updateInclude(UserInterface UI, boolean isOptionAdd, String queryMessage, String failureMessage) {
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        String ingredient = UI.queryUser(queryMessage);

        // If you add when it contains, or remove when it doesn't contain, then the update fails
        if (isOptionAdd == UI.getPreferenceBook().contains("include", ingredient)) {
            UI.displayMessage(failureMessage);
        } else {
            instance.updateInclude(UserFacade.getUsername(UI.getUser()), isOptionAdd, ingredient);
            UI.displayMessage("List of included ingredients successfully updated");
        }
    }
}
