package main.java.UserInterface.GUI;
import main.java.UserInterface.GUI.GUIPages.*;
import main.java.UserInterface.GUI.GUIPages.Menu;

import javax.swing.*;
import java.awt.*;

public class GUIForm {
    public static Start start = new Start();
    public static Login login = new Login();
    public static Signup signup = new Signup();
    public static Menu menu = new Menu();
    public static Preferences preferences = new Preferences();
    public static NewRecipes new_recipes = new NewRecipes();
    public static RecipeBook show_recipes = new RecipeBook();
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
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );
    }

    private static JScrollPane createMessage(String message) {
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

    public GUIForm(){
    }
}
