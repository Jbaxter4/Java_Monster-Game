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
public class Hole extends Entity {
    int depth;
    
    public Hole(int x, int y, int d){
        super(x,y);
        depth = d;
        setType("Hole");
        setSymbol('O');
    }
    
    public int getDepth(){
        return depth;
    }    
    
    public void setDepth(int newDepth){
        depth = newDepth;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nDepth: " + getDepth();
    }
    
    @Override
    public String fileString() {
        return super.fileString() + " " + getDepth();
    }

    @Override
    public void move(Room r) {
    }  
}