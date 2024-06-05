package ad_2_4;

public class ArrayOrderedMaxPQ<K extends Comparable<? super K>> extends ArrayBaseMaxPQ<K> {


    public ArrayOrderedMaxPQ(){
       super();
    }

    public ArrayOrderedMaxPQ(int max){
      super(max);
    }
    public ArrayOrderedMaxPQ(K[] keys){
       super(keys);
    }

    public void insert(K k){
        if (N==a.length) resize(2*N);
        a[N++]=k;
        for (int i = N-1; i >0; i-- ){
            if (less(a[i],a[i-1])) exch(i,i-1);
        }
    };

    public K max() {
        return (K)a[size()-1];
    };
    public K delMax() {
        K max =(K) a[size()-1];
        a[--N]=null;
        if (N < a.length/4) resize(N/2);
        return max;
    };

    public static void main(String[] args) {
        String in ="i-P i-Q i-E d- i-X i-A i-M d- i-P i-L i-E d- ";
        ArrayOrderedMaxPQ<String> pq = new ArrayOrderedMaxPQ<>();
        interprete(pq, in);
    }

}
