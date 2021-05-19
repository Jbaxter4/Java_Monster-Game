package game;

/*
 * Class that stores the positions of all the entities
 * Methods to add entities, display the room, display information are not implemented
 */
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

/**
 *
 * @author Arantza
 */
public class Room {
    // List with all the entities    

    private ArrayList<Entity> entities = new ArrayList<Entity>();

    /**
     * Set up a new room with entities in random places first the room, must be
     * clear of entities
     */
    public void resetRoom() {
        clearRoom();
        createEntities();
    }

    public void createEntities() {
        int xCord, yCord, strength, hole;
        Random rand = new Random();
//Humans
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Human(xCord, yCord, "Harold"));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Human(xCord, yCord, "David"));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Human(xCord, yCord, "Clare"));
//Monsters
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
            strength = rand.nextInt(6);
        } while (!isFree(xCord, yCord));
        entities.add(new Monster(xCord, yCord, strength));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
            strength = rand.nextInt(6);
        } while (!isFree(xCord, yCord));
        entities.add(new Monster(xCord, yCord, strength));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
            strength = rand.nextInt(6);
        } while (!isFree(xCord, yCord));
        entities.add(new Monster(xCord, yCord, strength));
        //Dragons
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Dragon(xCord, yCord, true));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Dragon(xCord, yCord, false));
//Stones
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Stone(xCord, yCord));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
        } while (!isFree(xCord, yCord));
        entities.add(new Stone(xCord, yCord));
//Holes
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
            hole = rand.nextInt(21);
        } while (!isFree(xCord, yCord));
        entities.add(new Hole(xCord, yCord, hole));
        do {
            xCord = rand.nextInt(10);
            yCord = rand.nextInt(10);
            hole = rand.nextInt(21);
        } while (!isFree(xCord, yCord));
        entities.add(new Hole(xCord, yCord, hole));
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * Empty the list and add new entities
     */
    public void clearRoom() {
        entities.clear();
    }

    /**
     * Method that tell us if a cell is occupied by an entity
     *
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return true is cell free
     */
    public boolean isFree(int x, int y) {
        if (x > 9 || y > 9 || x < 0 || y < 0) {
            return false;
        }
        for (Entity a : entities) {
            if (a.getX() == x && a.getY() == y) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that returns the position in the arrayList occupied by an entity
     * given its coordinates
     *
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return position in the list or -1 if the cell is free
     */
    private int getPosition(int x, int y) {
        for (Entity a : entities) {
            if (a.getX() == x && a.getY() == y) {
                return entities.indexOf(a);
            }
        }
        return -1;
    }

    /**
     * Display all the properties of an entity that occupies a particular cell
     * PRE: Cell must not be empty
     *
     * @param x row 0<= x <=9
     * @param y column 0<=y<=9
     * @return String with the properties of the entity or
     *
     */
    public String displayEntity(int x, int y) {
        for (Entity a : entities) {
            if (a.getX() == x && a.getY() == y) {
                return (a.toString());
            }
        }
        return ("");
    }

    /**
     * method that moves all the entities that are animated on the room
     */
    public void move() {
        for (Entity e : entities) {
            e.move(this);                    
        }
    }

    /**
     * method that return string used to display the room as specified
     */
    public String toString() {
        String st = " 0123456789\n";
        for (int i = 0; i < 10; i++) {
            st += i;
            for (int j = 0; j < 10; j++) {
                st += getSymbol(j, i);
            }
            st += "\n";
        }
        return st;
    }

    public char getSymbol(int x, int y) {
        for (Entity a : entities) {
            if (a.getX() == x && a.getY() == y) {
                return a.getSymbol();
            }
        }
        return '.';
    }

    /**
     * Method for version 1 that clears the room and creates a new list with the
     * entities read in a text file
     *
     * @throws FileNotFoundException
     */
    public void loadEntities() throws FileNotFoundException {
        clearRoom();
        FileInputStream load = new FileInputStream("game.txt");
        Scanner scan = new Scanner(load);
        while (scan.hasNext()){
            String name, first;
            int xcord, ycord, health, depth, strength;
            boolean flight;
            first = scan.next();
            if (first.equals("Human")){
                xcord = scan.nextInt();
                ycord = scan.nextInt();
                health = scan.nextInt();
                name = scan.next();
                Human h = new Human(xcord, ycord, name);
                h.setHealth(health);
                entities.add(h);
            }
            if (first.equals("Monster")){
                xcord = scan.nextInt();
                ycord = scan.nextInt();
                health = scan.nextInt();
                strength = scan.nextInt();
                Monster m = new Monster(xcord, ycord, strength);
                m.setHealth(health);
                entities.add(m);
            }
            if (first.equals("Dragon")){
                xcord = scan.nextInt();
                ycord = scan.nextInt();
                health = scan.nextInt();
                flight = scan.hasNextBoolean();
                Dragon d = new Dragon(xcord, ycord, flight);
                d.setHealth(health);
                entities.add(d);
            }
            if (first.equals("Hole")){
                xcord = scan.nextInt();
                ycord = scan.nextInt();
                depth = scan.nextInt();
                Hole q = new Hole(xcord, ycord, depth);
                entities.add(q);
            } 
            if (first.equals("Stone")){
                xcord = scan.nextInt();
                ycord = scan.nextInt();
                Stone s = new Stone(xcord, ycord);
                entities.add(s);
            } 
        }        
    }

    /**
     * Version 2 methods that saves the entities and their positions into a text
     * file
     *
     * @throws FileNotFoundException
     */
    public void saveEntities() throws FileNotFoundException {
        PrintWriter file = new PrintWriter("game.txt");
        for (Entity a :entities){
            file.println (a.fileString());
        }
        file.close();
    }
}
