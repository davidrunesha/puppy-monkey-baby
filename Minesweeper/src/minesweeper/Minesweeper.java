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
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        
        Scene scene = new Scene(root);
        
        GridPane gameBoard = new GridPane();
        Insets insets = new Insets(0, 10, 0, 10);
        
        gameBoard.setHgap(10);
        gameBoard.setVgap(10);
        gameBoard.setPadding(insets);
        
        
        //add tiles to the 
        /*
        for(int i = 0; i < 10; i++){
            for(int k = 0; k < 10; k++){
                gameBoard.add((new Tile(true)), i, k);
            }
        }
        */
        
        
        
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
