package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveGroupSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortGroupRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;


/**
 * Create GUI page ViewRecipesBySort, which allows user to sort recipes in the database.
 */
public class ViewGroupRecipesBySort {
    public JFrame viewGroupRecipesBySort;

    /**
     * Initialize ViewRecipesBySort.
     */
    public ViewGroupRecipesBySort() {
        initialize();
    }

    private void initialize() {
        viewGroupRecipesBySort = new JFrame();
        viewGroupRecipesBySort.setBounds(100, 100, 450, 300);
        viewGroupRecipesBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGroupRecipesBySort.setTitle("Recipick");
        viewGroupRecipesBySort.getContentPane().setLayout(null);

        JButton setSort = GUIForm.createButtonFromCommand(new SortGroupRecipeBookCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewGroupRecipesBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveGroupSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewGroupRecipesBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewGroupRecipesBySort.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewGroupRecipesBySort.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewGroupRecipesBySort.getContentPane().add(img);
    }

    /**
     * Make ViewRecipesBySort GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewGroupRecipesBySort.setVisible(true);
    }
}
