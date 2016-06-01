/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

//import java.awt.Image;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Font;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
/**
 *
 * @author Jacob Shkrob
 */
public class Tile extends Button implements EventHandler<MouseEvent>{
    private int x, y;
    private boolean hasBomb;
    private int adjacentBombs;
    private String text;
    public boolean beenSearched = false;
    public boolean hasFlag = false;
    Image bombImage = new Image(getClass().getResourceAsStream("bomb.png"));
    Image flagImage = new Image(getClass().getResourceAsStream("flag.png"));
    
    public Tile(int x, int y, boolean hasBomb){
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
    }
    //for a left click when finding out tiles
    @Override
    public void handle(MouseEvent e){
        MouseButton b = e.getButton();
        if(b == MouseButton.PRIMARY){
            if(this.ifBomb()){
                this.setGraphic(new ImageView(bombImage));
            
                //reveal all the other bombs
                SettingsPanelController.revealAllBombs(this.getX(), this.getY());
                System.out.println("YOU LOSE");
                //System.exit(0);
            }else{
                adjacentBombs = SettingsPanelController.getAdjacentBombs(this);
                this.setFont(Font.font(14));
                if (adjacentBombs == 0) {
                    SettingsPanelController.clearZeros(this);
                }
                //System.out.println("I left clicked");
            }
        }    
        //for right clicking
        if(b == MouseButton.SECONDARY){
                if(!this.hasFlag){
                    if(SettingsPanelController.NUM_FLAGS > 0){
                        this.setGraphic(new ImageView(flagImage));
                        this.hasFlag = true;
                        SettingsPanelController.NUM_FLAGS--;
                    }
                }else if(this.hasFlag){
                    this.setGraphic(new ImageView((Image) null));
                    this.hasFlag = false;
                    SettingsPanelController.NUM_FLAGS++;
                }
        }
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



/*things to work on:
1. For flags:
    a. when you right click again, the flag should remove itself
    b. limit to the # of flags you can put down
2. Restart button
    a. Should be located either on the gameboard or on a different scene
    b. basically just restart the game 
3. You Loose/ You Win messages
4. Bomb number adjuster
    a. specifies the number of bombs someone wants in the game

ALSO

we should lock the size of each board so that it doesn't adjust
*/