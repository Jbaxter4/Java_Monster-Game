/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *
 * @author Baxte
 */
public class Dragon extends Entity {

    private int health;
    private boolean flight;

    public Dragon(int x, int y, boolean f) {
        super(x, y);
        setType("Dragon");
        setSymbol('#');
        health = 100;
        flight = f;
    }

    public boolean getFlight() {
        return flight;
    }

    public void setFlight(boolean newFlight) {
        flight = newFlight;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCan Fly: " + getFlight() + "\nHealth: " + getHealth();
    }
    
    @Override
    public String fileString() {
        return super.fileString() + " " + getHealth() + " " + getFlight();
    }

    @Override
    public void move(Room r) {
        Random rand = new Random();
        int x, y, currentX, currentY, h;
        h = getHealth();
        if (h >= 0) {
            if (getFlight()) {
                do {
                    x = rand.nextInt(10);
                    y = rand.nextInt(10);
                } while (!r.isFree(x, y));
                setX(x);
                setY(y);
            } else {
                do {
                    currentX = getX();
                    currentY = getY();
                    x = currentX + rand.nextInt(3) - 1;
                    y = currentY + rand.nextInt(3) - 1;
                } while (!r.isFree(x, y));
                setX(x);
                setY(y);
                h--;
                setHealth(h);
            }
        }
    }
}
