package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;
import javax.swing.JButton;


/**
 * Create GUI page ViewRecipesBySort, which allows user to sort recipes in the database.
 */
public class ViewRecipesBySort {
    public JFrame viewRecipesBySort;

    /**
     * Initialize ViewRecipesBySort.
     */
    public ViewRecipesBySort() {
        initialize();
    }

    private void initialize() {
        viewRecipesBySort = new JFrame();
        viewRecipesBySort.setBounds(100, 100, 450, 300);
        viewRecipesBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRecipesBySort.setTitle("Recipick");
        viewRecipesBySort.getContentPane().setLayout(null);

        JButton setSort = GUIForm.createButtonFromCommand(new SortRecipeBookCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewRecipesBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewRecipesBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewRecipesBySort.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewRecipesBySort.getContentPane().add(btnExit);
    }

    /**
     * Make ViewRecipesBySort GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewRecipesBySort.setVisible(true);
    }
}
