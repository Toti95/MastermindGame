/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racztamas.progtech.model;

import static racztamas.progtech.controller.FXMLController.model;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {

    public void read() {

        List<Modell> help = new ArrayList<>();
        help.clear();

        try {

            File fXmlFile = new File("/home/toti/NetBeansProjects/progtech/src/main/resources/xml/colors.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("guess");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Modell colores = new Modell();

                    Element eElement = (Element) nNode;
                    colores.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                    colores.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
                    colores.setCol(Integer.parseInt(eElement.getElementsByTagName("col").item(0).getTextContent()));
                    colores.setRow(Integer.parseInt(eElement.getElementsByTagName("row").item(0).getTextContent()));
                    help.add(colores);
                    model.setColors(help);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readsecret(String[] secret) {

        List<Modell> help = new ArrayList<Modell>();
        help.clear();

        try {

            File fXmlFile = new File("/home/toti/NetBeansProjects/progtech/src/main/resources/xml/secrets.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("secret");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Modell colores = new Modell();

                    Element eElement = (Element) nNode;
                    colores.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
                    help.add(colores);
                    model.setColors(help);

                }
                for (int j = 0; j < model.getColors().size(); j++) {
                    Modell ez = model.getColors().get(j);
                    switch (ez.getColor()) {
                        case "redbutton":
                            secret[j] = "redbutton";
                            break;

                        case "greenbutton":
                            secret[j] = "greenbutton";
                            break;

                        case "bluebutton":
                            secret[j] = "bluebutton";
                            break;

                        case "blackbutton":
                            secret[j] = "blackbutton";
                            break;

                        case "brownbutton":
                            secret[j] = "brownbutton";
                            break;

                        case "yellowbutton":
                            secret[j] = "yellowbutton";
                            break;

                        case "whitebutton":
                            secret[j] = "whitebutton";
                            break;

                        case "orangebutton":
                            secret[j] = "orangebutton";
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
