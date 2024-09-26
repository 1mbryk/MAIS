import entity.Array;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import service.*;
import org.testng.annotations.Test;

public class ArrayFunctionalityTest {
    private Array array = new Array();
    private ArrayFunctionality af = new ArrayFunctionality();

    @Test
    public void testSum() {
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(10, af.sum(array));
    }

    @Test
    public void testMin(){
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(1, af.min(array));
    }

    @Test
    public void testMax(){
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(4, af.max(array));
    }

    @Test
    public void testCountPositive(){
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(4, af.countPositive(array));
    }

    @Test
    public void testCountNegative(){
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(0, af.countNegative(array));
    }

    @Test
    public void testGetMedian(){
        array = new Array(new Integer[]{1,2,3,4});
        Assert.assertEquals(3, af.getMedian(array));
    }
}
