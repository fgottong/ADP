package Praktikum3.ad_2_2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Praktikum3.ad_2.SortClassCommons.*;

public class MergeBottomUp {

//    public static <T extends Comparable<? super T>> void sort(T[] a) {
//        T[] aux = a.clone();
//        int N = a.length;
//        for(int sz = 1; sz < N; sz = sz+sz){ // Teilarraygröße (tasz) wird in jedem Schritt verdoppelt
//            for (int lo =0; lo < N-sz; lo += sz+sz) { // Teilarrayindizes für eine Teilarraygröße
//                // Indizes für das rechte Teilarray
//                merge(a,aux,lo,lo+sz-1, Math.min(lo+2*sz-1,N-1)); // Mischen des rechten und linken Teilarrays
//                // Gesamtgröße ist 2*tasz Mitte ist lo+tasz-1 obere Grenze ist lo + 2*tasz-1 Math.min stellt sicher, dass
//                // die Grenze N-1 nicht überschritten wird
//            }
//        }
//    }

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        // for each -> runterbrechen in dreier
        // dreier als einzelelemente in neuer array!!! --> aus array von arrays (in dreier gruppen) element für element neues befülllen
        // sortieren
        // sortiertes array in array von arrays

        T[] temp = (T[]) new Comparable[3];
        T[][] temps = (T[][]) new Object[a.length/3][3];
        int counter = 0;

        for (int i = 0; i < a.length; i+=3) {
            for (int j = 0; j < 3; j++) {
                temp[j] = a[i+j];
            }
            temp=fillOneSortedArray(temp);
        }
        temps[counter] = temp;
        counter++;

        

    }

    public static <T extends Comparable<? super T>> T[] fillOneSortedArray(T[] apart) {
        T[] temp =(T[]) new Comparable[apart.length];

        Arrays.stream(apart)
                .sorted() //.flatten....
                .toArray(size -> temp);

        return temp;
    }

   static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <=hi; k++){
            aux[k] = a[k];
        }

        for (int k = lo; k <=hi; k++){

            if (i > mid) a[k] = aux[j++]; // links erschöpft
            else if (j > hi ) a[k] = aux[i++]; // rechts erschöpft
            else if (less(aux[j], aux[i])) a[k]= aux[j++]; // rechts kleiner links
            else a[k] = aux[i++];
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
