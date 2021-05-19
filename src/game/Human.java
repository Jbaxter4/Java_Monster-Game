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
public class Human extends Entity {

    private String name;
    private int health;

    public Human(int x, int y, String n) {
        super(x, y);
        setSymbol('@');
        setType("Human");
        name = n;
        health = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHealth: " + getHealth() + "\nName: " + getName();
    }
    
    @Override
    public String fileString() {
        return super.fileString() + " " + getHealth() + " " + getName();
    }

    @Override
    public void move(Room r) {
        Random rand = new Random();
        int x, y, currentX, currentY, h;
        h = getHealth();
        if (h >= 0) {
            x = getX() + 1;
            y = getY();
            if (r.isFree(x, y)) {
                setX(x);
                h--;
                setHealth(h);
            } else {
                do {
                    currentX = getX();
                    currentY = getY();
                    x = currentX + (rand.nextInt(3) - 1);
                    y = currentY + (rand.nextInt(3) - 1);
                } while (!r.isFree(x, y));
                setX(x);
                setY(y);
                h--;
                setHealth(h);
            }
        }
    }
}
