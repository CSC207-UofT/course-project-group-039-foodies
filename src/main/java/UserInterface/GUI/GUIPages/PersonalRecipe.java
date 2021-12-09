package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.RateRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

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
        GroupRecipe.setFont(label, showRecipes);

        JButton showAll = GUIForm.createButtonFromCommand(new ListRecipeBookCommand());
        showAll.setBounds(150, 90, 150, 23);
        showRecipes.getContentPane().add(showAll);

        JButton removeRecipe = GUIForm.createButtonFromCommand(new RemoveRecipeCommand());
        removeRecipe.setBounds(150, 130, 150, 23);
        showRecipes.getContentPane().add(removeRecipe);

        JButton rateRecipe = GUIForm.createButtonFromCommand(new RateRecipeCommand());
        rateRecipe.setBounds(150, 170, 150, 23);
        showRecipes.getContentPane().add(rateRecipe);
        
        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            showRecipes.setVisible(false);
            GUIForm.menu.setVisible();

        });
        btnBack.setBounds(150, 210, 150, 23);
        showRecipes.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showRecipes.getContentPane().add(img);
    }

    public void setVisible() {
        showRecipes.setVisible(true);
    }
}
