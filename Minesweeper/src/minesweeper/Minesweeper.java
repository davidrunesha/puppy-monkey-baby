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
    @Override
    public void start(Stage stage) throws Exception {
        //the minesweeper board uses the GameView.fxml as the root
        Parent root = FXMLLoader.load(getClass().getResource("SettingsPanel.fxml"));
        //Scene scene = new Scene(createGameBoard());
        Scene scene = new Scene(root);
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
