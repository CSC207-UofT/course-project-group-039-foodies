package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeBookCommands.ListSubRecipeBookRecipesCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.ListSubRecipeBooksCommand;
import main.java.UserInterface.Commands.RecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class SubRecipeBook {
    public JFrame showSubRecipes;

    public SubRecipeBook() {
        initialize();
    }

    private void initialize() {
        showSubRecipes = new JFrame();
        showSubRecipes.setBounds(100, 100, 450, 300);
        showSubRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showSubRecipes.setTitle("Recipick");
        showSubRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Sub Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        showSubRecipes.getContentPane().add(label);

        // filter option
        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            showSubRecipes.setVisible(false);
            GUIForm.viewSavedRecipesByFilter.setVisible(true);
        });
        byFilter.setBounds(75, 50, 150, 23);
        showSubRecipes.getContentPane().add(byFilter);

        // sort option
        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            showSubRecipes.setVisible(false);
            GUIForm.viewSavedRecipesBySort.setVisible(true);
        });
        bySort.setBounds(225, 50, 150, 23);
        showSubRecipes.getContentPane().add(bySort);

        // show recipes in sub-recipe book option
        JButton showAll = GUIForm.createButtonFromCommand(new ListSubRecipeBookRecipesCommand());
        showAll.setBounds(150, 90, 150, 23);
        showSubRecipes.getContentPane().add(showAll);

        // remove recipes from the sub-recipe book option
        JButton removeRecipe = GUIForm.createButtonFromCommand(new RemoveRecipeCommand());
        removeRecipe.setBounds(150, 130, 150, 23);
        showSubRecipes.getContentPane().add(removeRecipe);

        // go back option
        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            showSubRecipes.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        showSubRecipes.getContentPane().add(btnBack);

        // background
        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showSubRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        showSubRecipes.setVisible(true);
    }
}
