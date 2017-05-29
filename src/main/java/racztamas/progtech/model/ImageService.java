/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import static racztamas.progtech.controller.FXMLController.xmlWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author toti
 */
public class ImageService {

    Random rand = new Random();

    List<Modell> tmp = new ArrayList<>();

    public void generate(String[] guess) {

        switch (model.getColor()) {
            case "redbutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "bluebutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "orangebutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "yellowbutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "brownbutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "blackbutton": {
                guess[model.getCol()] = model.getColor();
                break;
            }
            case "greenbutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "whitebutton": {
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            default:
                break;
        }

    }

    public void setColors() {
        for (int e = 0; e < model.getColors().size(); e++) {
            Modell element = model.getColors().get(e);
            tmp.add(element);
        }

    }

    public void writer() {

        xmlWriter.writehelper();
        Modell element = model.getColors().get(0);
        tmp.add(element);
        model.setColors(tmp);
        xmlWriter.write();
    }

    public void removeFromList() {
        tmp.remove(model.getId());
        model.setColors(tmp);
        xmlWriter.write();
    }

    public void secrets(String[] secret) {
        int[] secretnum = new int[4];
        for (int b = 0; b < 4; b++) {

            secretnum[b] = rand.nextInt(8) + 1;

        }
        for (int a = 0; a < 4; a++) {
            switch (secretnum[a]) {
                case 1:
                    secret[a] = "redbutton";
                    break;

                case 2:
                    secret[a] = "greenbutton";
                    break;

                case 3:
                    secret[a] = "bluebutton";
                    break;

                case 4:
                    secret[a] = "blackbutton";
                    break;

                case 5:
                    secret[a] = "brownbutton";
                    break;

                case 6:
                    secret[a] = "yellowbutton";
                    break;

                case 7:
                    secret[a] = "whitebutton";
                    break;

                case 8:
                    secret[a] = "orangebutton";
                    break;
            }
        }
    }

    public void loadImages(Modell ez, String[] guess) {

        switch (model.getColor()) {
            case "redbutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "bluebutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "orangebutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "yellowbutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "brownbutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "blackbutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                break;
            }
            case "greenbutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            case "whitebutton": {
                model.setId(ez.getId());
                model.setCol(ez.getCol());
                model.setRow(ez.getRow());
                guess[model.getCol()] = model.getColor();
                model.setGuess(guess);
                break;
            }
            default:
                break;
        }

    }

}
