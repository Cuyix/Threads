import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    public DataSet runThread() {
        float[] x = {0f};
        DataSet dO = new DataSet(0, x);
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dO.setTime(dis.readLong());
            int dataCount = dis.readInt();
            float[] vals = new float[dataCount];
            for (int i = 0; i < dataCount; i++) {
                vals[i] = dis.readFloat();
            }
            dO.setValues(vals);
            socket.close();
        } catch (IOException ex) {
            System.err.println("Failed to receive.");
        }
        return dO;
    }
}
