package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.CreateGroupCommand;
import main.java.UserInterface.Commands.GroupCommands.RemoveGroupMemberCommand;
import main.java.UserInterface.Commands.GroupCommands.ViewGroupsCommand;
import main.java.UserInterface.GUI.GUIForm;

import java.awt.Font;
import javax.swing.*;


public class Groups {
    public JFrame groups;

    public Groups() {
        initialize();
    }

    private void initialize() {
        groups = new JFrame();
        groups.setBounds(80, 100, 450, 300);
        groups.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groups.setTitle("Recipick");
        groups.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Manage Groups");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(160, 11, 170, 41);
        groups.getContentPane().add(label);

        JButton createGroup = GUIForm.createButtonFromCommand(new CreateGroupCommand());
        createGroup.setBounds(150, 50, 150, 23);
        groups.getContentPane().add(createGroup);

        JButton addMember = GUIForm.createButtonFromCommand(new AddGroupMemberCommand());
        addMember.setBounds(150, 90, 150, 23);
        groups.getContentPane().add(addMember);

        JButton removeMember = GUIForm.createButtonFromCommand(new RemoveGroupMemberCommand());
        removeMember.setBounds(140, 130, 170, 23);
        groups.getContentPane().add(removeMember);

        JButton viewJoinedGroups = GUIForm.createButtonFromCommand(new ViewGroupsCommand());
        viewJoinedGroups.setBounds(130, 170, 200, 23);
        groups.getContentPane().add(viewJoinedGroups);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e ->  {
            groups.setVisible(false);
            GUIForm.menu.setVisible();
        });
        btnBack.setBounds(150, 210, 150, 23);
        groups.getContentPane().add(btnBack);
    }

    public void setVisible() {
        groups.setVisible(true);
    }
}
