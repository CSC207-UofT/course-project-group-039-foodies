package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.FilterSavedRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedFilterCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;
import javax.swing.JButton;


/**
 * Create GUI page ViewSavedRecipesByFilter, which allows user to filter saved recipes.
 */
public class ViewSavedRecipesByFilter {
    public JFrame viewSavedRecipesByFilter;

    /**
     * Initialize ViewSavedRecipesByFilter.
     */
    public ViewSavedRecipesByFilter() {
        initialize();
    }

    private void initialize() {
        viewSavedRecipesByFilter = new JFrame();
        viewSavedRecipesByFilter.setBounds(100, 100, 450, 300);
        viewSavedRecipesByFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewSavedRecipesByFilter.setTitle("Recipick");
        viewSavedRecipesByFilter.getContentPane().setLayout(null);

        JButton addFilter = GUIForm.createButtonFromCommand(new FilterSavedRecipeBookCommand());
        addFilter.setBounds(150, 50, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(addFilter);

        JButton removeFilter = GUIForm.createButtonFromCommand(new RemoveSavedFilterCommand());
        removeFilter.setBounds(150, 100, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(removeFilter);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewSavedRecipesByFilter.setVisible(false);
            GUIForm.showRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(btnExit);
    }

    /**
     * Make ViewSavedRecipesByFilter GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewSavedRecipesByFilter.setVisible(true);
    }
}
