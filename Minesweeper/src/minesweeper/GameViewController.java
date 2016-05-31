/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temhhhplate file, choose Tools | Templates
 * and open the templafssate in the editor.
 */
package minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author dwheadon
 */
public class GameViewController implements Initializable {
    @FXML
    GridPane gameBoard = new GridPane();
    
    @FXML
    Button restartButton = new Button();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       //restart and make a new game
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            }
        }
        
     
    

