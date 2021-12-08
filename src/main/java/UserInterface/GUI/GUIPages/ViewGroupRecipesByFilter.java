package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterGroupRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveFilterCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveGroupFilterCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;


/**
 * Create GUI page ViewRecipesByFilter, which allows user to filter recipes in the database.
 */
public class ViewGroupRecipesByFilter {
    public JFrame viewGroupRecipesByFilter;

    /**
     * Initialize ViewRecipesByFilter.
     */
    public ViewGroupRecipesByFilter() {
        initialize();
    }

    private void initialize() {
        viewGroupRecipesByFilter = new JFrame();
        viewGroupRecipesByFilter.setBounds(100, 100, 450, 300);
        viewGroupRecipesByFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGroupRecipesByFilter.setTitle("Recipick");
        viewGroupRecipesByFilter.getContentPane().setLayout(null);

        JButton addFilter = GUIForm.createButtonFromCommand(new FilterGroupRecipeBookCommand());
        addFilter.setBounds(150, 50, 150, 23);
        viewGroupRecipesByFilter.getContentPane().add(addFilter);

        JButton removeFilter = GUIForm.createButtonFromCommand(new RemoveGroupFilterCommand());
        removeFilter.setBounds(150, 100, 150, 23);
        viewGroupRecipesByFilter.getContentPane().add(removeFilter);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewGroupRecipesByFilter.setVisible(false);
            GUIForm.newRecipes.setVisible(true);
        });
        btnExit.setBounds(150, 210, 150, 23);
        viewGroupRecipesByFilter.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewGroupRecipesByFilter.getContentPane().add(img);
    }

    /**
     * Make ViewRecipesByFilter GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewGroupRecipesByFilter.setVisible(true);
    }
}
