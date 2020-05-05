import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.io.*;

public class TransmissionClass implements Transmission {
    @Override
    public DataSet receiver(){
        float[] x = {0f};
        DataSet dO = new DataSet(0,x);
        try {
            short port = 8080;
            ServerSocket ser = new ServerSocket(port);
            ServerThread sT = new ServerThread(ser.accept());
            dO = sT.runThread();
        } catch(IOException ex){
            System.err.println("Failed to run server");
        }
        DataMachine dm = new DataMachine();
        dm.writeDataSet(dO, "Received");
        return dO;
    }

    @Override
    public void transmitter(DataSet data, String address, short port) {
        try {
            Socket socket = new Socket(address, port);
            //SocketAddress sr = new InetSocketAddress(address, port);
            //socket.connect(sr, 10000);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            long time = data.getTime();
            float[] vals = data.getValues();
            int dataCount = vals.length;
            dos.writeLong(time);
            dos.writeInt(dataCount);
            for (int k = 0; k < dataCount; k++) {
                dos.writeFloat(vals[k]);
            }
            socket.close();
        } catch (IOException ex) {
            System.err.println("Failed to transmit.");
        }
    }

}
