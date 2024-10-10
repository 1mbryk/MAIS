import paper.Characteristics;
import paper.Paper;
import parsers.DOMParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DOMParser domParser = new DOMParser();
        List<Paper> paperList = domParser.parse("src/main/resources/papers/papers.xml");
        for (Paper paper : paperList) {
            System.out.println(paper);
        }
    }
}
