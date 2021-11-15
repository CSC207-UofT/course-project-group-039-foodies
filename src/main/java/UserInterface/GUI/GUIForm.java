package main.java.UserInterface.GUI;
import main.java.UserInterface.Commands.Command;
import main.java.UserInterface.GUI.GUIPages.*;
import main.java.UserInterface.GUI.GUIPages.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIForm {
    public static Start start = new Start();
    public static Login login = new Login();
    public static Signup signup = new Signup();
    public static Menu menu = new Menu();
    public static Preferences preferences = new Preferences();
    public static NewRecipes newRecipes = new NewRecipes();
    public static RecipeBook showRecipes = new RecipeBook();
    public static Groups groups = new Groups();
    public static ViewPreferences viewPreferences = new ViewPreferences();
    public static EditPreferences editPreferences = new EditPreferences();
    public static ViewRecipesByFilter viewRecipesByFilter = new ViewRecipesByFilter();
    public static ViewTopPicks viewTopPicks = new ViewTopPicks();
    public static ViewRecipesByRandom viewByRandom = new ViewRecipesByRandom();
    public static ViewSavedRecipesByFilter viewSavedRecipesByFilter = new ViewSavedRecipesByFilter();
    public static ViewAllSavedRecipes viewAllSavedRecipes = new ViewAllSavedRecipes();

    public static void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, createMessage(message));
    }

    public static String queryUser(String message) {
        return (String) JOptionPane.showInputDialog(
                null,
                createMessage(message),
                "Recipick",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                ""
        );
    }

    private static Object createMessage(String message) {
        if (message.length() < 100) {
            return message;
        }

        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setPreferredSize(new Dimension(500, 300));

        return scroll;
    }

    public static JButton createButtonFromCommand(Command command) {
        JButton button = new JButton(capitalize(command.getName()));
        button.addActionListener(e -> command.runAction(Application.getInstance()));
        button.setToolTipText(command.getDescription());

        return button;
    }

    private static String capitalize(String line) {
        boolean atStartOfWord = true;
        StringBuilder newString = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (atStartOfWord) {
                newString.append(Character.toUpperCase(c));
                atStartOfWord = false;
            } else {
                if (c == ' ') {
                    atStartOfWord = true;
                }
                newString.append(c);
            }
        }

        return newString.toString();
    }

    public GUIForm(){
    }
}