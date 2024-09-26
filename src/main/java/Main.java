import entity.Array;
import service.ArrayFunctionality;
import service.ReadFile;

public class Main {
    public static void main(String[] args) {
//        Array array = new Array(new Integer[]{9,8,7,6,5,4,3,2,1});
//        ArrayFunctionality AR = new ArrayFunctionality();
//        System.out.println(AR.max(array));
//        System.out.println(AR.min(array));
//        System.out.println(AR.countNegative(array));
//        System.out.println(AR.countPositive(array));
//        System.out.println(AR.sum(array));
//        System.out.println(AR.getMedian(array));
//        System.out.println(array);
        ReadFile reader = new ReadFile("src/main/resources/data.txt");
        Array array = reader.read();
        System.out.println(array);

    }
}
