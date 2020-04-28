public class DataSet implements Data {
    private long time;
    private float[] values;

    DataSet(long time, float[] values){
        this.time = time;
        this.values = values;
    }

    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    public float[] getValues() {
        return values;
    }
    public void setValues(float[] values) {
        this.values = values;
    }
}
