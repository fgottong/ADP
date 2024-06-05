package ad_2_4;

public interface MinPQI <K extends Comparable<? super K>> {

    void insert(K k);
    K min();
    K delMin();
    boolean isEmpty();
    int size();
}
