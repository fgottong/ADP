package ad_2_1;

import edu.princeton.cs.algs4.StdOut;

import static ad_2.SortClassCommons.*;

public class ShellWithOutput {

    public static void sort(Comparable[] a){
        int h = 1;
        int N = a.length;
        while (h <N/3) h = 3*h +1; // Folgen 1 4 13 40 121 364 1093
        StdOut.println("Eingabe " + toString(a));
        StdOut.println("h=" + h);
        StdOut.println("a[13] " + a[13]);
        for(; h >= 1; h/=3) {
            for (int i = h; i < N; i++){
                for (int j=i; j >=h && less(a[j],a[j-h]); j-=h){
                    exch(a,j,j-h);
                }
                show(a);
            }
            StdOut.println(h+"-sortiert " + toString(a));
        }
    }

    private static String toString(Object[] a) {
        String s = "";
        for (Object o: a){
            s += o +" ";
        }
        return s;
    }
    public static void main(String[] args) {
        String[] a ;//= new In(args[0]).readAllStrings();
        a = "A U F B R U C H S T I M M U N G".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
