package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * General recipes page (Saved Recipes).
 */
public class GeneralRecipes {
    public JFrame generalRecipes;

    public GeneralRecipes() {
        initialize();
    }

    private void initialize() {
        generalRecipes = new JFrame();
        generalRecipes.setBounds(100, 100, 450, 300);
        generalRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generalRecipes.setTitle("Recipick");
        generalRecipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Saved Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(160, 11, 150, 41);
        generalRecipes.getContentPane().add(label);


        JButton btnpersonalRecipe = new JButton("Saved Personal Recipes");
        btnpersonalRecipe.addActionListener(e -> {
            generalRecipes.setVisible(false);
            GUIForm.showRecipes.setVisible(true);
        });
        btnpersonalRecipe.setBounds(130, 110, 190, 23);
        generalRecipes.getContentPane().add(btnpersonalRecipe);


        JButton btngroupRecipe = new JButton("Saved Group Recipes");
        btngroupRecipe.addActionListener(e -> {
            generalRecipes.setVisible(false);
            GUIForm.showGroupRecipes.setVisible(true);
        });
        btngroupRecipe.setBounds(130, 150, 190, 23);
        generalRecipes.getContentPane().add(btngroupRecipe);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generalRecipes.setVisible(false);
                GUIForm.menu.setVisible(true);

            }
        });
        btnBack.setBounds(150, 210, 150, 23);
        generalRecipes.getContentPane().add(btnBack);


        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        generalRecipes.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        generalRecipes.setVisible(true);
    }
}
