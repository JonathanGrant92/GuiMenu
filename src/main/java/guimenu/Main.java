package main.java.guimenu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        runStartMenu();
    }

    private static void runStartMenu() {
        EnumSet<Options> start_options = EnumSet.of(Options.A, Options.B, Options.C, Options.QUIT);
        Menu start_menu = new Menu(start_options);
        Options user_selection;

        do {
            user_selection = start_menu.getOption();

            switch(user_selection){
                case A:
                    System.out.println(Options.A + " is always good.");
                    break;
                case B:
                    System.out.println(Options.B + " is displaying the second menu. Hold on!");
                    runFormMenu();
                    break;
                case C:
                    System.out.println(Options.C + " demands your input.");
                    ArrayList<String> requested_info = new ArrayList<>();
                    requested_info.add("Address :");
                    requested_info.add("Aspiration :");
                    requested_info.add("Life Story :");
                    ArrayList<String> answers = start_menu.runTextReader(Options.C, requested_info);

                    System.out.println("Your responses: ");
                    for (String answer : answers) {
                        System.out.println("\t" + answer);
                    }

                    break;
                case QUIT:
                    start_menu.closeMenu();
                    System.out.println("Quiting program.");
                    break;
                default:
                    System.out.println(user_selection + " is not available.");
            }

        } while (user_selection != Options.QUIT);

    }

    private static void runFormMenu() {
        EnumSet<Options> start_options = EnumSet.of(Options.A1, Options.B1, Options.C1, Options.CLOSE);
        Menu form_menu = new Menu(start_options);
        Options user_selection;

        do {
            user_selection = form_menu.getOption();

            switch (user_selection) {
                case A1:
                    System.out.println(Options.A1);
                    break;

                case B1:
                    System.out.println(Options.B1);
                    break;

                case C1:
                    System.out.println(Options.C + " demands your input.");
                    ArrayList<String> requested_info = new ArrayList<>();
                    requested_info.add("Pet's name:");
                    requested_info.add("Car: ");
                    requested_info.add("Bank Pin: ");
                    ArrayList<String> answers = form_menu.runTextReader(Options.C, requested_info);

                    System.out.println("Your responses are: ");
                    for (String answer : answers) {
                        System.out.println("\t" + answer);
                    }
                    System.out.println(Options.C1);
                    break;

                case CLOSE:
                    form_menu.closeMenu();
                    System.out.println("Does " + user_selection + " equal " + Options.CLOSE);
                    break;

                default:
                    System.out.println(user_selection + " is not available.");
            }

        } while (user_selection != Options.CLOSE);

    }

}
