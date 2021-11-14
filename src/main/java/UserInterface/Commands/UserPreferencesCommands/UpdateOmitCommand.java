package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

import java.util.Objects;
// possible usecase import

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
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        if (Objects.equals(AddOrRem, "add")) {
            String ingredient = UI.queryUser("Enter ingredient to omit from recipe selection");
            if (UI.getPreferenceBook().contains("omit", ingredient)) {
                UI.displayMessage("This ingredient is already omitted");
            } else {
                 instance.updateOmit(UI.getUser().getUsername(), AddOrRem, ingredient);
                 UI.displayMessage("List of omitted ingredients successfully updated");
            }
        } else {
            String ingredient = UI.queryUser("Enter ingredient to remove from list of omitted ingredients");
            if (!UI.getPreferenceBook().contains("omit", ingredient)) {
                UI.displayMessage("This ingredient is not in your omit list");
            } else {
                instance.updateOmit(UI.getUser().getUsername(), AddOrRem, ingredient);
                UI.displayMessage("List of omitted ingredients successfully updated");
            }
        }
        UI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername()));
        //update preference book
    }

}

