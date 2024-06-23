package Praktikum3.ad_2_2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Praktikum3.ad_2.SortClassCommons.*;

public class MergeBottomUp {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] aux = a.clone();
        int N = a.length;
        for (int sz = 1; sz < N; sz = 3 * sz) {
            // in vielfachen von 3 über das Array gehen

            for (int lo = 0; lo < N - sz; lo += 3 * sz) {
                // Erzeuge jeweils 3 Teilarrays ...

                // HIER mit Math.min arbeiten, um die Indexfehler zu vermeiden BW
                merge3(a, aux, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1),
                        Math.min(lo + 3 * sz - 1, N - 1));
            }
        }
    }

    static <T extends Comparable<? super T>> void merge3(T[] a, T[] aux,
                                                         int lo, int mid1, int mid2, int hi) {

        if (hi < lo) return;

        int left = lo;
        int middle = mid1 + 1;
        int right = mid2 + 1;
        // Kopieren bleibt
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int k = lo;

        // 1'ter Fall: alle Arrays enthalten noch Elemente
        while (left <= mid1 && middle <= mid2 && right <= hi) {
            if (less(aux[left], aux[middle])) {
                if (less(aux[left], aux[right])) {
                    // aux[left] ist das kleinere
                    a[k++] = aux[left++];
                } else {
                    // aux[right] ist das kleinere
                    a[k++] = aux[right++];
                }
            } else {
                // aux[middle]<aux[left]
                if (less(aux[middle], aux[right])) {
                    // aux[middle] ist das kleinere
                    a[k++] = aux[middle++];
                } else {
                    // aux[right] ist das kleinere
                    a[k++] = aux[right++];
                }
            }
        }

        // erste Schleife bricht ab
        // 2'ter Fall eines der drei Arrays ist erschöpft

        // links erschöpft
        while ( middle <= mid2 && right <= hi) {
            if (less(aux[middle], aux[right])) {
                a[k++] = aux[middle++];
            } else {
                a[k++] = aux[right++];
            }

        }
        // mitte erschöpft
        while ( left <= mid1 && right <= hi) {
            if (less(aux[left], aux[right])) {
                a[k++] = aux[left++];
            } else {
                a[k++] = aux[right++];
            }
        }

        // rechts erschöpft
        while ( left <= mid1 && middle <= mid2) {
            if (less(aux[left], aux[middle])) {
                a[k++] = aux[left++];
            } else {
                a[k++] = aux[middle++];
            }
        }

        // 3'ter Fall zwei Arrays sind erschöpft
        // Kopiere den Rest von links
        while(left <= mid1){
            a[k++] = aux[left++];
        }

        // Kopiere den Rest der Mitte
        while(middle <= mid2){
            a[k++] = aux[middle++];
        }

        // Kopiere dem Rest von rechts
        while(right<= hi){
            a[k++] = aux[right++];
        }

    }


    public static void main(String[] args) {
        String[] a = "EEGMRACERT".split("");
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
