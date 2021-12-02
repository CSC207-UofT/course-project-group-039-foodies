package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;
import javax.swing.JButton;



public class ViewRecipesBySort {
    public JFrame viewRecipesBySort;

    public ViewRecipesBySort() {
        initialize();
    }

    private void initialize() {
        viewRecipesBySort = new JFrame();
        viewRecipesBySort.setBounds(100, 100, 450, 300);
        viewRecipesBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRecipesBySort.setTitle("Recipick");
        viewRecipesBySort.getContentPane().setLayout(null);

        // title
        /*
        JLabel label = new JLabel("View By Sort");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        viewRecipesBySort.getContentPane().add(label);

        JButton btnRating = new JButton("By Rating");
        btnRating.addActionListener(e -> {
            viewRecipesBySort.setVisible(false);
//                GUIForm.preferences.setVisible(true);

        });
        btnRating.setBounds(150, 50, 150, 23);
        viewRecipesBySort.getContentPane().add(btnRating);

        JButton btnServings = new JButton("By Number of Servings");
        btnServings.addActionListener(e -> {
            viewRecipesBySort.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnServings.setBounds(150, 90, 150, 23);
        viewRecipesBySort.getContentPane().add(btnServings);
        */

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

    public void setVisible(boolean b) {
        viewRecipesBySort.setVisible(true);
    }
}
