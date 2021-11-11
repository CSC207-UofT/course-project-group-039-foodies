package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecipeBook {
    public JFrame show_recipes;

    public RecipeBook() {
        initialize();
    }

    private void initialize() {
        show_recipes = new JFrame();
        show_recipes.setBounds(100, 100, 450, 300);
        show_recipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show_recipes.setTitle("Recipick");
        show_recipes.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Recipes");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(200, 11, 170, 41);
        show_recipes.getContentPane().add(label);

        JButton byFilter = new JButton("By Filter");
        byFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show_recipes.setVisible(false);
//                GUIForm.show_by_filter.setVisible(true);

            }
        });
        byFilter.setBounds(150, 50, 150, 23);
        show_recipes.getContentPane().add(byFilter);

        JButton showAll = new JButton("Show All");
        showAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show_recipes.setVisible(false);
//                GUIForm.show_all.setVisible(true);

            }
        });
        showAll.setBounds(150, 90, 150, 23);
        show_recipes.getContentPane().add(showAll);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show_recipes.setVisible(false);
                GUIForm.menu.setVisible(true);

            }
        });
        btnBack.setBounds(150, 210, 150, 23);
        show_recipes.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        show_recipes.setVisible(true);
    }
}
