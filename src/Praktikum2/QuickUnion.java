package Praktikum2;

import java.util.Arrays;

public class QuickUnion {

    int count; // Anzahl der Zusammenhangskomponenten

    int[] id; // Array Index = Knoten(ID) und Wert = Wurzelknoten (Verweis auf einen index im selben Array) ;


    /**
     * Geklaut aus UFBase
     * Wendholt original.
     *
     * Erzeugt einen neuen Graphen mit n Knoten.
     * Diese sind zunächst alle Getrennt
     * @param n
     */
    public QuickUnion(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    public boolean connected(int p, int q) {return find(p) == find(q);}
    public int count() {
        return count;
    }

    /**
     * Wendholt Original
     * Liefert den Wurzelknoten für einen Blattknoten
     *
     * @param p
     * @return
     */

//    public int find(int p) {
//        int node = p;
//        while (id[node]!=node) node = id[node];
//        return node;
//        }

    public int find(int p){
        if (p != id[p]){
            id[p] = find(id[p]);
        }

        return id[p];
    }

    public void compress(){
        for (int i = 0; i < id.length; i++){
            find(i);
        }
    }


    /**
     * Wendholt Original
     * Verbindet die Wurzel zweier Blattknoten Fals, diese keine gemeinsame wurzel haben.
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
            count--;
        }
    }


//    public void unionCompressed(int p, int q) {
//        int pRoot = find(p);
//        int qRoot = find(q);
//        if (pRoot != qRoot) {
////            id[pRoot] = q;
//
//            count--;
//        }
//    }

    @Override
    public String toString() {

        return Arrays.toString(id);
    }
}
