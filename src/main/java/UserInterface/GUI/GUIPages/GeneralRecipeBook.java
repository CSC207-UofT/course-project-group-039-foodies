package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;
import javax.swing.*;
import java.awt.Font;

public class GeneralRecipeBook {
    public JFrame generalRecipeBook;

    public GeneralRecipeBook() {
        initialize();
    }

    private void initialize() {
        generalRecipeBook = new JFrame();
        generalRecipeBook.setBounds(100, 100, 450, 300);
        generalRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generalRecipeBook.setTitle("Recipick");
        generalRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Show Recipe Books");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(150, 11, 200, 41);
        generalRecipeBook.getContentPane().add(label);


        JButton btnPersonalRecipeBook = new JButton("Personal Recipe Books");
        btnPersonalRecipeBook.addActionListener(e -> {
            generalRecipeBook.setVisible(false);
            GUIForm.personalRecipeBook.setVisible(true);
                });
        btnPersonalRecipeBook.setBounds(130, 110, 190, 23);
        generalRecipeBook.getContentPane().add(btnPersonalRecipeBook);


        JButton btnGroupRecipeBook = new JButton("Group Recipe Books");
        btnGroupRecipeBook.addActionListener(e -> {
            generalRecipeBook.setVisible(false);
            GUIForm.groupRecipeBook.setVisible(true);
                });
        btnGroupRecipeBook.setBounds(130, 150, 190, 23);
        generalRecipeBook.getContentPane().add(btnGroupRecipeBook);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            generalRecipeBook.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        generalRecipeBook.getContentPane().add(btnBack);


        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        generalRecipeBook.getContentPane().add(img);
    }

    public void setVisible(boolean b) {
        generalRecipeBook.setVisible(true);
    }
}
