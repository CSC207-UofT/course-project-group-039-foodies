package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

public class RecipeBook {
    public JFrame showRecipes;

    public RecipeBook() {
        initialize();
    }

    private void initialize() {
        showRecipes = new JFrame();
        showRecipes.setBounds(100, 100, 450, 300);
        showRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showRecipes.setTitle("Recipick");
        showRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        showRecipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.viewSavedRecipesByFilter.setVisible(true);

        });
        byFilter.setBounds(150, 50, 150, 23);
        showRecipes.getContentPane().add(byFilter);

        //JButton showAll = new JButton("Show All");
        //showAll.addActionListener(e -> {
            // show_recipes.setVisible(false);
            // GUIForm.viewAllSavedRecipes.setVisible(true);

            //Command displayRecipeBook = new ListRecipeBookCommand();
            //displayRecipeBook.runAction(Application.getInstance());
        //});

        JButton showAll = GUIForm.createButtonFromCommand(new ListRecipeBookCommand());
        showAll.setBounds(150, 90, 150, 23);
        showRecipes.getContentPane().add(showAll);

        JButton removeRecipe = GUIForm.createButtonFromCommand(new RemoveRecipeCommand());
        removeRecipe.setBounds(150, 130, 150, 23);
        showRecipes.getContentPane().add(removeRecipe);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        showRecipes.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        showRecipes.setVisible(true);
    }
}
