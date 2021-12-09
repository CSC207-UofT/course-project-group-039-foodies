package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterAllRecipesCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterSavedRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveAllSavedRecipesFilterCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedFilterCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

/**
 * Create GUI page ViewSavedRecipesByFilter, which allows user to filter saved recipes.
 */
public class ViewAllSavedRecipesFiltered {
    public JFrame viewAllSavedRecipesFiltered;

    /**
     * Initialize ViewSavedRecipesByFilter.
     */
    public ViewAllSavedRecipesFiltered() {
        initialize();
    }

    private void initialize() {
        viewAllSavedRecipesFiltered = new JFrame();
        viewAllSavedRecipesFiltered.setBounds(100, 100, 450, 300);
        viewAllSavedRecipesFiltered.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAllSavedRecipesFiltered.setTitle("Recipick");
        viewAllSavedRecipesFiltered.getContentPane().setLayout(null);

        JButton addFilter = GUIForm.createButtonFromCommand(new FilterAllRecipesCommand());
        addFilter.setBounds(150, 50, 150, 23);
        viewAllSavedRecipesFiltered.getContentPane().add(addFilter);

        JButton removeFilter = GUIForm.createButtonFromCommand(new RemoveAllSavedRecipesFilterCommand());
        removeFilter.setBounds(150, 100, 150, 23);
        viewAllSavedRecipesFiltered.getContentPane().add(removeFilter);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewAllSavedRecipesFiltered.setVisible(false);
            GUIForm.showRecipes.setVisible(true);
        });
        btnExit.setBounds(150, 210, 150, 23);
        viewAllSavedRecipesFiltered.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewAllSavedRecipesFiltered.getContentPane().add(img);
    }

    /**
     * Make ViewSavedRecipesByFilter GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewAllSavedRecipesFiltered.setVisible(true);
    }
}
