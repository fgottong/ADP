package Praktikum3.ad_2_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MaxPQHeap<Key extends Comparable<? super Key>> {

    private Key[] pq;

    private int N = 0; // in pq[1..N] 0 wird nicht verwendet

    public MaxPQHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MaxPQHeap(Key[] keys, int N) {
        pq = keys;
        this.N = N;
    }

    public MaxPQHeap(Key[] keys) {
        this(keys.length);
        for (Key key : keys) {
            insert(key);
        }
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        //draw(0);
        swim(N);
    }

    public Key delMax() {
        //draw(0);
        Key max = pq[1];
        exch(1, N--);
        //draw(1);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public Key max() {
        return pq[1];
    }

    private void swim(int k) {
        int ct=0;
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            //draw(++ct);
            k = k / 2;
        }
    }

    private void sink(int k) {
        int ct=1;
        while (2 * k <= N) {
            int j = 2 * k; // Kindknoten Index
            if (j < N && less(j, j + 1)) j++; // wähle den Kindknoten mit dem größeren Schlüssel
            if (less(j, k)) break;
            exch(k, j);
            //draw(++ct);
            k = j;
        }
    }

    public String nodes() {
        StringBuilder sb = new StringBuilder("n ");
        for (int i = 1; i < N + 1; i++) {
            sb.append(pq[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String edges() {
        StringBuilder sb = new StringBuilder("e ");
        if (size() == 1) {
            sb.append(pq[1]);
            return sb.toString();
        }
        for (int i = 1; 2*i <= N ; i ++) {
            sb.append(pq[i] + "-" + pq[2 * i] + " ");
            if (2*i+1 <=N) sb.append(pq[i] + "-" + pq[2 * i + 1] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void show() {

        Key[] ary = Arrays.copyOfRange(pq, 1, N + 1);
        MaxPQHeap<Key> qu = new MaxPQHeap<>(ary);

        Stack<Key> st = new Stack<>();
        while (!qu.isEmpty()) {
            st.push(qu.delMax());
        }
        while (!st.isEmpty()) StdOut.print(st.pop());
        StdOut.println();
    }

    public void draw(String explain) {
        System.out.println(explain);
        System.out.println(nodes());
        System.out.println(Arrays.toString(pq));
        System.out.println(edges());
    }

    public static void main(String[] args) {
        String[] pqData = Arrays.copyOf(new String[]{null, "T", "P", "R", "N", "H", "O", "A", "E", "I", "G"},15);
        //MaxPQHeap maxPQ = new MaxPQHeap(pqData, 10);

        MaxPQHeap maxPQ = new MaxPQHeap(15);

        System.out.println(maxPQ.nodes());
        System.out.println(maxPQ.edges());
        insertDraw(maxPQ,"P", 1);
        insertDraw(maxPQ,"Q", 2);
        insertDraw(maxPQ, "E", 3);
        delMaxDraw(maxPQ, 4 );
        insertDraw(maxPQ,"X",5);
        insertDraw(maxPQ, "A",6);
        insertDraw(maxPQ,"M",7);
        delMaxDraw(maxPQ,8);
        insertDraw(maxPQ,"P",9);
        insertDraw(maxPQ,"L",10);
        insertDraw(maxPQ,"E",11);
        delMaxDraw(maxPQ,12);

    }
    private static void delMaxDraw(MaxPQHeap maxPQ, int step) {
        maxPQ.delMax();
        maxPQ.draw(step +": DelMax");
    }


    private static void insertDraw(MaxPQHeap pq, String elem, int step){
        pq.insert(elem);
        pq.draw(step +": Insert "+ elem);
    }
}
