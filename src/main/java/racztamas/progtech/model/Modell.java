/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toti
 */
public class Modell {
    
    private int id;
    private String[] secret;
    private String[] guess;
    private int row;
    private int col;
    private String color;
    private int whitepin;
    private int blackpin;
    private boolean win = false;
    private boolean lose = false;
    private List<Modell> colors = new ArrayList<>();

    public Modell(int id, String[] secret, String[] guess, int row, int col, String color, int whitepin, int blackpin) {
        this.id = id;
        this.secret = secret;
        this.guess = guess;
        this.row = row;
        this.col = col;
        this.color = color;
        this.whitepin = whitepin;
        this.blackpin = blackpin;
    }
    
    public Modell() {
       secret = new String[4];
       guess = new String[4];
       row = 9;
       col=0;
       id = -1;
       colors.clear();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String[] getSecret() {
        return secret;
    }

    public void setSecret(String[] secret) {
        this.secret = secret;
    }

    public String[] getGuess() {
        return guess;
    }

    public void setGuess(String[] guess) {
        this.guess = guess;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWhitepin() {
        return whitepin;
    }

    public void setWhitepin(int whitepin) {
        this.whitepin = whitepin;
    }

    public int getBlackpin() {
        return blackpin;
    }

    public void setBlackpin(int blackpin) {
        this.blackpin = blackpin;
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public List<Modell> getColors() {
        return colors;
    }

    public void setColors(List<Modell> colors) {
        this.colors = colors;
    }
    
    

}
