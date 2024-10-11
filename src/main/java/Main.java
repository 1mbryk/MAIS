import paper.Characteristics;
import paper.Paper;
import parsers.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String XML_PATH = "src/main/resources/papers/papers.xml";
        DOMParser domParser = new DOMParser();
        List<Paper> paperList;
//        paperList= domParser.parse(XML_PATH);
//        for (Paper paper : paperList) {
//            System.out.println(paper);
//        }
        SAXPars saxParser = new SAXPars();
        try{
        paperList = saxParser.parse(XML_PATH);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        for (Paper paper : paperList) {
            System.out.println(paper);
        }
    }
}
