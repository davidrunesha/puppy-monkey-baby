/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import javafx.geometry.Insets;
import javafx.application.Application;
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
public class Minesweeper extends Application {
    GridPane gameBoard = new GridPane();
    
    
    
    public Parent createGameBoard(){
       GridPane root = new GridPane();
       Insets insets = new Insets(0, 10, 0, 10);
        
       root.setHgap(10);
       root.setVgap(10);
       root.setPadding(insets);
        
        //add tiles to the gridpane
       for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){   
           root.add(new Tile(true), i, j);
        }
       }
       return root; 
    }
    
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
