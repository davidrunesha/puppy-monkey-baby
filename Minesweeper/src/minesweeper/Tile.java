/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.event.MouseEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Jacob Shkrob
 */
public class Tile {
    public int X_POSITION;
    public int Y_POSITION;
    public boolean hasBomb;
    public int adjacentBombs;
    
    public Tile(boolean hasB){
        hasBomb = hasB;
    }
    
    public void getOnMouseClicked(){
        if(this.ifBomb()){
            //display bomb
            //end game
        } else{
            if(this.adjacentBombs() != 0){
                //display number of adjacent bombs
            }
        }
        //display nothing
    }
    
   
    
    public int adjacentBombs(){
        
        return adjacentBombs;
    }
    
    public int getX(){
        return X_POSITION;
    }
    
    public int getY(){
        return Y_POSITION;
    }
    
    public boolean ifBomb(){
        return hasBomb;
    }
}
