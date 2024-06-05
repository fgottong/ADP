package ad_2_4;

import java.util.Arrays;

public abstract class ArrayBaseMaxPQ<K extends Comparable<? super K>> implements MaxPQI<K> {

    protected Object[] a;
    protected int N;

    public ArrayBaseMaxPQ(){
        this.a = new Object[1];
        N=0;
    }

    public ArrayBaseMaxPQ(int max){
        this.a = new Object[max];
        N=0;
    }
    public ArrayBaseMaxPQ(K[] keys){
       this(keys.length);
       for(K k: keys){
           insert(k);
       }
       N=keys.length;
    }

    protected void resize(int newSize) {
        a = Arrays.copyOf(a,newSize);
    }


    protected boolean less(Object x, Object y) {
        return ((K)x).compareTo((K)y) < 0;
    }

    protected void exch(int i, int j) {
        K tmp = (K)a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public boolean isEmpty(){return size()==0;}

    public int size(){return N;}

    public void show() {
        System.out.println(Arrays.toString(Arrays.copyOf(a,size())));
    }

    public static void interprete(MaxPQI pq, String in){
        String[] cmds = in.split(" ");
        for(String cmd: cmds){
            String[] cmdVal = cmd.split("-");
            switch (cmdVal[0]){
                case "i": pq.insert(cmdVal[1]); break;
                case "d": pq.delMax();
            }
            pq.show();
        }
    }

}
