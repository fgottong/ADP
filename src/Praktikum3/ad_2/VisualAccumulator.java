package Praktikum3.ad_2;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class VisualAccumulator extends SimpleAccumulator implements Accumulator{

    public VisualAccumulator(int trials, double max){
        StdDraw.setCanvasSize(1024,512);
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);
    }

    @Override
    public void addDataValue(double d) {
        N++;
        total += d;
        //StdOut.printf("N=%d find ops=%1.3f mean=%1.3f\n",N, d, total/N);
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.point(N,d);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N,mean());
    }

}
