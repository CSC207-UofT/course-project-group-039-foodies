package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

public class ViewRecipesByFilter {
    public JFrame viewRecipesByFilter;

    public ViewRecipesByFilter() {
        initialize();
    }

    private void initialize() {
        viewRecipesByFilter = new JFrame();
        viewRecipesByFilter.setBounds(100, 100, 450, 300);
        viewRecipesByFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewRecipesByFilter.setTitle("Recipick");
        viewRecipesByFilter.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("View By Filter");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        viewRecipesByFilter.getContentPane().add(label);

        JButton btnIngredient = new JButton("By Ingredient");
        btnIngredient.addActionListener(e -> {
            viewRecipesByFilter.setVisible(false);
//                GUIForm.preferences.setVisible(true);

        });
        btnIngredient.setBounds(150, 50, 150, 23);
        viewRecipesByFilter.getContentPane().add(btnIngredient);

        JButton btnType = new JButton("By Type");
        btnType.addActionListener(e -> {
            viewRecipesByFilter.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnType.setBounds(150, 90, 150, 23);
        viewRecipesByFilter.getContentPane().add(btnType);

        JButton btnServing = new JButton("By Servings");
        btnServing.addActionListener(e -> {
            viewRecipesByFilter.setVisible(false);
//                GUIForm.show_recipes.setVisible(true);

        });
        btnServing.setBounds(150, 130, 150, 23);
        viewRecipesByFilter.getContentPane().add(btnServing);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewRecipesByFilter.setVisible(false);
            GUIForm.new_recipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewRecipesByFilter.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        viewRecipesByFilter.setVisible(true);
    }
}
