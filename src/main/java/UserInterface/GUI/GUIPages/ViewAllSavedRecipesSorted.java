package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveAllSavedRecipesSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortAllRecipesCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;


/**
 * Create GUI page ViewSavedRecipesBySort, which allows user to sort saved recipes.
 */
public class ViewAllSavedRecipesSorted {
    public JFrame viewAllSavedRecipesBySort;

    /**
     * Initialize ViewAllSavedRecipesSorted.
     */
    public ViewAllSavedRecipesSorted() {
        initialize();
    }

    private void initialize() {
        viewAllSavedRecipesBySort = new JFrame();
        viewAllSavedRecipesBySort.setBounds(100, 100, 450, 300);
        viewAllSavedRecipesBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAllSavedRecipesBySort.setTitle("Recipick");
        viewAllSavedRecipesBySort.getContentPane().setLayout(null);

        JButton setSort = GUIForm.createButtonFromCommand(new SortAllRecipesCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewAllSavedRecipesBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveAllSavedRecipesSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewAllSavedRecipesBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewAllSavedRecipesBySort.setVisible(false);
            GUIForm.showRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewAllSavedRecipesBySort.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewAllSavedRecipesBySort.getContentPane().add(img);
    }

    /**
     * Make ViewSavedRecipesBySort GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewAllSavedRecipesBySort.setVisible(true);
    }
}
