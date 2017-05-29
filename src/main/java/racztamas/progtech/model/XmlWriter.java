/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Osztály az xml fájlokba való írásra.
 *
 * Az XML állományokat operációs rendszertől függően máshol keresi. Windows:
 * {@code C:\Users\}felhasználónév{@code \Documents\colors.xml} Linux:
 * {@code /home/}felhasználónév{@code /colors.xml} Windows:
 * {@code C:\Users\}felhasználónév{@code \Documents\secret.xml} Linux:
 * {@code /home/}felhasználónév{@code /secret.xml}
 *
 * @author toti
 */
public class XmlWriter {

    final static Logger logger = LoggerFactory.getLogger(XmlWriter.class);

    private final String osName = System.getProperty("os.name").toLowerCase();

    private final String userName = System.getProperty("user.name");

    private final String windowsFilePath = "C:" + File.separator + "Users" + File.separator
            + userName + File.separator + "Documents" + File.separator + "colors.xml";

    private final String linuxFilePath = File.separator + "home" + File.separator + userName
            + File.separator + "colors.xml";

    private final String windowsSecretFilePath = "C:" + File.separator + "Users" + File.separator
            + userName + File.separator + "Documents" + File.separator + "secret.xml";

    private final String linuxSecretFilePath = File.separator + "home" + File.separator + userName
            + File.separator + "secret.xml";

    /**
     * Berakja egy listába a golyókat, és azok értékeit.
     */
    public void writehelper() {

        List<Modell> help = new ArrayList<>();

        Modell colores = new Modell();

        colores.setId(model.getId());
        colores.setColor(model.getColor());
        colores.setCol(model.getCol());
        colores.setRow(model.getRow());
        help.add(colores);
        model.setColors(help);

    }

    /**
     * Kimenti a jelenlegi játékállást egy xml fájlba.
     *
     * @throws ParserConfigurationException parse configuration exception
     * @throws TransformerConfigurationException transformer configuration
     * exception
     * @throws TransformerException transformer exception
     */
    public void write() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("colors");
        doc.appendChild(rootElement);

        for (int i = 0; i < model.getColors().size(); i++) {

            Element staff = doc.createElement("guess");
            rootElement.appendChild(staff);

            Modell ez = model.getColors().get(i);

            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(Integer.toString(ez.getId())));
            staff.appendChild(id);

            Element color = doc.createElement("color");
            color.appendChild(doc.createTextNode(ez.getColor()));
            staff.appendChild(color);

            Element col = doc.createElement("col");
            col.appendChild(doc.createTextNode(Integer.toString(ez.getCol())));
            staff.appendChild(col);

            Element row = doc.createElement("row");
            row.appendChild(doc.createTextNode(Integer.toString(ez.getRow())));
            staff.appendChild(row);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            File xml = null;

            if (osName.contains("windows")) {
                xml = new File(windowsFilePath);
            } else if (osName.contains("linux") || osName.contains("unix")) {
                xml = new File(linuxFilePath);
            }

            StreamResult result = new StreamResult(xml);
            transformer.transform(source, result);

        }
        logger.info("Colors saved.");

    }

    /**
     * Kimenti a titkos színeket egy xml fájlba.
     *
     * @param secret az a tömb amiben tároljuk a titkos színeket
     * @throws ParserConfigurationException parse configuration exception
     * @throws TransformerConfigurationException transformer configuration
     * exception
     * @throws TransformerException transformer exception
     */
    public void writesecret(String[] secret) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("colors");
        doc.appendChild(rootElement);

        for (int i = 0; i < secret.length; i++) {

            Element staff = doc.createElement("secret");
            rootElement.appendChild(staff);

            Element color = doc.createElement("color");
            color.appendChild(doc.createTextNode(secret[i]));
            staff.appendChild(color);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            File xml = null;

            if (osName.contains("windows")) {
                xml = new File(windowsSecretFilePath);
            } else if (osName.contains("linux") || osName.contains("unix")) {
                xml = new File(linuxSecretFilePath);
            }
            StreamResult result = new StreamResult(xml);

            transformer.transform(source, result);

        }
        logger.info("Secret colors saved.");

    }

}
