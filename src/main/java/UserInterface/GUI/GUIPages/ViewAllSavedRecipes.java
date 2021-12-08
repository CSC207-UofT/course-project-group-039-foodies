//package main.java.UserInterface.GUI.GUIPages;
//
//import main.java.UserInterface.GUI.GUIForm;
//
//import javax.swing.*;
//
//public class ViewAllSavedRecipes {
//    public JFrame viewAllSavedRecipes;
//
//    public ViewAllSavedRecipes() {
//        initialize();
//    }
//
//    private void initialize() {
//        viewAllSavedRecipes = new JFrame();
//        viewAllSavedRecipes.setBounds(100, 100, 450, 300);
//        viewAllSavedRecipes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        viewAllSavedRecipes.setTitle("Recipick");
//        viewAllSavedRecipes.getContentPane().setLayout(null);
//
//
//        JButton btnExit = new JButton("Back");
//        btnExit.addActionListener(e -> {
//            viewAllSavedRecipes.setVisible(false);
//            GUIForm.showRecipes.setVisible(true);
//
//        });
//        btnExit.setBounds(150, 210, 150, 23);
//        viewAllSavedRecipes.getContentPane().add(btnExit);
//
//        JLabel img = new JLabel("New image");
//        img.setIcon(new ImageIcon("src/white food background.jpeg"));
//        img.setBounds(0, 0, 460, 300);
//        viewAllSavedRecipes.getContentPane().add(img);
//    }
//
//    public void setVisible(boolean b) {
//        viewAllSavedRecipes.setVisible(true);
//    }
//}
