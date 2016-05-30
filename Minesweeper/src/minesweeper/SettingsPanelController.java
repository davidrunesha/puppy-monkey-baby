/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mattatassi
 */
public class SettingsPanelController implements Initializable {
    private Button button;
    private ChoiceBox choB;
    
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
           Tile newTile = new Tile(x, y, Math.random() <= 0.15);
           newTile.beenSearched = false;
           newTile.setOnAction(newTile);
           gridArray[y][x] = newTile;
           root.add(newTile, x, y);
        }
       }
       return root; 
    }
    public static int getAdjacentBombs(Tile tile){ 
        
        int X_POS = tile.getX();
        int Y_POS = tile.getY();
        System.out.println("The Tile Corr: (" + X_POS + "," + Y_POS + ")");
        int numBombs = 0;
        
        for(int i =-1; i<2; i++){
            for(int k=-1; k < 2; k++){
                if(X_POS + i >= 0 && X_POS + i < gridArray.length && Y_POS + k >= 0 && Y_POS + k < gridArray.length){
                    if(gridArray[Y_POS + k][X_POS + i].ifBomb()){
                        numBombs++;
                    }
                }   
            }
        }
        tile.setText(numBombs+"");
        return numBombs;
    }    
        //FIX!
        //recursion: spreads out the 0 spaces 
    public static void clearZeros(Tile tile){   
        //start at the leftmost corner of the tile (w/ value 0) and check if it has adjacent bombs
        //base case = if the tile when coming backward has been searched            
        int X_POS = tile.getX();
        int Y_POS = tile.getY();
        for(int i =-1; i<2; i++){
            for(int k=-1; k<2;k++){
                if(X_POS + i >= 0 && X_POS + i < gridArray.length && Y_POS + k >= 0 && Y_POS + k < gridArray.length){
                    if(gridArray[Y_POS + k][X_POS + i].beenSearched == true){
                    }else{
                        tile.beenSearched = true;
                        int numBombs = SettingsPanelController.getAdjacentBombs(gridArray[Y_POS + k][X_POS + i]);
                        if(numBombs == 0){
                            SettingsPanelController.clearZeros(gridArray[Y_POS + k][X_POS + i]);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        Scene GAME_BOARD_SCENE = new Scene(createGameBoard());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        stage.setScene(GAME_BOARD_SCENE);
        stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
