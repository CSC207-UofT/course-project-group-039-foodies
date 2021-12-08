package main.java.UserInterface.Commands.UserPreferencesCommands;

import main.java.Entities.PreferenceBook;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.UserInterface;
import main.java.Gateways.PreferenceBookCSVReader;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPreferencesCommand extends Command {
    public ViewPreferencesCommand() {super("view current preferences", "Displays your current " +
            "preferences");}

    @Override
    public void runAction(UserInterface UI) {
        PreferenceBook preferences = PreferenceBookCSVReader.getInstance().getPreferenceBook(UI.getUser().getUsername());
        String include = prefsToString(preferences.getInclude());
        String omit = prefsToString(preferences.getOmit());
        UI.displayMessage(
                "Ingredients to include: " + include + "\n"
                + "Ingredients to omit: " + omit + "\n"
                + "Diet: " + preferences.getDiet()
        );
    }

    /**
     * format an ArrayList of preferences to be displayed for the user.
     * @param prefs ArrayList of preferences
     * @return well formatted String
     */
    public String prefsToString(ArrayList<String> prefs) {
        if (prefs.size() == 0){
            return "";
        } else {
            String prefString = "";
            for (String elem : prefs) {
                if (!Objects.equals(elem, "")) {
                    prefString = prefString + elem + ", ";
                }
            }
            return prefString.substring(0, prefString.length()-2);
        }
    }
}
