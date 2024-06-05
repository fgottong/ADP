package ad_2;

public class SimpleAccumulator implements Accumulator{
    protected int N=0;
    protected double total=0.0;

    @Override
    public void addDataValue(double d) {
        N++;
        total+=d;
    }

    @Override
    public double mean() {
        return total/N;
    }

    @Override
    public String toString() {
        return String.format("Mean (%d values): %7.5f", N,mean());
    }
}
