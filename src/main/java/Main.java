import entity.Array;
import service.ArrayFunctionality;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(new Integer[]{9,8,7,6,5,4,3,2,1});
        System.out.println(array.sort("quick").toString());
        ArrayFunctionality AR = new ArrayFunctionality();
        System.out.println(AR.max(array));
        System.out.println(AR.min(array));
        System.out.println(AR.countNegative(array));
        System.out.println(AR.countPositive(array));
        System.out.println(AR.sum(array));
        System.out.println(array);
    }
}
