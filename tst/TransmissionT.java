import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.net.InetAddress;

public class TransmissionT {
    long time = 1577836800;
    float[] values = {3.284f, 474.56f, 0.42f};
    DataSet data = new DataSet(time, values);
    TransmissionClass transmitter = new TransmissionClass();
    String address = InetAddress.getLoopbackAddress().toString();
    short port = 8080;
    @Test
       public void testTransmission(){
        transmitter.transmitter(data, address, port);
        DataSet received = transmitter.receiver();
        long expectedTime = time;
        long actualTime = received.getTime();
        Assertions.assertEquals(expectedTime, actualTime);
        float[] expectedValues = values;
        float[] actualValues = received.getValues();
        Assertions.assertEquals(expectedValues,actualValues);
    }
}
