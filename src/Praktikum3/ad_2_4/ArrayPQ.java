package ad_2_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ArrayPQ<Key extends Comparable<Key>> {
    protected Comparable[] intern;
    private int  N=0;

    public ArrayPQ(){
        this(10);
    }
    public ArrayPQ(int max){
       intern = new Comparable[max];
    }

    public ArrayPQ(Key[] a){
        intern = Arrays.copyOf(a,2*a.length);
        N = a.length;
    }

    public void insert(Key key) {
        if (intern.length == N) resize(2*intern.length);
        intern[N++]=key;
    }

    public int size() {
        return N;
    }

    protected Key pop(){
        Comparable elem = intern[--N];
        intern[N] = null; // avoid loitering
        if (N>0 && N == intern.length/4) resize(intern.length/2);
        return (Key)elem;
    }

    protected Key get(int index){
        if (index < 0 || index >=size()) throw new IndexOutOfBoundsException();
        return (Key)intern[index];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private void resize(int max){
        intern = Arrays.copyOf(intern,max);
    }

    protected boolean less(Comparable a, Comparable b){return a.compareTo(b) < 0;}
    protected void exch(Object[] a, int i, int j) {
        Object t = a[i]; a[i] = a[j]; a[j]=t;
    }

    private static void show(Object[] a) {
        StdOut.println(Arrays.toString(a));
    }

}
