package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.GUI.GUIForm;

import javax.swing.JFrame;

import javax.swing.JButton;

public class ViewAllSavedRecipes {
    public JFrame viewAllSavedRecipes;

    public ViewAllSavedRecipes() {
        initialize();
    }

    private void initialize() {
        viewAllSavedRecipes = new JFrame();
        viewAllSavedRecipes.setBounds(100, 100, 450, 300);
        viewAllSavedRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAllSavedRecipes.setTitle("Recipick");
        viewAllSavedRecipes.getContentPane().setLayout(null);


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewAllSavedRecipes.setVisible(false);
            GUIForm.showRecipes.setVisible(true);

        });
        btnExit.setBounds(150, 210, 150, 23);
        viewAllSavedRecipes.getContentPane().add(btnExit);
    }

    public void setVisible(boolean b) {
        viewAllSavedRecipes.setVisible(true);
    }
}
