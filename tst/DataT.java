import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DataT {
    long time = 1577836800;
    float[] values = {3.284f, 474.56f, 0.42f};
    DataSet data = new DataSet(time, values);
    @Test
    public void testDataSet(){
        long expectedTime = time;
        long actualTime = data.getTime();
        Assertions.assertEquals(expectedTime,actualTime);
        long expectedTime2 = time+10;
        data.setTime(time+10);
        long actualTime2 = data.getTime();
        Assertions.assertEquals(expectedTime2,actualTime2);
        float[] expectedValues = values;
        float[] actualValues = data.getValues();
        Assertions.assertEquals(expectedValues,actualValues);
        float[] expectedValues2 = {0f,10.3f};
        data.setValues(expectedValues2);
        float[] actualValues2 = data.getValues();
        Assertions.assertEquals(expectedValues2,actualValues2);
    }
}
