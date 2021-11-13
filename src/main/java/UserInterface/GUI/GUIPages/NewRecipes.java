package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeBookCommands.AddToRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

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
        byFilter.setBounds(150, 50, 150, 23);
        newRecipes.getContentPane().add(byFilter);

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
    }

    public void setVisible(boolean b) {
        newRecipes.setVisible(true);
    }
}
