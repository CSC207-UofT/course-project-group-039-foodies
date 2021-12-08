package main.java.UserInterface.GUI.GUIPages;

import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.RemoveSavedSortCommand;
import main.java.UserInterface.Commands.RecipeViewerCommands.FilterAndSortCommands.SortSavedRecipeBookCommand;
import main.java.UserInterface.GUI.GUIForm;

import javax.swing.*;

public class ViewGroupSubRecipeBookBySort {
    public JFrame viewGroupSubRecipeBookBySort;
    /**
     * Initialize ViewSavedRecipesBySort.
     */
    public ViewGroupSubRecipeBookBySort() {
        initialize();
    }

    private void initialize() {
        viewGroupSubRecipeBookBySort = new JFrame();
        viewGroupSubRecipeBookBySort.setBounds(100, 100, 450, 300);
        viewGroupSubRecipeBookBySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGroupSubRecipeBookBySort.setTitle("Recipick");
        viewGroupSubRecipeBookBySort.getContentPane().setLayout(null);

        JButton setSort = GUIForm.createButtonFromCommand(new SortSavedRecipeBookCommand());
        setSort.setBounds(150, 50, 150, 23);
        viewGroupSubRecipeBookBySort.getContentPane().add(setSort);

        JButton removeSort = GUIForm.createButtonFromCommand(new RemoveSavedSortCommand());
        removeSort.setBounds(150, 100, 150, 23);
        viewGroupSubRecipeBookBySort.getContentPane().add(removeSort);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(e -> {
            viewGroupSubRecipeBookBySort.setVisible(false);
            GUIForm.showGroupSubRecipeBook.setVisible(true);
        });
        btnExit.setBounds(150, 210, 150, 23);
        viewGroupSubRecipeBookBySort.getContentPane().add(btnExit);

        JLabel img = new JLabel("New image");
        img.setIcon(new ImageIcon("src/white food background.jpeg"));
        img.setBounds(0, 0, 460, 300);
        viewGroupSubRecipeBookBySort.getContentPane().add(img);
    }

    /**
     * Make ViewSavedRecipesBySort GUI page visible or invisible.
     * @param b true if the page needs to be visible, or false if the page needs to be invisible.
     */
    public void setVisible(boolean b) {
        viewGroupSubRecipeBookBySort.setVisible(true);
    }
}

