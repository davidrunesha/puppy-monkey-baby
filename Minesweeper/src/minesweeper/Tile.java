/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author Jacob Shkrob
 */
public class Tile extends Button implements EventHandler<ActionEvent> {
    private int x, y;
    private boolean hasBomb;
    private int adjacentBombs;
    private Text text = new Text();
    
    
    public Tile(int x, int y, boolean hasBomb){
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
    }
    
    @Override
    public void handle(ActionEvent e){
        System.out.println("Hello world");
    }
    /*
    @Override
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
    */
    
   
    //will do in later sprint isn't necessary
    public int adjacentBombs(){
        
        return adjacentBombs;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean ifBomb(){
        return hasBomb;
    }
}
