package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortSavedRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedSortCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;


/**
 * Create GUI page ViewSavedRecipesBySort, which allows user to sort saved recipes.
 */
public class ViewSavedRecipesBySort {
    public JFrame viewSavedRecipesBySort;

    /**
     * Initialize ViewSavedRecipesBySort.
     */
    public ViewSavedRecipesBySort() {
        initialize();
    }

    private void initialize() {
        viewSavedRecipesBySort = new JFrame();
        viewSavedRecipesBySort.setBounds(100, 100, 450, 300);
        viewSavedRecipesBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewSavedRecipesBySort.setTitle("Recipick");
        viewSavedRecipesBySort.getContentPane().setLayout(null);

        JButton setSort = GUIForm.createButtonFromCommand(new SortSavedRecipeBookCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveSavedSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewSavedRecipesBySort.setVisible(false);
            GUIForm.showRecipes.setVisible();

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewSavedRecipesBySort.getContentPane().add(img);
    }

    /**
     * Make ViewSavedRecipesBySort GUI page visible or invisible.
     */
    public void setVisible() {
        viewSavedRecipesBySort.setVisible(true);
    }
}
