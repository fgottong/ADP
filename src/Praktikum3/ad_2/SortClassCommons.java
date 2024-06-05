package ad_2;

import java.util.Arrays;

public  class SortClassCommons {

    public static <T extends Comparable<? super T>> boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    public static <T extends Comparable<? super T>> void exch(T[]a ,int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static <T> void show(T[] a){
        System.out.println(Arrays.toString(a));
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] a){
        int N = a.length;
        for (int i =1; i <N; i++){
            if (less(a[i],a[i-1])) {
                return false;
            }
        } return true;
    }
}
