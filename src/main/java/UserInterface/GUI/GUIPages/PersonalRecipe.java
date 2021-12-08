package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class PersonalRecipe {
    public JFrame showRecipes;

    public PersonalRecipe() {
        initialize();
    }

    private void initialize() {
        showRecipes = new JFrame();
        showRecipes.setBounds(100, 100, 450, 300);
        showRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showRecipes.setTitle("Recipick");
        showRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Personal Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(140, 11, 200, 41);
        showRecipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.viewSavedRecipesByFilter.setVisible(true);
        });
        byFilter.setBounds(75, 50, 150, 23);
        showRecipes.getContentPane().add(byFilter);

        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.viewSavedRecipesBySort.setVisible(true);
        });
        bySort.setBounds(225, 50, 150, 23);
        showRecipes.getContentPane().add(bySort);

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

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        showRecipes.setVisible(true);
    }
}
