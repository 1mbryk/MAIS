package parsers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import paper.Characteristics;
import paper.Paper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DOMParser  {
    private final Logger logger = LogManager.getLogger(DOMParser.class);

    public List<Paper> parse(String path){
        List<Paper> papers = new ArrayList<>();

        DocumentBuilder builder;
        Document document;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(new File(path));
        }
        catch (ParserConfigurationException e) {
            logger.error("Failed to create DocumentBuilder", e);
            throw new RuntimeException(e);
        }
        catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Parsing document: '{}'", path);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("paper");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String id = element.getAttribute("id");
            logger.info("Parsing paper with id: '{}'", id);
            String title = element.getElementsByTagName("Title").item(0).getTextContent();
            String type = element.getElementsByTagName("Type").item(0).getTextContent();
            String isMonthly = element.getElementsByTagName("Monthly").item(0).getTextContent();
            Characteristics characteristics = getCharacteristics(element);

            papers.add(new Paper(id, title, type, Boolean.parseBoolean(isMonthly), characteristics));
        }
        logger.info("Parsed {} papers", papers.size());
        return papers;
    }

    private Characteristics getCharacteristics(Element element) {
        NodeList characteristicList = element.getElementsByTagName("Char");
        Characteristics characteristic = new Characteristics();
        for (int j = 0; j < characteristicList.getLength(); j++) {
            Element charElement = (Element) characteristicList.item(j);
            String type = charElement.getAttribute("type");
            String value = charElement.getTextContent();
            characteristic.addCharacteristics(type, value);
        }
        return characteristic;
    }
}
