package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.
        AddSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.
        DeleteSubRecipeBookCommand;

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
        addSubRecipeBook.setBounds(150, 90, 150, 23);
        personalRecipeBook.getContentPane().add(addSubRecipeBook);


        JButton deleteSubRecipeBook = GUIForm.createButtonFromCommand(new DeleteSubRecipeBookCommand());
        deleteSubRecipeBook.setBounds(150, 130, 150, 23);
        personalRecipeBook.getContentPane().add(deleteSubRecipeBook);


    }

    public void setVisible(boolean b) {
        personalRecipeBook.setVisible(true);
    }
}
