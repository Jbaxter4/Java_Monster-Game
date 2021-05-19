

/*
 * Abstract Class Entity
 * 
 */

package game;


/**
 *
 * @author Arantza
 */
public abstract class Entity {
 private char symbol; // symbol that represents the entity
 private String type; // every entity is of a type 
 private int xcord, ycord;
 
    public Entity (int x, int y) {   
       xcord = x;
       ycord= y;
       type = "entity";       
       this.symbol = symbol;
    }
    
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char c) {
        symbol = c;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getX() {
        return xcord;
    }

    public int getY() {
        return ycord;
    }
    
    public void setX (int newx) {
       this.xcord=newx;
    }

    public void setY (int newy) {
       this.ycord=newy;
    }

 /**
  * 
  * @param r the room with the positions of all the entities
  * abstract method that moves the entity according to the rules of the game
  */
 public abstract void move(Room r);
    
/**
 * 
 * @return string with information about an abstract entity 
 */
   public String toString() {        
       String s =  "Entity properties:\nType: "  + type;
       return s;
   }
   
   public String fileString() {
       String fs = type + " " + xcord + " " + ycord;
       return fs;
   }
}