import entity.Array;
import service.ArrayFunctionality;
import service.ReadFile;

public class Main {
    public static void main(String[] args) {
        ReadFile reader = new ReadFile("src/main/resources/data.txt");
        Array array = reader.read();
        System.out.println(array);
        ArrayFunctionality AR = new ArrayFunctionality();
        System.out.println(AR.max(array));
        System.out.println(AR.min(array));
        System.out.println(AR.countNegative(array));
        System.out.println(AR.countPositive(array));
        System.out.println(AR.sum(array));
        System.out.println(AR.getMedian(array));
        System.out.println(array);

    }
}
