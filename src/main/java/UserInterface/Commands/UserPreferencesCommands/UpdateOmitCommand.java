package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UseCases.Utilities.UserFacade;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

/**
 * allows user to update the list of ingredients they want to omit from their recommended recipes.
 */
public class UpdateOmitCommand extends Command {
    public UpdateOmitCommand() {
        super("update omitted ingredients", "Remove or add ingredients to omit list");
    }
    @Override
    public void runAction(UserInterface UI) {
        String AddOrRem = UI.queryUser(
                "Would you like to remove or add an ingredient to your list of omitted ingredients?"
        );
        if (AddOrRem.equals("add")) {
            updateOmits(
                    UI,
                    true,
                    "Enter ingredient to omit from recipe selection",
                    "This ingredient is already omitted"
            );
        } else {
            updateOmits(
                    UI,
                    false,
                    "Enter ingredient to remove from list of omitted ingredients",
                    "This ingredient is not in your omit list"
            );
        }

        //update preference book
        UI.buildPreferences(
                PreferenceBookCSVReader.getInstance().getPreferenceBook(UserFacade.getUsername(UI.getUser()))
        );
    }

    private void updateOmits(UserInterface UI, boolean isOptionAdd, String queryMessage, String failureMessage) {
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        String ingredient = UI.queryUser(queryMessage);

        // If you add when it contains, or remove when it doesn't contain, then the update fails
        if (isOptionAdd == UI.getPreferenceBook().contains("omit", ingredient)) {
            UI.displayMessage(failureMessage);
        } else {
            instance.updateOmit(UserFacade.getUsername(UI.getUser()), isOptionAdd, ingredient);
            UI.displayMessage("List of omitted ingredients successfully updated");
        }
    }
}
