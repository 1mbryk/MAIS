package parsers;

import paper.Characteristics;
import paper.Paper;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StAXParser {
    private final Logger logger = LogManager.getLogger(StAXParser.class);

    public List<Paper> parse(String path) throws FileNotFoundException {
        List<Paper> papers = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader;
        try{
            reader = factory.createXMLEventReader(new FileReader(path));
        }
        catch (FileNotFoundException e){
            logger.error("File '{}' not found", path);
            throw new FileNotFoundException(e.getMessage());
        }
        catch (XMLStreamException e){
            logger.error("Error while parsing {}: {}", path, e.getMessage());
            throw new RuntimeException(e);
        }
        logger.info("Open file '{}'", path);

        Paper currentPaper = null;
        StringBuilder currentValue = new StringBuilder();
        String currentType = null;

        while (reader.hasNext()) {
            XMLEvent event;
            try{
                event = reader.nextEvent();

            }
            catch (XMLStreamException e){
                logger.error("Error while parsing {}: {}", path, e.getMessage());
                throw new RuntimeException(e);
            }

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String qNmae = startElement.getName().getLocalPart();

                if (qNmae.equals("paper")) {
                    String id = startElement.getAttributeByName(new javax.xml.namespace.QName("id")).getValue();
                    currentPaper = new Paper();
                    currentPaper.setId(id);
                    logger.info("Parsing paper with id '{}'", id);
                }
                else if (qNmae.equals("Char")) {
                    currentType = startElement.getAttributeByName(new javax.xml.namespace.QName("type")).getValue();
                }
            }
            else if(event.isCharacters()){
                currentValue.append(event.asCharacters().getData());
            }
            else if(event.isEndElement()){
                EndElement endElement = event.asEndElement();
                String qName = endElement.getName().getLocalPart();
                if (currentPaper == null){
                    continue;
                }
                switch (qName){
                    case "paper":
                        papers.add(currentPaper);
                        break;
                    case "Title":
                        currentPaper.setTitle(currentValue.toString().trim());
                        break;
                    case "Type":
                        currentPaper.setType(currentValue.toString().trim());
                        break;
                    case "Monthly":
                        currentPaper.setMonthly(Boolean.parseBoolean(currentValue.toString().trim()));
                        break;
                    case "Char":
                        if (currentPaper.getCharacteristics() == null){
                            currentPaper.setCharacteristics(new Characteristics());
                        }
                        if (currentType != null){
                            currentPaper.getCharacteristics().addCharacteristics(currentType, currentValue.toString().trim());
                        }
                        break;
                }
                currentValue.setLength(0);
            }
        }
        logger.info("Successfully parsed {} papers", papers.size());
        return papers;
    }
}
