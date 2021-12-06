package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveFilterCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;


/**
 * Create GUI page ViewRecipesByFilter, which allows user to filter recipes in the database.
 */
public class ViewRecipesByFilter {
    public JFrame viewRecipesByFilter;

    /**
     * Initialize ViewRecipesByFilter.
     */
    public ViewRecipesByFilter() {
        initialize();
    }

    private void initialize() {
        viewRecipesByFilter = new JFrame();
        viewRecipesByFilter.setBounds(100, 100, 450, 300);
        viewRecipesByFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRecipesByFilter.setTitle("Recipick");
        viewRecipesByFilter.getContentPane().setLayout(null);

        JButton addFilter = GUIForm.createButtonFromCommand(new FilterRecipeBookCommand());
        addFilter.setBounds(150, 50, 150, 23);
        viewRecipesByFilter.getContentPane().add(addFilter);

        JButton removeFilter = GUIForm.createButtonFromCommand(new RemoveFilterCommand());
        removeFilter.setBounds(150, 100, 150, 23);
        viewRecipesByFilter.getContentPane().add(removeFilter);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewRecipesByFilter.setVisible(false);
            GUIForm.newRecipes.setVisible(true);
        });
        btnExit.setBounds(150, 210, 150, 23);
        viewRecipesByFilter.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewRecipesByFilter.getContentPane().add(img);

        // btnServing.setBounds(150, 130, 150, 23);
        // ViewTopPicks.viewRecipeContentPane(btnServing, viewRecipesByFilter);
    }

    /**
     * Make ViewRecipesByFilter GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewRecipesByFilter.setVisible(true);
    }
}
