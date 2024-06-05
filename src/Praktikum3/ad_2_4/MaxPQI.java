package ad_2_4;

public interface MaxPQI<K extends Comparable<? super K>> {

    void insert(K k);
    K max();
    K delMax();
    boolean isEmpty();
    int size();
    void show();
}
