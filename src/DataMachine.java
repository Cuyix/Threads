import java.io.*;

public class DataMachine implements Machine {

    @Override
    public void writeDataSet(DataSet data, String sensorName) {
        OutputStream os;
        DataOutputStream dos = null;
        try {
            String filename = sensorName + ".txt";
            os = new FileOutputStream(filename);
            dos = new DataOutputStream(os);
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open file.");
            System.exit(0);
        }
        try {
            long time = data.getTime();
            float[] vals = data.getValues();
            int dataCount = vals.length;
            dos.writeLong(time);
            dos.writeInt(dataCount);
            for (int k = 0; k < dataCount; k++) {
                dos.writeFloat(vals[k]);
            }
        } catch (IOException ex) {
            System.err.println("Failed to write data to file.");
            System.exit(0);
        }
    }

    @Override
    public DataSet readDataSet(String sensorName) {
        InputStream is;
        DataInputStream dis = null;
        try {
            String filename = sensorName + ".txt";
            is = new FileInputStream(filename);
            dis = new DataInputStream(is);
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open file.");
            System.exit(0);
        }
        float[] x = {0f};
        DataSet dO = new DataSet(0, x);
        try {
            dO.setTime(dis.readLong());
            int dataCount = dis.readInt();
            float[] vals = new float[dataCount];
            for (int i = 0; i < dataCount; i++) {
                vals[i] = dis.readFloat();
            }
            dO.setValues(vals);
        } catch (IOException ex){
            System.err.println("Failed to read from file.");
            System.exit(0);
        }
        return dO;
    }
}
