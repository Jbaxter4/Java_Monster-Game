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
public class Monster extends Entity {

    private int health, strength;

    public Monster(int x, int y, int s) {
        super(x, y);
        setType("Monster");
        setSymbol('*');
        health = 100;
        strength = s;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int newStrength) {
        strength = newStrength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHealth: " + getHealth() + "\nStrength: " + getStrength();
    }
    
    @Override
    public String fileString() {
        return super.fileString() + " " + getHealth() + " " + getStrength();
    }

    @Override
    public void move(Room r) {
        Random rand = new Random();
        int x, y, currentX, currentY, h, s;
        h = getHealth();
        if (h >= 0 && strength > 0) {
            do {
                s = getStrength();
                currentX = getX();
                currentY = getY();
                x = 0;
                y = 0;
                int a = rand.nextInt(2);
                switch (a) {
                    case 0:
                        x = currentX + (s * (rand.nextInt(3) - 1));
                        y = currentY;
                        break;
                    case 1:
                        y = currentY + (s * (rand.nextInt(3) - 1));
                        x = currentX;
                        break;
                }
            } while (!r.isFree(x, y));
            setX(x);
            setY(y);
            h = h - s;
            setHealth(h);
        }
    }
}
