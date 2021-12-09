package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;

import java.util.Objects;

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
        PreferenceBookCSVReader instance = PreferenceBookCSVReader.getInstance();
        if (Objects.equals(AddOrRem, "add")) {
            String ingredient = UI.queryUser("Enter ingredient to include in the recipe selection");
            if (UI.getPreferenceBook().contains("include", ingredient)) {
                UI.displayMessage("This ingredient is already included");
            } else {
                instance.updateInclude(UI.getUser().getUsername(), AddOrRem, ingredient);
                UI.displayMessage("List of included ingredients successfully updated");
            }
        } else {
            String ingredient = UI.queryUser("Enter ingredient to remove from list of included ingredients");
            if (!UI.getPreferenceBook().contains("include", ingredient)) {
                UI.displayMessage("This ingredient is not in your include list");
            } else {
                instance.updateInclude(UI.getUser().getUsername(), AddOrRem, ingredient);
                UI.displayMessage("List of included ingredients successfully updated");
            }
        }
        UI.buildPreferences(PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername()));
        //update preference book

    }
}