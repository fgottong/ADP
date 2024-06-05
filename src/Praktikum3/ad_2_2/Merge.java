package ad_2_2;

import java.util.Arrays;

import static ad_2.SortClassCommons.*;

public class Merge {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] aux = a.clone();
        sort(a, aux, 0, a.length - 1, 0);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi, int depth) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, depth + 1); // sortiert linke Hälfte
        sort(a, aux, mid + 1, hi, depth + 1); // sortiert rechte Hälfte
        merge(a, aux, lo, mid, hi); // Mischt die Ergebnisse
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // links erschöpft
            else if (j > hi) a[k] = aux[i++]; // rechts erschöpft
            else if (less(aux[j], aux[i])) a[k] = aux[j++]; // rechts kleiner links
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        String[] a = "A U F B R U C H S T I M M U N G".split(" ");//"EEGMRACERT".split("");
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
