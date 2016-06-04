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
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author Jacob Shkrob
 */
public class Tile extends Button implements EventHandler<MouseEvent>{
    private int x, y;
    public boolean hasBomb;
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
                if(this.hasFlag == false){
                    this.setGraphic(new ImageView(bombImage));
                    
                    //reveal all the other bombs
                    SettingsPanelController.revealAllBombs(this.getX(), this.getY());
                    //System.out.println("YOU LOSE");
                    JOptionPane.showMessageDialog(null, "You Lose");
                
                    
                }
            }else{
                if(this.hasFlag == false){
                    adjacentBombs = SettingsPanelController.getAdjacentBombs(this);
                    //this.setFont(Font.font(14));
                    this.setStyle("-fx-font: 14 arial; -fx-base: #d8d8d8;");
                    if (adjacentBombs == 0) {
                        SettingsPanelController.clearZeros(this);
                    }
                //System.out.println("I left clicked");
                }
            }
            if(SettingsPanelController.numNotBombTiles == 0){
                JOptionPane.showMessageDialog(null, "You Win!");
            }
            
        }    
        //for right clicking
        if(b == MouseButton.SECONDARY){
                if(!this.hasFlag){
                    if(!this.beenSearched){ 
                        if(SettingsPanelController.NUM_FLAGS > 0){
                            this.setGraphic(new ImageView(flagImage));
                            this.hasFlag = true;
                            SettingsPanelController.NUM_FLAGS--;
                        }
                    } 
                }else if(this.hasFlag){
                    if(!this.beenSearched){
                        this.setGraphic(new ImageView((Image) null));
                        this.hasFlag = false;
                        SettingsPanelController.NUM_FLAGS++;
                    }
        
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
2. Restart button
    a. Should be located either on the gameboard or on a different scene
    b. basically just restart the game 
3. You Loose/ You Win messages
4. Bomb number adjuster
    a. specifies the number of bombs someone wants in the game
5. Flag # show-er
ALSO

we should lock the size of each board so that it doesn't adjust
*/