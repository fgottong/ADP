package Praktikum1;

import edu.princeton.cs.algs4.*;

public class SimpleAccumulator extends Accumulator{

    protected int N;
    protected double total;

    public SimpleAccumulator(){
        this.N = 0;
        this.total=0.0;
    }
    @Override
    public void addDataValue(double d){
        N++;
        total += d;
    }
    @Override
    public double mean (){
        return total/N;
    }

    @Override
    public String toString (){
        return String.format ("Mean(%d values): %7.5f ", N,mean());
    }
}