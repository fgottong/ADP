package Praktikum3.ad_2_1;

import edu.princeton.cs.algs4.StdOut;

import static Praktikum3.ad_2.SortClassCommons.*;

public class SelectionWithOutput  {

    public static void sort(Comparable[] a){
        int N = a.length;
        showHeader(a);
        for (int i =0; i<N ;i++){
            int min = i;
            for (int j=i+1; j < N; j++) {
                if (less(a[j], a[min])) {min = j;}
            }
            exch(a, i, min);
            showLine( i,  min, a);
        }
    }

    private static void showHeader( Comparable[] a){
        StdOut.printf("  i min");
        for (int j =0; j < a.length; j ++) {
            StdOut.printf("%3d",j);
        }
        StdOut.println();
        StdOut.printf("%7s"," ");
        for (int j =0; j <a.length; j ++) {
            StdOut.printf("%3s",a[j]);
        }
        StdOut.println();
    }

    private static void showLine(int i, int min, Comparable[]a){
        StdOut.printf("%3d %3d", i,min);
        for (int j =0; j < a.length; j ++) {
            StdOut.printf("%3s",a[j]);
        }
        StdOut.println();
    }

    public static void main(String[] args){
        String[] a; // =  new In().readAllStrings();
        a = "V I R E N A L L E R G I E".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
