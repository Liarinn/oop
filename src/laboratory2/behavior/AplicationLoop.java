package laboratory2.behavior;

import java.io.IOException;
import java.util.Scanner;

public class AplicationLoop extends Thread{
public static final String MAIN_MENU = """

                Hy, what would you like to do?
                You can choose:
                commit
                status
                info<filename>
                quit
                
                >\s""";

    String command;
    public  void run(){
        try {
            this.runCommands();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void runCommands() throws IOException {

        while (true) {
            Commands commands = new Commands();
            Scanner scanner = new Scanner(System.in);
            this.command = scanner.nextLine();

            switch (command) {
                case "commit" -> Commands.commit();
                case "status" -> commands.status();
                case "quit" -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> {
                    String [] commandTokens = command.split(" ");
                    if (commandTokens.length != 2 ){
                        System.out.println("Introduced wrong command");
                    }else if(!commandTokens[0].equals("info")){
                        System.out.println("Introduced wrong command");
                    }else {
                        String filename = commandTokens[1];
                        commands.displayInfo(filename);
                    }
                }

            }
        }
    }
}
