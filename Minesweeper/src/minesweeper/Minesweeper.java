/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Author : David and Jacob and Mattt
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
    public static Tile[][] gridArray = new Tile[10][10];
    
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
    public static int getAdjacentBombs(Tile tile){ 
        int X_POS = tile.getX();
        int Y_POS = tile.getY();
       
        int numBombs = 0;
        
        for(int i =-1; i<2; i++){
            for(int k=-1; k < 2; k++){
                if(k != 0 && i != 0){
                    if(X_POS + i>=0 && X_POS + i <= gridArray.length && Y_POS + i>=0 && Y_POS + i <= gridArray.length){
                        if(gridArray[X_POS + i][Y_POS + k].ifBomb()){
                            numBombs = numBombs + 1;
                        }
                    }    
                }
            }
        }
        
        return numBombs;
    }    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        
        Scene scene = new Scene(createGameBoard());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
