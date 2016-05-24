/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author dwheadon
 */
public class Minesweeper extends Application{
    GridPane gameBoard = new GridPane();
    
    public Tile[][] gridArray = new Tile[10][10];
    
    private GridPane root;
    public Parent createGameBoard(){
       root = new GridPane();
       Insets insets = new Insets(0, 10, 0, 10);
        
       root.setHgap(10);
       root.setVgap(10);
       root.setPadding(insets);
      
        //add tiles to the gridpane
       for(int x = 0; x < 10; x++){
        for(int y = 0; y < 10; y++){   
           Tile newTile = new Tile(x, y, Math.random() <= 0.23);
           newTile.setOnAction(newTile);
           gridArray[x][y] = newTile;
           root.add(newTile, x, y);
        }
       }
       /*
       for(int i =0; i<10; i++){
           for(int h=0; h<10; h++){
               //put the numbers in the designated tiles
               //for later sprint
           }
       }
       */
       return root; 
    }
    /*
    
    public int getAdjacentBombs(Tile t){ 
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
            int actualX = this.getX()  + tempX;
            int actualY = this.getY() + tempY;
            
            //make sure that the size doesn't go past the gridspace
            if(actualX >= 0 && actualX <= gridArray.size() ){
                
                
            }
        }
    }    
    */
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        
        Scene scene = new Scene(createGameBoard());
        stage.setScene(scene);
        stage.show();
        
        /*    
        for(int i = 0; i++; i < 10){
            for(int k = 0; k++; k < 10){
                gameBoard.add(new Button(), i, k);
            }
        }
        */
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
