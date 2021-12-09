package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.*;

public class ViewRecipeBook {

    public JFrame showRecipeBook;

    public ViewRecipeBook() {
        initialize();
    }

    private void initialize() {
        showRecipeBook = new JFrame();
        showRecipeBook.setBounds(100, 100, 450, 300);
        showRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showRecipeBook.setTitle("Recipick");
        showRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("RecipeBook");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(175, 11, 170, 41);
        showRecipeBook.getContentPane().add(label);

        JButton btnViewAllRecipes = new JButton("View All Saved Recipes");
        btnViewAllRecipes.addActionListener(e -> {
            showRecipeBook.setVisible(false);
            GUIForm.showRecipes.setVisible(true);
        });
        btnViewAllRecipes.setBounds(125, 50, 200, 23);
        showRecipeBook.getContentPane().add(btnViewAllRecipes);

        JButton btnViewSubRecipeBooks = new JButton("View All SubRecipeBooks");
        btnViewSubRecipeBooks.addActionListener(e -> {
            showRecipeBook.setVisible(false);
            GUIForm.viewSubRecipeBooks.setVisible(true);
        });
        btnViewSubRecipeBooks.setBounds(125, 100, 200, 23);
        showRecipeBook.getContentPane().add(btnViewSubRecipeBooks);

        JButton btnGoBack = new JButton("Back to Menu");
        btnGoBack.addActionListener(e-> {
            showRecipeBook.setVisible(false);
            GUIForm.menu.setVisible();
        });
        btnGoBack.setBounds(150, 210, 150, 23);
        showRecipeBook.getContentPane().add(btnGoBack);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        showRecipeBook.getContentPane().add(img);
    }

    public void setVisible(boolean b) {showRecipeBook.setVisible(true);
    }
}
