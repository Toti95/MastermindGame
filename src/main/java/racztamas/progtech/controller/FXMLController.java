package racztamas.progtech.controller;

import racztamas.progtech.model.CounterService;
import racztamas.progtech.model.ImageService;
import racztamas.progtech.model.Modell;
import racztamas.progtech.model.ResultServices;
import racztamas.progtech.model.XmlReader;
import racztamas.progtech.model.XmlWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class FXMLController implements Initializable {

    /**
     * Logger variable.
     */
    final static Logger logger = LoggerFactory.getLogger(FXMLController.class);

    @FXML
    private Button redbutton;

    @FXML
    private Button bluebutton;

    @FXML
    private Button blackbutton;

    @FXML
    private Button whitebutton;

    @FXML
    private Button yellowbutton;

    @FXML
    private Button orangebutton;

    @FXML
    private Button greenbutton;

    @FXML
    private Button brownbutton;

    @FXML
    private Button back;

    @FXML
    private Button newgame;

    @FXML
    private Button giveup;

    @FXML
    private GridPane places;

    @FXML
    private GridPane firstPin;

    @FXML
    private GridPane secondPin;

    @FXML

    private GridPane thirdPin;
    @FXML

    private GridPane fourthPin;

    @FXML
    private GridPane fifthPin;

    @FXML
    private GridPane sixthPin;

    @FXML
    private GridPane seventhPin;

    @FXML
    private GridPane eighthPin;

    @FXML
    private GridPane ninthPin;

    @FXML
    private GridPane tenthPin;

    @FXML
    private ImageView hide;

    @FXML
    private GridPane secretcols;

    @FXML
    private Label label;

    @FXML
    private Button background;

    @FXML
    private Button mainmenu;

    @FXML
    private Button gamemenu;

    @FXML
    private Button quit;

    @FXML
    private Button loadgame;

    /*int i = 0;
    int j = 9;*/
    Image red = new Image(getClass().getResourceAsStream("/images/red.png"), 25, 25, false, false);
    Image black = new Image(getClass().getResourceAsStream("/images/black.png"), 25, 25, false, false);
    Image blue = new Image(getClass().getResourceAsStream("/images/blue.png"), 25, 25, false, false);
    Image white = new Image(getClass().getResourceAsStream("/images/white.png"), 25, 25, false, false);
    Image green = new Image(getClass().getResourceAsStream("/images/green.png"), 25, 25, false, false);
    Image orange = new Image(getClass().getResourceAsStream("/images/orange.png"), 25, 25, false, false);
    Image yellow = new Image(getClass().getResourceAsStream("/images/yellow.png"), 25, 25, false, false);
    Image brown = new Image(getClass().getResourceAsStream("/images/brown.png"), 25, 25, false, false);
    Image blackp = new Image(getClass().getResourceAsStream("/images/black.png"), 12, 12, false, false);
    Image whitep = new Image(getClass().getResourceAsStream("/images/white.png"), 12, 12, false, false);

    public static Modell model = new Modell();

    ResultServices resultServices = new ResultServices();

    String[] guess = model.getGuess();

    String[] secret = model.getSecret();

    public static ImageService img = new ImageService();

    XmlReader xmlReader = new XmlReader();

    public static XmlWriter xmlWriter = new XmlWriter();

    CounterService counterService = new CounterService();

    List<Modell> tmp = new ArrayList<>();

    @FXML
    private void handleButtonAction(ActionEvent event) throws ParserConfigurationException, TransformerException {

        counterService.IncrementId();

        try {

            if (event.getSource() == redbutton) {
                model.setColor("redbutton");
                places.add(new ImageView(red), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == bluebutton) {
                model.setColor("bluebutton");
                places.add(new ImageView(blue), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == blackbutton) {
                model.setColor("blackbutton");
                places.add(new ImageView(black), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == yellowbutton) {
                model.setColor("yellowbutton");
                places.add(new ImageView(yellow), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == whitebutton) {
                model.setColor("whitebutton");
                places.add(new ImageView(white), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == orangebutton) {
                model.setColor("orangebutton");
                places.add(new ImageView(orange), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == greenbutton) {
                model.setColor("greenbutton");
                places.add(new ImageView(green), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            } else if (event.getSource() == brownbutton) {
                model.setColor("brownbutton");
                places.add(new ImageView(brown), model.getCol(), model.getRow());
                img.writer();
                img.generate(guess);
            }
        } catch (IllegalArgumentException e) {
            logger.error("Negative encouneterd. Want to Continue");
        }

        logger.info("One color added.");

        counterService.IncrementCol();

        if (model.getCol() == 4) {

            resultServices.blackpins(guess, secret);
            resultServices.whitepins(guess, secret);

            switch (model.getRow()) {
                case 9:
                    pinner(firstPin);
                    break;
                case 8:
                    pinner(secondPin);
                    break;
                case 7:
                    pinner(thirdPin);
                    break;
                case 6:
                    pinner(fourthPin);
                    break;
                case 5:
                    pinner(fifthPin);
                    break;
                case 4:
                    pinner(sixthPin);
                    break;
                case 3:
                    pinner(seventhPin);
                    break;
                case 2:
                    pinner(eighthPin);
                    break;
                case 1:
                    pinner(ninthPin);
                    break;
                case 0:
                    pinner(tenthPin);

            }

            resultServices.win();

            if (model.isWin()) {
                label.setText("You win this game!");
                logger.info("The player won this game.");
                result();
            }
            counterService.ColToZero();
            counterService.DecrementRow();

        }

        resultServices.lose();
        if (model.isLose()) {
            label.setText("You lose this game!");
            logger.info("The player lost this game.");
            result();
        }

    }

    @FXML
    private void giveupButtonAction(ActionEvent event) {
        if (event.getSource() == giveup) {
            newgame.setVisible(true);
            hide.setVisible(false);
            mainmenu.setVisible(true);
            blackbutton.setVisible(false);
            redbutton.setVisible(false);
            yellowbutton.setVisible(false);
            whitebutton.setVisible(false);
            bluebutton.setVisible(false);
            greenbutton.setVisible(false);
            brownbutton.setVisible(false);
            orangebutton.setVisible(false);
            logger.info("The player gave up the game.");
        }
    }

    @FXML
    private void newgameButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        if (event.getSource() == newgame) {
            places.getChildren().clear();
            firstPin.getChildren().clear();
            secondPin.getChildren().clear();
            thirdPin.getChildren().clear();
            fourthPin.getChildren().clear();
            fifthPin.getChildren().clear();
            sixthPin.getChildren().clear();
            seventhPin.getChildren().clear();
            eighthPin.getChildren().clear();
            ninthPin.getChildren().clear();
            tenthPin.getChildren().clear();
            counterService.NewGame();
            newgame.setVisible(false);
            hide.setVisible(true);

            blackbutton.setVisible(true);
            redbutton.setVisible(true);
            yellowbutton.setVisible(true);
            whitebutton.setVisible(true);
            bluebutton.setVisible(true);
            greenbutton.setVisible(true);
            brownbutton.setVisible(true);
            orangebutton.setVisible(true);
            loadgame.setVisible(false);

            label.setVisible(false);
            background.setVisible(false);
            mainmenu.setVisible(false);

            logger.info("New game started.");
            img.secrets(secret);
            makeSecret();
            xmlWriter.writesecret(secret);

        }

        if (event.getSource() == back) {
            if (model.getCol() < 4 && model.getCol() > 0) {

                places.getChildren().remove(model.getId());
                img.removeFromList();
                counterService.DecrementId();
                counterService.DecrementCol();
                logger.info("Remove one element.");
            }
        }
        if (event.getSource() == loadgame) {

            xmlReader.readsecret(secret);
            makeSecret();

            xmlReader.read();
            if (model.isExists()) {
                loadgame.setVisible(false);
                newgame.setVisible(false);
                for (int m = 0; m < model.getColors().size(); m++) {
                    Modell ez = model.getColors().get(m);
                    tmp.add(ez);
                    img.setColors();
                    switch (ez.getColor()) {
                        case "redbutton":
                            model.setColor("redbutton");
                            places.add(new ImageView(red), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "bluebutton":
                            model.setColor("bluebutton");
                            places.add(new ImageView(blue), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "blackbutton":
                            model.setColor("blackbutton");
                            places.add(new ImageView(black), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "yellowbutton":
                            model.setColor("yellowbutton");
                            places.add(new ImageView(yellow), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "whitebutton":
                            model.setColor("whitebutton");
                            places.add(new ImageView(white), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "orangebutton":
                            model.setColor("orangebutton");
                            places.add(new ImageView(orange), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "greenbutton":
                            model.setColor("greenbutton");
                            places.add(new ImageView(green), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        case "brownbutton":
                            model.setColor("brownbutton");
                            places.add(new ImageView(brown), ez.getCol(), ez.getRow());
                            img.loadImages(ez, guess);
                            break;
                        default:
                            break;
                    }

                    if (m % 4 == 3) {
                        resultServices.blackpins(guess, secret);
                        resultServices.whitepins(guess, secret);
                        switch (model.getRow()) {
                            case 9:
                                pinner(firstPin);
                                break;
                            case 8:
                                pinner(secondPin);
                                break;
                            case 7:
                                pinner(thirdPin);
                                break;
                            case 6:
                                pinner(fourthPin);
                                break;
                            case 5:
                                pinner(fifthPin);
                                break;
                            case 4:
                                pinner(sixthPin);
                                break;
                            case 3:
                                pinner(seventhPin);
                                break;
                            case 2:
                                pinner(eighthPin);
                                break;
                            case 1:
                                pinner(ninthPin);
                                break;
                            case 0:
                                pinner(tenthPin);

                        }
                    }
                }
                if (model.getCol() == 3) {
                    counterService.DecrementRow();
                    counterService.ColToZero();
                } else {
                    counterService.IncrementCol();
                }
                counterService.IncrementId();
                logger.info("Old game state loaded.");
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void sceneChangeAction(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        if (event.getSource() == gamemenu) {
            stage = (Stage) gamemenu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (event.getSource() == mainmenu) {
            stage = (Stage) mainmenu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == quit) {
            System.exit(0);
            logger.info("The game closed.");
        }
    }

    public void pinner(GridPane pin) {
        int pincol = 0;
        int pinrow = 0;
        for (int n = 0; n < model.getBlackpin(); n++) {

            pin.add(new ImageView(blackp), pincol, pinrow);

            pincol++;
            if (pincol == 2) {
                pinrow++;
                pincol = 0;
            }
        }

        for (int n = 0; n < model.getWhitepin(); n++) {
            pin.add(new ImageView(whitep), pincol, pinrow);

            pincol++;
            if (pincol == 2) {
                pinrow++;
                pincol = 0;
            }
        }
        logger.info("Pins added.");
    }

    public void makeSecret() {

        for (int r = 0; r < 4; r++) {

            switch (secret[r]) {
                case "redbutton": {
                    secretcols.add(new ImageView(red), r, 0);
                    break;
                }
                case "bluebutton": {
                    secretcols.add(new ImageView(blue), r, 0);
                    break;
                }
                case "yellowbutton": {
                    secretcols.add(new ImageView(yellow), r, 0);
                    break;
                }
                case "greenbutton": {
                    secretcols.add(new ImageView(green), r, 0);
                    break;
                }
                case "brownbutton": {
                    secretcols.add(new ImageView(brown), r, 0);
                    break;
                }
                case "orangebutton": {
                    secretcols.add(new ImageView(orange), r, 0);
                    break;
                }
                case "blackbutton": {
                    secretcols.add(new ImageView(black), r, 0);
                    break;
                }
                case "whitebutton": {
                    secretcols.add(new ImageView(white), r, 0);
                    break;
                }
                default:
                    break;
            }
        }
        logger.info("Secret colors generated.");
    }

    public void result() {

        newgame.setVisible(true);
        hide.setVisible(false);
        label.setVisible(true);
        background.setVisible(true);
        mainmenu.setVisible(true);
        blackbutton.setVisible(false);
        redbutton.setVisible(false);
        yellowbutton.setVisible(false);
        whitebutton.setVisible(false);
        bluebutton.setVisible(false);
        greenbutton.setVisible(false);
        brownbutton.setVisible(false);
        orangebutton.setVisible(false);

    }
}
