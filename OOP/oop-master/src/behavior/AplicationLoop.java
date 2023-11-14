package behavior;

import java.util.Scanner;

public class AplicationLoop {

    static final AplicationLoop generalManager = new AplicationLoop();
    static final Scanner myInput = new Scanner(System.in);
    public static void run() {

        while (true) {
            displayMainMenu();

            String choiceInput = myInput.nextLine().trim();
            Commands commands = new Commands();
            switch (choiceInput) {
                case "commit":

                    break;
                case "status":

                    break;
                case "quit":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
           // System.out.println(choiceInput);
        }
    }
    private static void displayMainMenu() {
        System.out.print("""

                Hy, what would you like to do?
                You can choose:
                commit
                status
                info<filename>
                quit
                
                >\s""");
    }
}
