package Praktikum4;

import edu.princeton.cs.algs4.SequentialSearchST;

// ADP4

//4 A 1. hashCode Implementierung

public class SeparateChainingHashST<Key,Val> implements STInterface<Key,Val> {
    private int N;  //Anzahl
    private int M;  //Größe
    private SequentialSearchST<Key,Val>[] st;


    public SeparateChainingHashST(int M){  //Erzeuge M-verkettete Listen
        this.N = 0;
        this.M = 1;  //<---------Für Quadratisches Verhalten
        st = (SequentialSearchST<Key,Val>[])new SequentialSearchST[M];
        for (int i = 0; i < M ; i++){
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
    return 1;  //<---------Für Quadratisches Verhalten
}
    public void put(Key key, Val val){
        st[hash(key)].put(key,val);
    }
    public Val get(Key key){
        return st[hash(key)].get(key);
    }
}

//Sollten wir für alle Schlüssel denselben Hashcode vergeben, muss beim Einfügen immer die gesamte Liste, die zu diesem Hashcode
//gehört abgearbeitet werden -> Quadratisches Verhalten
// Rest siehe Notizen
