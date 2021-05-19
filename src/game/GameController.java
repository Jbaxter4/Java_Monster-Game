/*
 * Main template class with the menu with all the options
 * 
 */
package game;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Arantza
 */
public class GameController { 

    static void menu() {

        System.out.println("Enter an option");
        System.out.println(" 1: Display level");
        System.out.println(" 2: Move animated entities");
        System.out.println(" 3: Display the properties of an entity");
        System.out.println(" 4: Reset the room");
        System.out.println(" 5: Save the room");
        System.out.println(" 6: Load saved room");
        System.out.println(" 0: Exit");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {        

        Room mwRoom = new Room();        
        mwRoom.createEntities();

        System.out.println("Initialise the room here");

        Scanner kb = new Scanner(System.in);
        int option;

        do {
            menu();
            option = kb.nextInt();
            kb.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Option to display room");
                    System.out.println(mwRoom.toString());
                    break;
                case 2:
                    System.out.println(" Option to move all the animated entities ");
                    mwRoom.move();
                    break;
                case 3:
                    System.out.println(" Enter the position of the entity that you want to display ");
                    System.out.println("Enter x Coordinate: ");
                    int x = kb.nextInt();
                    System.out.println("Enter y Coordinate: ");
                    int y = kb.nextInt();
                    System.out.println(mwRoom.displayEntity(x, y));
                    break;
                case 4:
                    System.out.println("Option to reset the room:");
                    mwRoom.resetRoom();
                    break;
                case 5:
                    System.out.println("Game Saved");
                    mwRoom.saveEntities();
                    break;    
                case 6:
                    System.out.println("Game Loaded");
                    mwRoom.loadEntities();
                    break;
                case 0:
                    System.out.println(" Good bye");
                    break;
                default:
                    System.out.println("Sorry wrong option");
            }
        } while (option != 0);

    }
}
