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
        if(b == MouseButton.SECONDARY){
            if(!this.hasFlag){
                this.setGraphic(new ImageView(flagImage));
                this.hasFlag = true;
            }
            if(this.hasFlag){
                //this.setGraphic(new ImageView());
                this.hasFlag = false;
            }
        }
    }
    //for a right click when flagging a tile
    
    
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
