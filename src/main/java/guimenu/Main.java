package main.java.guimenu;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    private static final Scanner PROGRAM_SCANNER = new Scanner(System.in);

    public static Scanner getProgramScanner() { return PROGRAM_SCANNER; }

    public static void main(String[] args) {
        runStartMenu();
    }

    private static void runStartMenu() {
        EnumSet<Options> start_options = EnumSet.of(Options.A, Options.B, Options.C, Options.QUIT);
        Menu start_menu = new Menu(start_options);
        Options user_selection = null;

        do {
            user_selection = start_menu.getOption();
            switch(user_selection){
                case A:
                    System.out.println(Options.A);
                    break;
                case B:
                    System.out.println(Options.B);
                    break;
                case C:
                    System.out.println(Options.C);
                    break;
                case QUIT:
                    System.out.println("Quiting program.");
                    break;
                default:
                    System.out.println(user_selection + " is not available.");
            }

        } while (user_selection != Options.QUIT);


    }

}
