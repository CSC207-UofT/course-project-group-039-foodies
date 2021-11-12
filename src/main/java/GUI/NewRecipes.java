package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewRecipes {
    public JFrame new_recipes;

    public NewRecipes() {
        initialize();
    }

    private void initialize() {
        new_recipes = new JFrame();
        new_recipes.setBounds(100, 100, 450, 300);
        new_recipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new_recipes.setTitle("Recipick");
        new_recipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("New Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        new_recipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(e -> {
            new_recipes.setVisible(false);
            GUIForm.viewRecipesByFilter.setVisible(true);

        });
        byFilter.setBounds(150, 50, 150, 23);
        new_recipes.getContentPane().add(byFilter);

        JButton topPicks = new JButton("Top Picks");
        topPicks.addActionListener(e -> {
            new_recipes.setVisible(false);
            GUIForm.viewTopPicks.setVisible(true);

        });
        topPicks.setBounds(150, 90, 150, 23);
        new_recipes.getContentPane().add(topPicks);

        JButton random = new JButton("Random");
        random.addActionListener(e -> {
            new_recipes.setVisible(false);
            GUIForm.viewByRandom.setVisible(true);

        });
        random.setBounds(150, 130, 150, 23);
        new_recipes.getContentPane().add(random);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            new_recipes.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        new_recipes.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        new_recipes.setVisible(true);
    }
}
