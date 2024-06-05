package ad_2_2;

import java.util.Arrays;

import static ad_2.SortClassCommons.*;

public class NaivesMerge {


    public static <T extends Comparable<? super T>> T[] sort(T[] a){
        if (a.length<=1) return a;
        int mid = a.length/2;
        T[] leftSorted = sort(Arrays.copyOf(a,mid));
        T[] rightSorted = sort(Arrays.copyOfRange(a, mid,a.length));
        return merge(leftSorted,rightSorted);
    }

    private static <T extends Comparable<? super T>> T[] merge(T[] left, T[] right ){
        T[] merged =(T[]) new Comparable[left.length+right.length];
        int leftC = 0;
        int rightC = 0;
        for (int i = 0; i <merged.length; i++){
            if (leftC >= left.length) merged[i] = right[rightC++];
            else if (rightC >= right.length) merged[i] = left[leftC++];
            else if (less(right[rightC],left[leftC])) merged[i] = right[rightC++];
            else merged[i] = left[leftC++];
        }
        return merged;
    }

     public static void main(String[] args) {
        String s = "M E R G E S O R T E X A M P L E";
        String[]  in = s.split(" ");
        String[] sorted = sort(in);
        assert isSorted(sorted);
        show(sorted);
    }

}
