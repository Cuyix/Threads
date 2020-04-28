public interface Machine {
    public void writeDataSet(DataSet data, String sensorName);
    public DataSet readDataSet(String sensorName);

}
