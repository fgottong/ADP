package ad_2_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int N; // Anzahl der Elemente
    private int[] qp; // Position des Index in der Priority-Warteschlange
    private int[] pq; // Priority-Warteschlange der Indizes
    private Key[] keys; // Array mit Schlüsseln, die über den Index in pq gefunden werden

    public IndexMinPQ(int maxN) {
        qp = new int[maxN + 1];
        pq = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    // Konvention, wenn ein Index nicht in der Warteschlange ist, dann liefert qp -1 zurück
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        N++; // neue Position
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;  // speichert die Keys unter dem Index k
        swim(N);
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        qp[k] = -1;
        keys[k] = null;
    }

    public int delMin() {
        int minIndex = pq[1];
        exch(1, N--);
        sink(1); // reorganisieren
        keys[minIndex] = null; // lösche das kleinste Element
        qp[N + 1] = -1; // lösche den Index
        return minIndex;
    }

    public int minIndex() {
        return pq[1];
    }


    private void sink(int k) {
        while (2 * k <= N) {
            int i = 2*k;
            if (i < N && less(i+1, i )) i++;
            if (less(k, i)) break;
            exch(i, k);
            k = i;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k,k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int posI, int posJ) {
        int indexI = pq[posI];
        qp[indexI] = posJ;
        qp[pq[posJ]] = posI;
        pq[posI] = pq[posJ];
        pq[posJ] = indexI;
    }


    public Key get(int index){
        return keys[index];
    }

    public void draw(String title){
        if (isEmpty()) return;
        String[] keyHeap = new String[N+1];
        for (int i=1; i<= N;i++) {
            keyHeap[i] = String.format("%d:%s",pq[i],keys[pq[i]]);
        }
        StdOut.println(Arrays.toString(keyHeap));
        StdOut.println(Arrays.toString(keys));
        StdOut.println(Arrays.toString(pq));
    }

    public static void main(String[] args) {
        IndexMinPQ<String> minPQ = new IndexMinPQ<>(9);
        minPQ.insert(5,"A");
        minPQ.insert(1, "E");
        minPQ.insert(9, "I");
        minPQ.insert(4, "H");
        minPQ.insert(7,"P");
        minPQ.insert(8,"R");
        minPQ.insert(3, "M");
        minPQ.draw("Without Reorg");
        minPQ.insert(2,"D");
        minPQ.draw("Inserted D");

        minPQ.change(4,"B");
        minPQ.draw("changed 4 -> B");
        minPQ.change( 5,"X");
        minPQ.draw("changed 5 -> X");
        minPQ.delete(8);
        minPQ.draw("Deleted 8");

        minPQ.delete(4);
        minPQ.draw("Deleted 4");


    }
}
