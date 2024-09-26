import entity.Array;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.Sort;

public class ArrayTest {
    Array array;

    @Test
    public void testAppend() {
        array = new Array();
        array.append(1,2,3,4);
        Assert.assertEquals(4, array.size());
    }

    @Test
    public void testSet() {
        array = new Array();
        array.append(1,2,3,4);
        array.set(3,-1);
        Assert.assertEquals(-1, array.get(3));

    }

    @Test
    public void testGet() {
        array = new Array();
        array.append(1,2,3,4);
        Assert.assertEquals(4, array.get(3));
    }


}
