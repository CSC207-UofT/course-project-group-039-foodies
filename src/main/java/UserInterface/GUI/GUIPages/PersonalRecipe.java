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

        // by Filter Option
        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.viewAllSavedRecipesFiltered.setVisible(true);
        });
        byFilter.setBounds(75, 50, 150, 23);
        showRecipes.getContentPane().add(byFilter);

        // by Sort Option
        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.viewAllSavedRecipesSorted.setVisible(true);
        });
        bySort.setBounds(225, 50, 150, 23);
        showRecipes.getContentPane().add(bySort);

        // show all recipes option
        JButton showAll = GUIForm.createButtonFromCommand(new ListRecipeBookCommand());
        showAll.setBounds(150, 90, 150, 23);
        showRecipes.getContentPane().add(showAll);

        // option to go back
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.generalRecipes.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        showRecipes.getContentPane().add(btnBack);

        // background image
        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        showRecipes.setVisible(true);
    }
}
