package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

public class ViewSavedRecipesByFilter {
    public JFrame viewSavedRecipesByFilter;

    public ViewSavedRecipesByFilter() {
        initialize();
    }

    private void initialize() {
        viewSavedRecipesByFilter = new JFrame();
        viewSavedRecipesByFilter.setBounds(100, 100, 450, 300);
        viewSavedRecipesByFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewSavedRecipesByFilter.setTitle("Recipick");
        viewSavedRecipesByFilter.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("View By Filter");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        viewSavedRecipesByFilter.getContentPane().add(label);

        JButton btnIngredient = new JButton("By Ingredient");
        btnIngredient.addActionListener(e -> {
            viewSavedRecipesByFilter.setVisible(false);
//                GUIForm.preferences.setVisible(true);

        });
        btnIngredient.setBounds(150, 50, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(btnIngredient);

        JButton btnType = new JButton("By Type");
        btnType.addActionListener(e -> {
            viewSavedRecipesByFilter.setVisible(false);
//                GUIForm.new_recipes.setVisible(true);

        });
        btnType.setBounds(150, 90, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(btnType);

        JButton btnServing = new JButton("By Servings");
        btnServing.addActionListener(e -> {
            viewSavedRecipesByFilter.setVisible(false);
//                GUIForm.show_recipes.setVisible(true);

        });
        btnServing.setBounds(150, 130, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(btnServing);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewSavedRecipesByFilter.setVisible(false);
            GUIForm.newRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewSavedRecipesByFilter.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        viewSavedRecipesByFilter.setVisible(true);
    }
}
