package main.java.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Menu extends JFrame {

    /**
     *
     */
//    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Menu() {
        setTitle("Recipick");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 649, 474);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setForeground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblmenu = new JLabel("Recipick Menu");
        lblmenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblmenu.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblmenu.setBounds(0, 69, 613, 59);
        contentPane.add(lblmenu);


        JButton enter_preferences = new JButton("Enter Preferences");
        enter_preferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        enter_preferences.setBounds(217, 213, 194, 33);
        contentPane.add(enter_preferences);

        JButton view_new_recipes = new JButton("View New Recipes");
        view_new_recipes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }

        });
        view_new_recipes.setBounds(217, 256, 194, 33);
        contentPane.add(view_new_recipes);

        JButton view_recipe_book = new JButton("View Recipe Book");
        view_recipe_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        view_recipe_book.setBounds(217, 300, 194, 32);
        contentPane.add(view_recipe_book);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(getComponent(0), "Thanks For Using") ;
                System.exit(0);
            }
        });
        btnExit.setBounds(217, 343, 194, 33);
        contentPane.add(btnExit);

        JButton create_group = new JButton("Create Group");
        create_group.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }

        });
        create_group.setBounds(217, 166, 194, 36);
        contentPane.add(create_group);

    }
    public void setVisible(boolean b) {
        contentPane.setVisible(true);
    }
}
