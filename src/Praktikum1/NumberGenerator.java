package Praktikum1;

import java.util.Arrays;
import java.util.Random;

public class NumberGenerator {
    protected double[] ary;
    protected Random rand;
    protected int N;
    protected double min;
    protected double max;

    public NumberGenerator(int n, double max) {
        this(n, Double.MIN_VALUE, max);
        this.ary = new double[this.N];
        this.fillArray(n, max);
    }

    public NumberGenerator(int n, double min, double max) {
        this.N = n;
        this.rand = new Random();
        this.min = min;
        this.ary = new double[this.N];
        this.fillArray(n, min, max);
    }

    public static void main(String[] args) {
        NumberGenerator numGen = new NumberGenerator(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        System.out.println(numGen);
    }

    private void fillArray(int N, double max) {
        for(int i = 0; i < N; ++i) {
            if (this.rand.nextBoolean()) {
                this.ary[i] = this.rand.nextDouble(max + 1.0);
            } else {
                this.ary[i] = (double)this.rand.nextInt((int)max + 1);
            }
        }

    }

    private void fillArray(int N, double min, double max) {
        for(int i = 0; i < N; ++i) {
            if (this.rand.nextBoolean()) {
                this.ary[i] = this.rand.nextDouble(min, max + 1.0);
            } else {
                this.ary[i] = (double)this.rand.nextInt((int)min, (int)max + 1);
            }
        }

    }

    public String toString() {
        StringBuilder aryString = new StringBuilder();
        double[] var2 = this.ary;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            double v = var2[var4];
            aryString.append(v);
            aryString.append(" ");
        }

        return aryString.toString().trim();
    }

    public double[] getAry() {
        return Arrays.copyOf(this.ary, this.ary.length);
    }
}