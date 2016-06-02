/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mattatassi
 */
public class SettingsPanelController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private ChoiceBox difficultyChoiceBox;
    @FXML
    private Slider numOfBombsSlider;
    
    //RESTART BUTTON
    @FXML
    private Button restartButton;
    
    Button restartButton1 = new Button();
    
    ObservableList<String> difficultyChoiceList = FXCollections.observableArrayList("Easy", "Intermediate", "Hard");
    
    GridPane gameBoard = new GridPane();
    
    //number of tiles in game
    public static int numOfTiles = 10;
    
    public double NUM_BOMBS_DOUBLE;
    
   
    //lel im lazy
    
    public static int NUM_FLAGS;
        
    //2-d array of tiles w/ width and height = numOfTiles
    public static Tile[][] gridArray = new Tile[0][0];
    
    Image smileImage = new Image(getClass().getResourceAsStream("smiley.png"));
    static Image repeatBombImage = new Image(SettingsPanelController.class.getResourceAsStream("bomb.png"));
        
    private GridPane root;
    public void findNumOfTiles(){
        if(difficultyChoiceBox.getValue().equals("Easy")){
            numOfTiles = 10;
        }
        if(difficultyChoiceBox.getValue().equals("Intermediate")){
            numOfTiles = 15;
        } 
        if(difficultyChoiceBox.getValue().equals("Hard")){
            numOfTiles = 20;
        }
    }
    
    public Parent createGameBoard(){
       root = new GridPane();
       Insets insets = new Insets(0, 10, 0, 10);
        
       root.setHgap(10);
       root.setVgap(10);
       root.setPadding(insets);
       
       this.findNumOfTiles();
       
       //changes the tile array size depending on the number of tiles
       gridArray = new Tile[numOfTiles][numOfTiles];
       
       int bombNumTrack = 0;
       //add tiles to the gridpane
       for(int x = 0; x < numOfTiles; x++){
        for(int y = 0; y < numOfTiles; y++){   
            Tile newTile = new Tile(x, y, Math.random() <= 0.15);
            newTile.setMinHeight(40.0);
            newTile.setMinWidth(40.0);
            newTile.setPrefHeight(40.0);
            newTile.setPrefWidth(40.0);
            newTile.setMaxHeight(40.0);
            newTile.setMaxWidth(40.0);
           
            newTile.beenSearched = false;
            newTile.hasFlag = false;
            newTile.setOnMouseClicked(newTile);
          
            gridArray[y][x] = newTile;
            root.add(newTile, x, y);
            bombNumTrack++;  
            /*
            if(bombNumTrack <= (int) NUM_BOMBS_DOUBLE){
                Tile newTile = new Tile(x, y, Math.random() <= 0.15);
                newTile.setMinHeight(40.0);
                newTile.setMinWidth(40.0);
                newTile.setPrefHeight(40.0);
                newTile.setPrefWidth(40.0);
                newTile.setMaxHeight(40.0);
                newTile.setMaxWidth(40.0);
           
                newTile.beenSearched = false;
                newTile.hasFlag = false;
                newTile.setOnMouseClicked(newTile);
          
                gridArray[y][x] = newTile;
                root.add(newTile, x, y);
                bombNumTrack++;
           } else if(bombNumTrack > NUM_BOMBS){
                Tile newTile = new Tile(x, y, false);
                newTile.setMinHeight(40.0);
                newTile.setMinWidth(40.0);
                newTile.setPrefHeight(40.0);
                newTile.setPrefWidth(40.0);
                newTile.setMaxHeight(40.0);
                newTile.setMaxWidth(40.0);
           
                newTile.beenSearched = false;
                newTile.hasFlag = false;
                newTile.setOnMouseClicked(newTile);
          
                gridArray[y][x] = newTile;
                root.add(newTile, x, y);
            */
           }
       }
       /*
       restartButton1.setLayoutX(numOfTiles + 3);
       restartButton1.setLayoutY(numOfTiles + 3);
       */
       restartButton1.setText("Restart");
       restartButton1.setFont(Font.font(14.0));
       restartButton1.setMinHeight(40.0);
       restartButton1.setMinWidth(40.0);
       restartButton1.setPrefHeight(40.0);
       restartButton1.setPrefWidth(40.0);
       restartButton1.setMaxHeight(40.0);
       restartButton1.setMaxWidth(40.0);
       
       restartButton1.setGraphic(new ImageView(smileImage));
       
       root.add(restartButton1, numOfTiles/2, numOfTiles); 
       //root.getChildren().add(restartButton1);
       
       
        
       //count number of bombs in the game board
       for(int i = 0; i < numOfTiles; i++){
           for(int j = 0; j < numOfTiles; j++){
               if(gridArray[j][i].ifBomb()){
                   NUM_FLAGS++;
               }
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
        tile.setText("" + numBombs);
        tile.setFont(Font.font(14));
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
    
    //reveals all bombs once they click a bomb
    public static void revealAllBombs(int X_SKIP, int Y_SKIP){
        for(int x = 0; x < numOfTiles; x++){
            for(int y = 0; y < numOfTiles; y++){
               if(gridArray[y][x].ifBomb()){
                   if (x == X_SKIP && y == Y_SKIP){
                   }else{
                       //gridArray[y][x].setText("X");
                       gridArray[y][x].setGraphic(new ImageView(repeatBombImage));
                   }
               } 
            }
        }
    }
    
    
    //FOR SETTINGS 
    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        //Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
        Scene GAME_BOARD_SCENE = new Scene(createGameBoard());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        stage.setScene(GAME_BOARD_SCENE);
        stage.show();
        
        restartButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){ 
                    Scene RESTARTED_GAME_BOARD_SCENE = new Scene(createGameBoard());
                    stage.setScene(RESTARTED_GAME_BOARD_SCENE);
                    stage.show();
            }        
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        difficultyChoiceBox.setItems(difficultyChoiceList);
        NUM_BOMBS_DOUBLE = numOfBombsSlider.getValue();
        
       
        
    }    
    
}
