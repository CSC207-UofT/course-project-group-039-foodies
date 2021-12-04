package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortSavedRecipeBookCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedSortCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;
import javax.swing.JButton;


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

        // title
        /*
        JLabel label = new JLabel("View By Sort");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        viewSavedRecipesBySort.getContentPane().add(label);

        JButton btnRating = new JButton("By Rating");
        btnRating.addActionListener(e -> {
            viewSavedRecipesBySort.setVisible(false);
//                GUIForm.preferences.setVisible(true);

        });
        btnRating.setBounds(150, 50, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(btnRating);

        JButton btnServings = new JButton("By Number of Servings");
        btnServings.addActionListener(e -> {
            viewSavedRecipesBySort.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnServings.setBounds(150, 90, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(btnServings);
        */

        JButton setSort = GUIForm.createButtonFromCommand(new SortSavedRecipeBookCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveSavedSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewSavedRecipesBySort.setVisible(false);
            GUIForm.showRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewSavedRecipesBySort.getContentPane().add(btnExit);
    }

    /**
     * Make ViewSavedRecipesBySort GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewSavedRecipesBySort.setVisible(true);
    }
}
