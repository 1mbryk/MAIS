package parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import paper.Paper;

import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class PaperSAXParser {

    private Logger logger = LogManager.getLogger(PaperSAXParser.class);
    public List<Paper> parse(String path) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        List<Paper> papers = new ArrayList<>();


        return papers;
    }
    
}
