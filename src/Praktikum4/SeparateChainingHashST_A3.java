package Praktikum4;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST_A3<Key,Val> implements STInterface<Key,Val> {
    private int N;
    private int M;
    private SequentialSearchST<Key,Val>[] st;
    public SeparateChainingHashST_A3(int M){
        this.N = 0;
        this.M = M;
        st = (SequentialSearchST<Key,Val>[])new SequentialSearchST[M];
        for (int i = 0; i < M ; i++){
            st[i] = new SequentialSearchST<>();
        }
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff)%M;
    }
    public void put(Key key, Val val){
        st[hash(key)].put(key,val);
    }
    public Val get(Key key){
        return st[hash(key)].get(key);
    }
}