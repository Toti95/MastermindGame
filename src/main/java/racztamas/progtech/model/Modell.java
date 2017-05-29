package racztamas.progtech.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@code Modell} osztály, a program működéséhez szükséges adatok modellje.
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
    private boolean exists = false;

    /**
     * A {@code Modell} osztály konstruktora.
     *
     * @param id az adott játékmenetben az adott szín egyedi azonosítója
     * @param secret az adott játékmenetben, a titkos színeket tartalmazó tömb
     * @param guess az adott játékmenetben, a tippeket tartalmazó tömb
     * @param row az adott játékmenetben, az adott sor száma
     * @param col az adott játékmenetben, az adott oszlop száma
     * @param color a játékos által válaszott szín
     * @param whitepin az adott körben hány színt talált el a játékos
     * @param blackpin az adott körben hány szín és pozíció egyezik meg
     */
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

    /**
     * Konstruktor, ami beállítja az alap értékeket.
     */
    public Modell() {
        secret = new String[4];
        guess = new String[4];
        row = 9;
        col = 0;
        id = -1;
        colors.clear();
    }

    /**
     * Visszaadja az egyedi azonosító értékét.
     *
     * @return az egyedi azonosító értéke
     */
    public int getId() {
        return id;
    }

    /**
     * Beállítja az egyedi azonosító értékét.
     *
     * @param id egyedi azonosító értéke
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Visszaadja a titkos színek tömbjét.
     *
     * @return a titkos színek
     */
    public String[] getSecret() {
        return secret;
    }

    /**
     * Beállítja a titkos színek tömbjét.
     *
     * @param secret a titkos színek
     */
    public void setSecret(String[] secret) {
        this.secret = secret;
    }

    /**
     * Visszadja a játékos által választott színek tömbjét.
     *
     * @return a játékos által választott színek
     */
    public String[] getGuess() {
        return guess;
    }

    /**
     * Beállítja a tömböt, a játékos által választott színek szerint.
     *
     * @param guess a választott színek
     */
    public void setGuess(String[] guess) {
        this.guess = guess;
    }

    /**
     * Visszaadja a sor értékét.
     *
     * @return a sor értéke
     */
    public int getRow() {
        return row;
    }

    /**
     * Beállítja a sor értékét a paraméterül kapott értékre.
     *
     * @param row a sor értéke
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Visszaadja az oszlop értékét.
     *
     * @return az oszlop értéke
     */
    public int getCol() {
        return col;
    }

    /**
     * Beállítja az oszlop értékét a paraméterül kapott értékre.
     *
     * @param col az oszlop értéke
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Visszakapja a színt.
     *
     * @return a szín
     */
    public String getColor() {
        return color;
    }

    /**
     * Beállítja a színt.
     *
     * @param color a szín
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Visszakapja a fehér tűk számát.
     *
     * @return fehér tűk
     */
    public int getWhitepin() {
        return whitepin;
    }

    /**
     * Beállítja a fehér tűk számát.
     *
     * @param whitepin fehér tűk
     */
    public void setWhitepin(int whitepin) {
        this.whitepin = whitepin;
    }

    /**
     * Visszakapja a fekete tűk számát.
     *
     * @return fekete tűk
     */
    public int getBlackpin() {
        return blackpin;
    }

    /**
     * Beállítja a fekete tűk számát.
     *
     * @param blackpin fekete tűk
     */
    public void setBlackpin(int blackpin) {
        this.blackpin = blackpin;
    }

    /**
     * Visszakapja, hogy a játékban győzött e a játékos.
     *
     * @return igaz, ha nyert a játékos, hamis ha nem
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Beállítja, hogy győzött e a játékos.
     *
     * @param win igaz, ha nyert, hamis ha nem
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Visszakapja, hogy a játékban vesztett e a játékos.
     *
     * @return igaz, ha vesztett a játékos, hamis ha nem
     */
    public boolean isLose() {
        return lose;
    }

    /**
     * Beállítja, hogy a játékos vesztett e a játékban.
     *
     * @param lose igaz, ha vesztett, hamis ha nem
     */
    public void setLose(boolean lose) {
        this.lose = lose;
    }

    /**
     * Visszakapja a lista értékeit.
     *
     * @return a lista értékei
     */
    public List<Modell> getColors() {
        return colors;
    }

    /**
     * Beállítja a lista értékeit.
     *
     * @param colors az értékek listában
     */
    public void setColors(List<Modell> colors) {
        this.colors = colors;
    }

    /**
     * Visszakapja, hogy létezik e a fájl.
     *
     * @return igen, ha létezik, hamis ha nem
     */
    public boolean isExists() {
        return exists;
    }

    /**
     * Beállítja, hogy létezik e a fájl.
     *
     * @param exists igen, ha létezik, hamis ha nem
     */
    public void setExists(boolean exists) {
        this.exists = exists;
    }

}
