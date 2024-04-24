
package Praktikum1;
import edu.princeton.cs.algs4.*;
import java.awt.*;

public class VisualAccumulator extends SimpleAccumulator{


    public VisualAccumulator(int trials, double max){

        super();

        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);


    }

    @Override
    public void addDataValue(double d) {
        N++;
        total += d;
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.point(N,d);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N,total/N);
    }
}