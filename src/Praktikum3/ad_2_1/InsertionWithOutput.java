package Praktikum3.ad_2_1;

import Praktikum3.ad_2.SortClassCommons;
import edu.princeton.cs.algs4.StdOut;

public class InsertionWithOutput extends SortClassCommons {


    public static void sort(Comparable[] a){
        showHeader(a);
        int N = a.length;
        for (int i = 1; i< N; i++){
            int j = i;
            for (j = i; j >0 && less(a[j],a[j-1]); j--)
                exch(a,j,j-1);
            showLine(i,j,a);
        }
    }

    private static void showHeader( Comparable[] a){
        StdOut.printf("  i   j");
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

    public static void main(String[] args) {
        String[] a;// = new In().readAllStrings();
        a = "V I R E N A L L E R G I E".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
