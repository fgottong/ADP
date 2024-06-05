package Praktikum3.ad_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import static Praktikum3.ad_2.SortClassCommons.*;

public class Quick {

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
        T pivot = a[lo];
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

    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
