package ad_2_4;

public class ArrayUnorderedMaxPQ<K extends Comparable<? super K>> extends ArrayBaseMaxPQ<K> {

    public void insert(K k) {
        if (size() == a.length) resize(2 * N);
        a[N++] = k;
    }

    public K max() {
        if (isEmpty()) throw new EmptyPQException();
        int max = 0;
        for (int i = 1; i < size(); i++) {
            if (less(a[max], a[i])) max = i;
        }
        return (K)a[max];
    }


    public K delMax() {
        if (isEmpty()) throw new EmptyPQException();
        int max = 0;
        for (int i = 1; i < size(); i++) {
            if (less(a[max], a[i])) max = i;
        }
        K maxElem = (K)a[max];
        exch(max, size() - 1);
        a[--N] = null;
        if (N < size() / 4) resize(N / 2);
        return maxElem;
    }


    public static void main(String[] args) {
        String in ="i-P i-Q i-E d- i-X i-A i-M d- i-P i-L i-E d-";
        ArrayUnorderedMaxPQ<String> pq = new ArrayUnorderedMaxPQ<>();
        interprete(pq, in);
    }
}
