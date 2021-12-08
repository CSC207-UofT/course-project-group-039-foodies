package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeBookCommands.AddToRecipeBookCommand;
import main.java.UserInterface.Commands.UserPreferencesCommands.RateRecipeCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class NewRecipes {
    public JFrame newRecipes;

    public NewRecipes() {
        initialize();
    }

    private void initialize() {
        newRecipes = new JFrame();
        newRecipes.setBounds(100, 100, 450, 300);
        newRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newRecipes.setTitle("Recipick");
        newRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("New Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        newRecipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewRecipesByFilter.setVisible(true);

        });
        byFilter.setBounds(75, 50, 150, 23);
        newRecipes.getContentPane().add(byFilter);

        JButton bySort = new JButton("By Sort");
        bySort.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewRecipesBySort.setVisible(true);
        });
        bySort.setBounds(225, 50, 150, 23);
        newRecipes.getContentPane().add(bySort);

        JButton topPicks = new JButton("Top Picks");
        topPicks.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewTopPicks.setVisible(true);

        });
        topPicks.setBounds(150, 90, 150, 23);
        newRecipes.getContentPane().add(topPicks);

        JButton random = new JButton("Random");
        random.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.viewByRandom.setVisible(true);

        });
        random.setBounds(150, 130, 150, 23);
        newRecipes.getContentPane().add(random);

        JButton addToRecipeBook = GUIForm.createButtonFromCommand(new AddToRecipeBookCommand());
        addToRecipeBook.setBounds(150, 170, 150, 23);
        newRecipes.getContentPane().add(addToRecipeBook);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            newRecipes.setVisible(false);
            GUIForm.menu.setVisible(true);

        });

        btnBack.setBounds(150, 210, 150, 23);
        newRecipes.getContentPane().add(btnBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        newRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        newRecipes.setVisible(true);
    }
}
