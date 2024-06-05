package ad_2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import static ad_2.SortClassCommons.isSorted;
import static ad_2.SortClassCommons.show;
import static ad_2_3.Quick.partition;


public class QuickPlusInsertion  {

    private static final int MINSIZE = 5;
    public static <T extends Comparable<? super T>>  void sort(T[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo+MINSIZE) {
            Insertion.sort(a,lo,hi);
            return;
        }
        int pivot = partition(a,lo,hi);
        sort(a,lo,pivot-1);
        sort(a,pivot+1,hi);
    }

    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
