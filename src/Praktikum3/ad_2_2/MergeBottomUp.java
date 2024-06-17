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

    public static <T extends Comparable<? super T>> void sortFG(T[] a) {
        T[] aux = a.clone();
        int N = a.length;
        for(int sz = 1; sz < N; sz = 3*sz){
            // in vielfachen von 3 über das Array gehen

            for(int lo = 0;lo<N-sz;lo+=3*sz){
                // Erzeuge jeweils 3 Teilarrays ...

                T[] temp1 = Arrays.copyOfRange(a, lo, lo+sz);
                T[] temp2 = Arrays.copyOfRange(a, lo+sz+1, lo+sz+sz);
                T[] temp3 = Arrays.copyOfRange(a, lo+sz+sz+1, lo+sz+sz+sz);
                T[] sortedTemp =uniteAndSortArrays(temp1, temp2, temp3);
                System.arraycopy(a,0,sortedTemp,0,sortedTemp.length);
            }

        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        // for each -> runterbrechen in dreier
        // dreier als einzelelemente in neuer array!!! --> aus array von arrays (in dreier gruppen) element für element neues befülllen
        // sortieren
        // sortiertes array in array von arrays

        T[] temp = (T[]) new Comparable[3];


        T[][] temps =(T[][]) new Comparable[a.length / 3 + a.length % 3][3];

        int counter = 0;

        for (int i = 0; i < a.length; i += 3) {
            for (int j = 0; j < 3 && j+i<a.length; j++) {
                temp[j] = a[i + j];
            }
            temp = fillOneSortedArray(temp);
            temps[counter] = temp;
            counter++;
        }
        a = sort(temps)[0];

    }

    public static <T extends Comparable<? super T>> T[][] sort(T[][] temps) {
        // Abbruchbedingung
        if (temps.length == 1) {
            return temps;
        }

        // Arbeit in der Methode
        int length = 0;
        for (T[] t : temps) {
            for (T tchen : t) {
                length++;
            }
        }

        int counter = 0;
        Object[][] temp = new Object[length / 3 + length % 3][3];

        for (int i = 0; i < temps.length; i += 3) {
            T[] tempsUnited = uniteAndSortArrays((T[]) temps[i], (T[]) temps[i + 1], (T[]) temps[i + 2]);
            temp[counter] = tempsUnited;
            counter++;
        }
        // Rekursiver Aufruf
        return sort(temps);
    }

    public static <T extends Comparable<? super T>> T[] fillOneSortedArray(T[] apart) {
        Arrays.sort(apart);
        return apart;
    }


    public static <T extends Comparable<? super T>> T[] uniteAndSortArrays(T[] a1, T[] a2, T[]a3){
        T[] unitedAry = (T[]) new Comparable[a1.length+a2.length+a3.length];

        int l1 = a1.length;
        int l2 = a2.length;
        int l3 = a3.length;

        // src start dest start length
        System.arraycopy(a1,0 , unitedAry, 0, l1);
        System.arraycopy(a2,0 , unitedAry, l1, l2);
        System.arraycopy(a3,0 , unitedAry, l1+l2, l3);

        int a1Cursor, a2Cursor, a3Cursor ;
        a1Cursor=0;
        a2Cursor=0;
        a3Cursor=0;

        for(int i = 0; i<unitedAry.length; i++){
            if (a1Cursor<=3&&a2Cursor<=3&&a3Cursor<=3){ //ACHTUNG: Cursor müssen einzeln abgeprüft werden!!!!
                if(less(a1[a1Cursor], a2[a2Cursor]) && less(a1[a1Cursor],a3[a3Cursor])){
                    // a1 hat das Kleinste Element
                    unitedAry[i] = a1[a1Cursor];
                    a1Cursor++;
                }
                else if(less(a2[a2Cursor], a1[a1Cursor]) && less(a2[a2Cursor],a3[a3Cursor])){
                    //a2 hat das kleinste Element
                    unitedAry[i] = a2[a2Cursor];
                    a2Cursor++;
                }
                else if(less(a3[a2Cursor], a1[a1Cursor]) && less(a3[a3Cursor],a2[a3Cursor])) {
                    // a3 Hat das kleinste Element
                    unitedAry[i] = a3[a3Cursor];
                    a3Cursor++;
                }
                else if(a1[a1Cursor]==a2[a2Cursor]) {
                    // a1=a2
                    unitedAry[i] = a1[a1Cursor];
                    a1Cursor++;
                    // continue; // Schlechter STIL : Ich habs dir doch gesagt ... // NEIN. EFFIZIENTER
                    i++;
                    unitedAry[i] = a2[a2Cursor];
                    a2Cursor++;
                }
                else if(a2[a2Cursor]==a3[a3Cursor]) {
                    // a2=a3
                    unitedAry[i] = a2[a2Cursor];
                    a2Cursor++;
                    i++;
                    unitedAry[i] = a3[a3Cursor];
                    a3Cursor++;
                }
                else if(a1[a1Cursor]==a3[a3Cursor]) {
                    // a1=a3
                    unitedAry[i] = a1[a1Cursor];
                    a1Cursor++;
                    i++;
                    unitedAry[i] = a3[a3Cursor];
                    a3Cursor++;
                    }
                else{
                    // a1=a2=a3
                    unitedAry[i] = a1[a1Cursor];
                    a1Cursor++;
                    i++;
                    unitedAry[i] = a2[a2Cursor];
                    a2Cursor++;
                    i++;
                    unitedAry[i] = a3[a3Cursor];
                    a3Cursor++;
                }
            }
        }
        return unitedAry;
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
