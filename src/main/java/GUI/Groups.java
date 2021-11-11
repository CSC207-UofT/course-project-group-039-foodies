package main.java.GUI;

import main.java.GUIForm;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Groups {
    public JFrame groups;

    public Groups() {
        initialize();
    }

    private void initialize() {
        groups = new JFrame();
        groups.setBounds(100, 100, 450, 300);
        groups.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groups.setTitle("Recipick");
        groups.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Groups");
        label.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.setBounds(200, 11, 170, 41);
        groups.getContentPane().add(label);

        JButton viewGroups = new JButton("View Groups");
        viewGroups.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                groups.setVisible(false);
//                GUIForm.show_by_filter.setVisible(true);

            }
        });
        viewGroups.setBounds(150, 50, 150, 23);
        groups.getContentPane().add(viewGroups);

        JButton createGroup = new JButton("Create Group");
        createGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                groups.setVisible(false);
//                GUIForm.show_all.setVisible(true);

            }
        });
        createGroup.setBounds(150, 90, 150, 23);
        groups.getContentPane().add(createGroup);


        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                groups.setVisible(false);
                GUIForm.menu.setVisible(true);

            }
        });
        btnBack.setBounds(150, 210, 150, 23);
        groups.getContentPane().add(btnBack);
    }

    public void setVisible(boolean b) {
        groups.setVisible(true);
    }
}
