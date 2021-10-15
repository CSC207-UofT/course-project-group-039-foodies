package main;

import java.util.Scanner;

public class User {
    private String fullname;
    private String username;
    private String email;
    private RecipeBook recipebook;
    private Prefere

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String fullname = keyboard.nextLine();
        System.out.print("Please enter your preferred username: ");
        String username = keyboard.nextLine();
        System.out.print("Please enter your email: ");
        String email = keyboard.nextLine();
        User user = new User(fullname, username, email) ;
    }
    public User(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.recipebook = new RecipeBook();
        this.preferences =
    }

}


