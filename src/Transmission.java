import java.io.IOException;

public interface Transmission {
    public DataSet receiver() throws IOException;
    public void transmitter(DataSet data, String address, short port) throws IOException;
}
