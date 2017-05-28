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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class to write in XML file.
 *
 * @author toti
 */
public class XmlWriter {

    /**
     * Function to help for writer.
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
     * Function to write in XML.
     */
    public void write() {

        try {
            /**
             * Create a new Document builder.
             */
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
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
                StreamResult result = new StreamResult(new File("/home/toti/NetBeansProjects/progtech/src/main/resources/xml/colors.xml"));

                transformer.transform(source, result);

            }
            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void writesecret(String[] secret) {

        try {

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
                StreamResult result = new StreamResult(new File("/home/toti/NetBeansProjects/progtech/src/main/resources/xml/secrets.xml"));

                transformer.transform(source, result);

            }
            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}
