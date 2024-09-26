import entity.Array;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.Sort;

public class SortTest {
    Array array;
    Sort sort = new Sort();

    @Test
    public void testQuickSort() {
        array = new Array();
        array.append(5,4,3,2,1);
        Assert.assertEquals(new Array(new Integer[]{1,2,3,4,5}).toString(),
                             sort.sort(array, "quick").toString());
    }

    @Test
    public void testBubbleSort() {
        array = new Array();
        array.append(5,4,3,2,1);
        Assert.assertEquals(new Array(new Integer[]{1,2,3,4,5}).toString(),
                sort.sort(array, "bubble").toString());
    }

    @Test
    public void testInsertionSort() {
        array = new Array();
        array.append(5,4,3,2,1);
        Assert.assertEquals(new Array(new Integer[]{1,2,3,4,5}).toString(),
                sort.sort(array, "insertion").toString());
    }
}
