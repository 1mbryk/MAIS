import paper.Characteristics;
import paper.Paper;

public class Main {
    public static void main(String[] args) {
        Paper paper = new Paper("1", "Aboba", "biba", true,
                new Characteristics(true, 10,true,true ));
        System.out.println(paper);
    }
}
