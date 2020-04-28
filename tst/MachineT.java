import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MachineT {
    long time = 1577836800;
    float[] values = {3.284f, 474.56f, 0.42f};
    DataSet data = new DataSet(time, values);
    String name = "Hansi";
    DataMachine machine = new DataMachine();
    @Test
    public void testDataMachine() {
        machine.writeDataSet(data, name);
        long actualTime = machine.readDataSet(name).getTime();
        Assertions.assertEquals(time, actualTime);
        float[] expectedValues = values;
        float[] actualValues = machine.readDataSet(name).getValues();
        Assertions.assertEquals(expectedValues,actualValues);
    }

}
