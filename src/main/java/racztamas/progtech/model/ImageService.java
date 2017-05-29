package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import static racztamas.progtech.controller.FXMLController.xmlWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Osztály a titkos színek, illetve a tippek eltárolására.
 *
 * @author toti
 */
public class ImageService {

    /**
     * A random osztály példányosítása.
     */
    Random rand = new Random();

    /**
     * Új lista létrehozása.
     */
    List<Modell> tmp = new ArrayList<>();

    /**
     * Eltárolja azokat a színeket, amelyeket a játékos tippeli, a {@code guess}
     * tömbbe.
     *
     * @param guess az a tömb, amiben a tippeket tároljuk
     */
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

    /**
     * Átadja a list értékeit egy ideiglenes listának.
     */
    public void setColors() {
        for (int e = 0; e < model.getColors().size(); e++) {
            Modell element = model.getColors().get(e);
            tmp.add(element);
        }

    }

    /**
     * Az új golyót hozzáadja az ideiglenes listához, amit átad annak a
     * {@code Modell} listának, amelyiket az xml fájlba íratja.
     *
     * @throws ParserConfigurationException parser configuration exception
     * @throws TransformerException transformer exception
     */
    public void writer() throws ParserConfigurationException, TransformerException {

        xmlWriter.writehelper();
        Modell element = model.getColors().get(0);
        tmp.add(element);
        model.setColors(tmp);
        xmlWriter.write();
    }

    /**
     * Eltávolítja az adott id-val rendelkező lista elemet.
     *
     * @throws ParserConfigurationException parser configuration exception
     * @throws TransformerException transformer exception
     */
    public void removeFromList() throws ParserConfigurationException, TransformerException {
        tmp.remove(model.getId());
        model.setColors(tmp);
        xmlWriter.write();
    }

    /**
     * Véletlenszerűen legenerálja a titkos színeket.
     *
     * @param secret az a tömb, amiben a titkos színeket tárolja
     */
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

    /**
     * Az adott színnek megfelelően eltárolja a kiolvasott tippeket.
     *
     * @param ez az a lista amibe kiolvassuk a globális lista értékeit
     * @param guess az a tömb, amiben a tippeket tárolja
     */
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
