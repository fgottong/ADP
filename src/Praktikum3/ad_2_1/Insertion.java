package ad_2_1;

import edu.princeton.cs.algs4.In;

import static ad_2.SortClassCommons.*;

public class Insertion {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args)  {
        String[] a = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
