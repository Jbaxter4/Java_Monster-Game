/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Baxte
 */
public class Stone extends Entity{
    
    public Stone(int x, int y){
        super(x,y);
        setSymbol('S');
        setType("Stone");
    }
    
    @Override
    public void move(Room r) {
    }    
}