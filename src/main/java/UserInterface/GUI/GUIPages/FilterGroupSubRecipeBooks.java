package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterSavedRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedFilterCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

/**
 * Create GUI page ViewSavedRecipesByFilter, which allows user to filter saved recipes.
 */
public class FilterGroupSubRecipeBooks {
    public JFrame viewFilteredGroupSubRecipeBook;

    /**
     * Initialize ViewSavedRecipesByFilter.
     */
    public FilterGroupSubRecipeBooks() {
        initialize();
    }

    private void initialize() {
        viewFilteredGroupSubRecipeBook = new JFrame();
        viewFilteredGroupSubRecipeBook.setBounds(100, 100, 450, 300);
        viewFilteredGroupSubRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFilteredGroupSubRecipeBook.setTitle("Recipick");
        viewFilteredGroupSubRecipeBook.getContentPane().setLayout(null);

        // Filter Option
        JButton addFilter = GUIForm.createButtonFromCommand(new FilterSavedRecipeBookCommand());
        addFilter.setBounds(150, 50, 150, 23);
        viewFilteredGroupSubRecipeBook.getContentPane().add(addFilter);

        // Remove Filter Option
        JButton removeFilter = GUIForm.createButtonFromCommand(new RemoveSavedFilterCommand());
        removeFilter.setBounds(150, 100, 150, 23);
        viewFilteredGroupSubRecipeBook.getContentPane().add(removeFilter);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewFilteredGroupSubRecipeBook.setVisible(false);
            GUIForm.showGroupSubRecipeBook.setVisible(true);
        });
        btnExit.setBounds(150, 210, 150, 23);
        viewFilteredGroupSubRecipeBook.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewFilteredGroupSubRecipeBook.getContentPane().add(img);
    }

    /**
     * Make ViewSavedRecipesByFilter GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewFilteredGroupSubRecipeBook.setVisible(true);
    }
}

