package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.ListRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.PersonalRecipeBookCommands.RemoveRecipeCommand;

import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.
        AddGroupSubRecipeBookCommand;
import main.java.UserInterface.Commands.GeneralRecipeBookCommands.GroupRecipeBookCommands.
        DeleteGroupSubRecipeBookCommand;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;
import java.awt.Font;

public class GroupRecipeBook {
    public JFrame groupRecipeBook;

    public GroupRecipeBook() {
        initialize();
    }

    private void initialize() {
        groupRecipeBook = new JFrame();
        groupRecipeBook.setBounds(100, 100, 450, 300);
        groupRecipeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groupRecipeBook.setTitle("Recipick");
        groupRecipeBook.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Group Recipe Books");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(140, 11, 200, 41);
        groupRecipeBook.getContentPane().add(label);


        JButton addSubRecipeBook = GUIForm.createButtonFromCommand(new AddGroupSubRecipeBookCommand());
        addSubRecipeBook.setBounds(150, 90, 150, 23);
        groupRecipeBook.getContentPane().add(addSubRecipeBook);


        JButton deleteSubRecipeBook = GUIForm.createButtonFromCommand(new DeleteGroupSubRecipeBookCommand());
        deleteSubRecipeBook.setBounds(150, 130, 150, 23);
        groupRecipeBook.getContentPane().add(deleteSubRecipeBook);


    }

    public void setVisible(boolean b) {
        groupRecipeBook.setVisible(true);
    }
}
