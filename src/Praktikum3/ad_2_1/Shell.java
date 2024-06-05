package ad_2_1;

import edu.princeton.cs.algs4.In;

import static ad_2.SortClassCommons.*;

public class Shell {


    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int length = a.length;
        int h = 1;
        // Bestimme das kleinste h für das die geometrische Reihe für 3 >= length/3 wird
        while (h < length / 3) h = 3 * h + 1;
        // Berechne für immer kleiner werdende h die h-sortierten Sequenzen des Arrays
        // Wenn h ==1, dann ist das Array sortiert
        while (h >= 1) {
            // h-sortiere parallele alle h-Serien
            for (int i = h; i < length; i++) {
                //betrachte alle links von i liegenden Elemente im Abstand h und tausche ggf a[j] gehen a[j-h]
                //die Elemente links von j sind bereits h-sortiert
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a,j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
