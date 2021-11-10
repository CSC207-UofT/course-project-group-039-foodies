package main.java;
import main.java.GUI.Login;
import java.awt.*;
import java.awt.EventQueue;
import main.java.GUIForm;

    public class Application {
        public static void main(String[] args)
        {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    GUIForm.start.start.setVisible(true);
                }
            });
        }
    }

