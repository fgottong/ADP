package ad_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import static ad_2.SortClassCommons.*;

public class Quick3Way {

    public static <T extends Comparable<? super T>>  void sort(T[] a) {
        StdRandom.shuffle(a);
        sort( a,0, a.length - 1);
        assert isSorted(a);
    }

    static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp <0 ) { exch(a,i++,lt++);}
            else if (cmp==0) {i++;}
            else {exch(a,i,gt--);}
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

