/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Jacob Shkrob
 */
public class Tile {
    public int X_POSITION;
    public int Y_POSITION;
    public boolean hasBomb;
    public int adjacentBombs;
    
    public Tile(int x, int y, boolean hasB){
        X_POSITION = x;
        Y_POSITION = y;
        hasBomb = hasB;
    }
    
    public int adjacentBombs(){
        return adjacentBombs;
    }
    
    public int getX(){
        return X_POSITION;
    }
    
    public int getY(){
        return Y_POSITION;
    }
    
    public boolean ifBomb(){
        return hasBomb;
    }
}
