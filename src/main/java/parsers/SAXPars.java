package parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import paper.Characteristics;
import paper.Paper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SAXPars {
    private static final Logger logger = LogManager.getLogger(SAXPars.class);

    private static class SAXHandler extends DefaultHandler {
        private static final String PAPER_TAG = "paper";
        private static final String TITLE_TAG = "Title";
        private static final String TYPE_TAG = "Type";
        private static final String MONTHLY_TAG = "Monthly";
        private static final String CHARACTERISTICS_TAG = "Char";

        public SAXHandler(List<Paper> papers) {
            this.papers = papers;
        }
        private List<Paper> papers;
        private Paper currentPaper;

        private StringBuilder elementValue;
        private String currentCharacteristicsType;

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            elementValue.append(ch, start, length);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(PAPER_TAG)) {
                currentPaper = new Paper();
                String id = attributes.getValue("id");
                currentPaper.setId(id);
                logger.info("Parsing paper with id {}", id);
            }
            else if (qName.equals(CHARACTERISTICS_TAG)){
                currentCharacteristicsType = attributes.getValue("type");
            }
            elementValue = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case PAPER_TAG:
                    papers.add(currentPaper);
                    break;
                case TITLE_TAG:
                    currentPaper.setTitle(elementValue.toString().trim());
                    break;
                case TYPE_TAG:
                    currentPaper.setType(elementValue.toString().trim());
                    break;
                case MONTHLY_TAG:
                    currentPaper.setMonthly(Boolean.parseBoolean(elementValue.toString().trim()));
                    break;
                case CHARACTERISTICS_TAG:
                    if (currentPaper.getCharacteristics() == null){
                        currentPaper.setCharacteristics(new Characteristics());
                    }
                    String value = elementValue.toString().trim();
                    currentPaper.getCharacteristics().addCharacteristics(currentCharacteristicsType, value);
                    break;
            }
        }

    }

    public List<Paper> parse(String path) throws FileNotFoundException {
        List<Paper> papers = new ArrayList<>();
        try{
            File file = new File(path);
            if (!file.exists()){
                throw new FileNotFoundException("file on path '" + path + "' doesn't exist!");
            }

            logger.info("Open file '{}'", path);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(file, new SAXHandler(papers));
            logger.info("Successfully parsed {} flowers", papers.size());

        }
        catch (FileNotFoundException e){
            logger.error("file on path '{}' doesn't exist!", path);
            throw new FileNotFoundException("file on path '" + path + "' doesn't exist!");
        }
        catch (Exception e){
            logger.error("Error parsing file '{}': {}", path, e.getMessage());
            throw new RuntimeException(e);
        }
        return papers;
    }
}
