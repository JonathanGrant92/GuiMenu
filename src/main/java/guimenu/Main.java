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

        start_menu.printMessage("Welcome to a GUI menu demonstration.");

        do {
            user_selection = start_menu.getOption();

            switch(user_selection){
                case A:
                    start_menu.printMessage(Options.A + " is always good.");
                    break;
                case B:
                    start_menu.printMessage(Options.B + " is displaying the second menu. Hold on!");
                    runFormMenu();
                    break;
                case C:
                    start_menu.printMessage(Options.C + " demands your input.");
                    ArrayList<String> requested_info = new ArrayList<>();
                    requested_info.add("Address :");
                    requested_info.add("Aspiration :");
                    requested_info.add("Life Story :");
                    ArrayList<String> answers = start_menu.runTextReader(Options.C, requested_info);

                    StringBuilder verify_response = new StringBuilder("Your responses: ");
                    for (String answer : answers) {
                        verify_response.append("\t").append(answer);
                    }
                    start_menu.printMessage(verify_response.toString());

                    break;
                case QUIT:
                    start_menu.closeMenu();
                    start_menu.printMessage("Quiting program.");
                    break;
                default:
                    start_menu.printMessage(user_selection + " is not available.");
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
                    form_menu.printMessage(String.valueOf(Options.A1));
                    break;

                case B1:
                    form_menu.printMessage(String.valueOf(Options.B1));
                    break;

                case C1:
                    form_menu.printMessage(Options.C + " demands your input.");
                    ArrayList<String> requested_info = new ArrayList<>();
                    requested_info.add("Pet's name:");
                    requested_info.add("Car: ");
                    requested_info.add("Bank Pin: ");
                    ArrayList<String> answers = form_menu.runTextReader(Options.C, requested_info);

                    StringBuilder verify_response = new StringBuilder("Your responses: ");
                    for (String answer : answers) {
                        verify_response.append("\t").append(answer);
                    }
                    form_menu.printMessage(String.valueOf(verify_response));
                    break;

                case CLOSE:
                    form_menu.closeMenu();
                    form_menu.printMessage("Does " + user_selection + " equal " + Options.CLOSE);
                    break;

                default:
                    form_menu.printMessage(user_selection + " is not available.");
            }

        } while (user_selection != Options.CLOSE);

    }

}
