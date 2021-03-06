package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.EnterGroupSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.*;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

/**
 * Personal recipe books page.
 */
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

        // option to add a sub recipe book
        JButton addSubRecipeBook = GUIForm.createButtonFromCommand(new AddSubRecipeBookCommand());
        addSubRecipeBook.setBounds(130, 50, 200, 23);
        personalRecipeBook.getContentPane().add(addSubRecipeBook);

        // option to delete a sub recipe book
        JButton deleteSubRecipeBook = GUIForm.createButtonFromCommand(new DeleteSubRecipeBookCommand());
        deleteSubRecipeBook.setBounds(130, 90, 200, 23);
        personalRecipeBook.getContentPane().add(deleteSubRecipeBook);

        // option to see all sub recipe books
        JButton showSubRecipeBook = GUIForm.createButtonFromCommand(new ListSubRecipeBooksCommand());
        showSubRecipeBook.setBounds(130, 130, 200, 23);
        personalRecipeBook.getContentPane().add(showSubRecipeBook);

        // option to enter sub recipe book
        JButton enterSubRecipeBook = GUIForm.createButtonFromCommand(new EnterSubRecipeBookCommand());
        enterSubRecipeBook.setBounds(130, 170, 200, 23);
        enterSubRecipeBook.addActionListener(e -> {
            personalRecipeBook.setVisible(false);
            GUIForm.showSubRecipes.setVisible(true);
        });
        personalRecipeBook.getContentPane().add(enterSubRecipeBook);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            personalRecipeBook.setVisible(false);
            GUIForm.generalRecipeBook.setVisible();

        });
        btnBack.setBounds(150, 210, 150, 23);
        personalRecipeBook.getContentPane().add(btnBack);


    }

    public void setVisible(boolean b) {
        personalRecipeBook.setVisible(true);
    }
}
