package Bussines;

import Presentation.MenuOptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The type Console ui manager.
 */
public class ConsoleUIManager {
    private final Scanner scanner;

    /**
     * Instantiates a new Console ui manager.
     */
    public ConsoleUIManager() {
        scanner = new Scanner(System.in);
    }
    private static final String ENTER_OPTION = "Enter an option: ";
    private static final String MAIN_MENU_MESSAGE =
            "The tavern keeper looks at you and says:\n" +
            "“Welcome adventurer! How can I help you?”\n" +
            "\t1) Character creation\n" +
            "\t2) List characters\n" +
            "\t3) Create an adventure\n" +
            "\t4) Start an adventure\n" +
            "\t5) Exit\n";
    private static final String MAIN_MESSAGE =

             "  ____ _                __       __    ____ ___   ___   _____\n" +
             " / __/(_) __     ___   / /___   / /   / __// _ \\ / _ \\ / ___/\n" +
             " _\\ \\ / // ' \\  / _ \\ / // -_) / /__ _\\ \\ / , _// ___// (_ /\n" +
             "/___//_//_/_/_// .__//_/ \\__//____//___/ /_/|_|/_/    \\___/\n" +
             "              /_/ \t\t\t\tlaSalle engineer experience pack!\n" +
             "\nWelcome to Simple LSRPG.\n";
    private static final String LOAD_DATA_MESSAGE = "Loading data...";
    private static final String LOAD_DATA_SUCCESFULL = "Data was successfully loaded.";
    private static final String ERROR_WRONG_OPTION = "Error, the entered option is not a valid option.";

    /**
     * Persistance passed.
     */
    public void persistancePassed() {
        System.out.println(MAIN_MESSAGE);
        System.out.println(LOAD_DATA_MESSAGE);
        System.out.println(LOAD_DATA_SUCCESFULL);
    }

    /**
     * Start menu menu options.
     *
     * @return the menu options
     */
    public MenuOptions startMenu() {
        do {
            System.out.println();
            System.out.println(MAIN_MENU_MESSAGE);
            System.out.print(ENTER_OPTION);

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1: return MenuOptions.CREATE_CHRACTER;
                    case 2: return MenuOptions.LIST_CHARACTERS;
                    case 3: return MenuOptions.CREATE_ADVENTURE;
                    case 4: return MenuOptions.START_ADVENTURE;
                    case 5: return MenuOptions.EXIT;
                    default: System.out.println(ERROR_WRONG_OPTION);
                }

            } catch (NumberFormatException e) {
                System.out.println(ERROR_WRONG_OPTION);
            }
        } while(true);
    }
    private static  final String MENU_LIST_CHARACTERS = "\nTavern keeper: “Lads! The Boss wants to see you, come here!”\n";
    private static final String ASK_FILTER = "“Who piques your interest?”\n" + "\n-> Enter the name of the Player to filter: ";

    private static final String CHOSE_CHARACTER = "\nYou watch as some adventurers get up from their chairs and approach you.\n";

    /**
     * Gets levenshtein distance.
     *
     * @param X the x
     * @param Y the y
     * @return the levenshtein distance
     */
    public static int getLevenshteinDistance(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }

        return T[m][n];
    }

    /**
     * Find similarity double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public static double findSimilarity(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        double maxLength = Double.max(x.length(), y.length());
        if (maxLength > 0) {
            // optionally ignore case if needed
            return (maxLength - getLevenshteinDistance(x, y)) / maxLength;
        }
        return 1.0;
    }
    private List<Character> filterCharacters(List<Character> characters, String filter) {
        ArrayList<Character> list = new ArrayList<Character>();

        if (filter.equals("")) {
            list.addAll(characters);
        } else {
            int i = 0;
            for (Character character : characters) {
                double similarity = findSimilarity(character.getName().toLowerCase(), filter);
                if (similarity > 0) {
                    list.add(character);
                    i++;
                }
            }

        }

        return list;
    }

    /**
     * List character.
     *
     * @param characters list of characters
     */
    public void listCharacter(List<Character> characters) {;
        boolean exit = true;

        System.out.print(MENU_LIST_CHARACTERS);

        while(exit) {
            int i = 1;

            System.out.print(ASK_FILTER);
            String filter = scanner.nextLine();
            List<Character> filteredCharacters = filterCharacters(characters, filter);

            for (Character character : filteredCharacters) {
                System.out.print("\n" + i + "." + " " + character.getName());
                i++;
            }
            System.out.println("\n\n0. Back");

            int option = characterSelection(i);

            switch (option) {
                case 0:
                    System.out.print("\nTavern keeper: “Traveler, I will ask you once again“");
                    scanner.nextLine();
                    System.out.println();
                    break;

                default:
                    prettyPrintCharacters(filteredCharacters, option);
                    exit = false;
                    break;
            }
        }
    }
    private int characterSelection(int cantidad) {
        int option = 0;
        boolean exit = true;

        System.out.println("\nYou watch as some adventurers get up from their chairs and approach you.");

        while(exit) {
            System.out.print("Who would you like to meet [0.." + (cantidad - 1) + "]: ");

            try {
                option = scanner.nextInt();
                exit = false;
            } catch (InputMismatchException e) {
                System.out.println("\nTavern keeper: “I didn't understand that foreign language. Repeat!“");
                scanner.nextLine();
            }
        }

        return option;
    }

    /**
     * Pretty print characters.
     *
     * @param filteredCharacters the filtered characters
     * @param position           the position
     */
    public void prettyPrintCharacters (List<Character> filteredCharacters, int position) {
        Character character = null;

        for (int i = 0; i < filteredCharacters.size(); i++) {
            if (i == (position - 1)) {
                character = filteredCharacters.get(i);
            }
        }

        String info = character.toString();
        String delimSpace = "-";
        String[] result = info.split("-");

        String name = result[0];

        System.out.println("\nTavern keeper: “Hey " + name + " get here the boss wants to see you!”\n");

        //Este códgio esta pensado para un formato en específico de json
        System.out.println("* Name:\t\t" + result[0]);
        System.out.println("* Player:\t" + result[1]);
        System.out.println("* Class:\t" + result[2]);
        System.out.println("* Level:\t" + result[3]);
        System.out.println("* XP:\t\t" + result[4]);
        System.out.println("* Body:\t\t" + result[5]);
        System.out.println("* Mind:\t\t" + result[6]);
        System.out.println("* Spirit:\t" + result[7]);
    }
    // Constant used in the next method
    private static final String ENTER_FIELD_MESSAGE = "Enter the field's name: ";

    /**
     * Method that promts the user to enter a field's name.
     *
     * @return a string representation of a field's name
     */
    public String requestField() {
        System.out.print(ENTER_FIELD_MESSAGE);
        return scanner.nextLine();
    }
    private static final String EXIT_MESSAGE = "Tavern keeper: “Are you leaving already? See you soon, adventurer.”";

    /**
     * Show exit message.
     */
    public void showExitMessage() {
        System.out.println();
        System.out.println(EXIT_MESSAGE);
    }

    /**
     * Clear buffer.
     */
    public void clearBuffer() {
        scanner.nextLine();
    }
}
