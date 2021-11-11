package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.GUIForm;
import main.java.Gateways.UserCSVReader;

public class Start {

    public JFrame start;

    /**
     * Create the application.
     */
    public Start() {
        initialize();
    }

    /**
     * Initialize the contents of the frame1.
     */
    private void initialize() {

        start = new JFrame();
        start.setBounds(100, 100, 450, 300);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.getContentPane().setLayout(null);

        // title
        JLabel label = new JLabel("Recipick", SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBounds(150, 80, 170, 50);
        start.getContentPane().add(label);

        JButton btnLogin = new JButton("Log in");
        btnLogin.setBounds(190, 138, 89, 23);
        start.getContentPane().add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.java.GUIForm.login.setVisible(true);
            }
        });

        JButton btnSignup = new JButton("Sign up");
        btnSignup.setBounds(190, 170, 89, 23);
        start.getContentPane().add(btnSignup);
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {main.java.GUIForm.signup.setVisible(true);
            }

        });

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        start.getContentPane().add(img);

    }

}