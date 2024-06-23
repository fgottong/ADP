package Praktikum3.ad_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import static Praktikum3.ad_2.SortClassCommons.*;

public class QuickMedian3 {

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

        exch(a, lo, median3(a,lo,hi,(hi-lo)/2));
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
    private static <T extends Comparable<? super T>> int median3(T[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }


    public static void main(String[] args) {
//        String[] a = new In(args[0]).readAllStrings();
        String[] a = {"i", "3", "4", "k", "5", "6", "l", "6", "2", "l", "5", "6", "p", "ä", "s", "k", "6", "7", "2", "7"};

        sort(a);
        assert isSorted(a);
        show(a);
    }
}
