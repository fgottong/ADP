package Praktikum3.ad_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Praktikum3.ad_2.SortClassCommons.*;

public class QuickMedian7 {

    public static <T extends Comparable<? super T>>  void sort(T[] a) {
        StdRandom.shuffle(a);
        sort( a,0, a.length - 1);
        assert isSorted(a);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partition( a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a,pivot + 1, hi);
    }

    public static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi){
        int i=lo, j=hi+1;

        final int n = hi - lo;
        //                   1  7     mitte=4        2              3.               5.              6.
        int pivotIndex = median7( a,lo,hi,lo+(n/2),2*(n/7),lo+3*(n/7),lo+5*(n/7),lo+6*(n/7));

        exch(a, lo, pivotIndex);
        T pivot =a[lo];

        while( true ) {
            while(less(a[++i],pivot)) {
                if (i==hi) break;
            }
            while(less(pivot,a[--j])) {
                if (j==lo) break;
            }
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    // return the index of the median element among a[i], a[j], and a[k]
    private static <T extends Comparable<? super T>> int median7(T[] a, int i, int j, int k, int l, int m, int n, int o) {
//        Comparable[] x = {a[i], a[j], a[k], a[l], a[m], a[n] ,a[o] };
        // Array.sort(x)
        // return (T[]) x(3);
        Comparable[] x = {a[i], a[j], a[k], a[l], a[m], a[n], a[o]};
        Arrays.sort(x);

        int ret = IntStream.of(i, j, k, l, m, n , o).filter(p -> x[3] == a[p]).findFirst().orElseThrow();
        if (ret < i || ret > j)
            throw new RuntimeException("Wir rennen aus den Indizes raus");
        return ret;
    }


    public static void main(String[] args) {
//        String[] a = new In(args[0]).readAllStrings();
        String[] a = {"i", "3", "4", "k", "5", "6", "l", "6", "2", "l", "5", "6", "p", "ä", "s", "k", "6", "7", "2", "7"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
