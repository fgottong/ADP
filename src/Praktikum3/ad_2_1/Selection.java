package ad_2_1;

import edu.princeton.cs.algs4.In;

import static ad_2.SortClassCommons.*;

public class Selection {


    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
