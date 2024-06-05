package ad_2_4;

import edu.princeton.cs.algs4.In;

import static ad_2.SortClassCommons.*;

public class HeapSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int N = a.length;
        // Erstellen eines Heap-geordneten Arrays
        for (int k = N/2; k >=1; k--) {
            sink(a,k,N);
        }
        // Sort-Down
        while (N > 1) {
            // Tausche das größte Element mit dem letzen und stelle mit dem Rest die Heapordnung wieder her
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private static <T extends Comparable<? super T>> void sink(T[] a, int k, int N){
        while(2*k <= N) {
            int j = 2*k;
            if (j < N && less(a[j],a[j+1])) j++;
            if (!less(a[k],a[j])) break;
            exch(a,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
