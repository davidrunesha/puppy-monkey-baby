/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

//import java.awt.Image;
import javafx.scene.image.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Font;
import javax.swing.JButton;
/**
 *
 * @author Jacob Shkrob
 */
public class Tile extends Button implements EventHandler<ActionEvent> {
    private int x, y;
    private boolean hasBomb;
    private int adjacentBombs;
    private String text;
    public boolean beenSearched = false;
    Image bombImage = new Image(getClass().getResourceAsStream("bomb.png"));
    
    public Tile(int x, int y, boolean hasBomb){
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
    }
    
    @Override
    public void handle(ActionEvent e){
        if(this.ifBomb()){
            //text = "X";
            //this.setText(text);
            this.setGraphic(new ImageView(bombImage));
            
            //reveal all the other bombs
            SettingsPanelController.revealAllBombs(this.getX(), this.getY());
            System.out.println("YOU LOSE");
            //System.exit(0);
        }else{
            adjacentBombs = SettingsPanelController.getAdjacentBombs(this);
            text = "" + adjacentBombs;
            this.setText(text);
            this.setFont(Font.font(12));
            if (adjacentBombs == 0) {
                SettingsPanelController.clearZeros(this);
            }
        }
        //System.out.println("Hello world");
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
    /*public int adjacentBombs(){
        List<Tile> adjacentTiles = new ArrayList<Tile>();
        int[] surroundingCoordX = new int[] {
            -1, 
            -1,
            -1,
             0, 
             0,
             0,
             1, 
             1, 
             1
        };
        int[] surroundingCoordY = new int[] {
            -1,
            -1,
            -1,
            0,
            0,
            0,
            1,
            1,
            1
        };
        int surroundingTimes = surroundingCoordX.length; 
            //o o o
            //o X o
            //o o o
        for(int i=0; i<surroundingTimes; i++){
            int tempX = surroundingCoordX[i];
            int tempY = surroundingCoordY[i];
            //put it into representation
            int actualX = this.getX() + tempX;
            int actualY = this.getY() + tempY;
            
            //make sure that the size doesn't go past the gridspace
            if(actualX >= 0 && actualX <= gridArray.size())
        }
        
        return adjacentBombs;
    }
    */
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
