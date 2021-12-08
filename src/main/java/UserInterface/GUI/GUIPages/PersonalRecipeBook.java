package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.*;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class PersonalRecipeBook {
    public JFrame personalRecipeBook;

    public PersonalRecipeBook() {
        initialize();
    }

    private void initialize() {
        personalRecipeBook = new JFrame();
        personalRecipeBook.setBounds(100, 100, 450, 300);
        personalRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        personalRecipeBook.setTitle("Recipick");
        personalRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Personal Recipe Books");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(140, 11, 200, 41);
        personalRecipeBook.getContentPane().add(label);


        JButton addSubRecipeBook = GUIForm.createButtonFromCommand(new AddSubRecipeBookCommand());
        addSubRecipeBook.setBounds(130, 90, 200, 23);
        personalRecipeBook.getContentPane().add(addSubRecipeBook);


        JButton deleteSubRecipeBook = GUIForm.createButtonFromCommand(new DeleteSubRecipeBookCommand());
        deleteSubRecipeBook.setBounds(130, 130, 200, 23);
        personalRecipeBook.getContentPane().add(deleteSubRecipeBook);


        JButton showSubRecipeBook = GUIForm.createButtonFromCommand(new ListSubRecipeBooksCommand());
        showSubRecipeBook.setBounds(130, 170, 200, 23);
        personalRecipeBook.getContentPane().add(showSubRecipeBook);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            personalRecipeBook.setVisible(false);
            GUIForm.menu.setVisible(true);

        });
        btnBack.setBounds(150, 210, 150, 23);
        personalRecipeBook.getContentPane().add(btnBack);


    }

    public void setVisible(boolean b) {
        personalRecipeBook.setVisible(true);
    }
}
