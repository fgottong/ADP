package ad_2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import static ad_2.SortClassCommons.*;

public class MergeBottomUpBars {

    private static int numberOfRows;
    private static int row = 0;
    private static final int VERTICAL = 70;

    public static void sort(double[] a) {
        double[] aux = a.clone();
        int N = a.length;
        for(int sz = 1; sz < N; sz = sz+sz){ // Teilarraygröße (tasz) wird in jedem Schritt verdoppelt
            for (int lo =0; lo < N-sz; lo += sz+sz) { // Teilarrayindizes für eine Teilarraygröße
                // Indizes für das rechte Teilarray
                merge(a,aux,lo,lo+sz-1, Math.min(lo+2*sz-1,N-1)); // Mischen des rechten und linken Teilarrays
                show(a, lo, Math.min(lo+2*sz-1,N-1));
                // Gesamtgröße ist 2*tasz Mitte ist lo+tasz-1 obere Grenze ist lo + 2*tasz-1 Math.min stellt sicher, dass
                // die Grenze N-1 nicht überschritten wird
            }
        }
    }

    private static void show(double[] a, int lo, int hi) {
        double y = numberOfRows - row - 1;
        for (int k = 0; k < a.length; k++) {
            if      (k < lo)             StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (k > hi)             StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else                         StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(k, y + a[k] * 0.25, 0.25, a[k] * 0.25);
        }
        row++;
    }

   static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <=hi; k++){
            aux[k] = a[k];
        }

        for (int k = lo; k <=hi; k++){

            if (i > mid) a[k] = aux[j++]; // links erschöpft
            else if (j > hi ) a[k] = aux[i++]; // rechts erschöpft
            else if (less(aux[j], aux[i])) a[k]= aux[j++]; // rechts kleiner links
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
//        String[] a = "EEGMRACERT".split("");
//        System.out.println(Arrays.toString(a));
//        sort(a);
//        assert isSorted(a);
//        show(a);

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        if (args.length == 3) {
            long seed = Long.parseLong(args[2]);
            StdRandom.setSeed(seed);
        }
        double[] a = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = (1 + StdRandom.uniform(m)) / (double) m;
            b[i] = a[i];
        }

        StdDraw.enableDoubleBuffering();

        // precompute the number of rows
        numberOfRows = 0;
        sort(b);
        numberOfRows = row;
        row = 0;
        StdDraw.clear();

        StdDraw.setCanvasSize(800, numberOfRows*VERTICAL);
        StdDraw.show();
        StdDraw.square(0.5, 0.5, 0.5);
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-0.5, numberOfRows);
        StdDraw.show();
        sort(a);
        StdDraw.show();
    }
}
