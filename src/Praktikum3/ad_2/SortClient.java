package ad_2;

import edu.princeton.cs.algs4.In;

import static ad_2.SortClassCommons.isSorted;
import static ad_2.SortClassCommons.show;

public class SortClient {

    public static void main(String[] args) throws ReflectionException {
            Sorter alg = Sorter.valueOf(args[0]);
            String[] a = new In().readAllStrings();
            SortClassWrapper.doSort(alg,a);
            assert isSorted(a);
            show(a);
    }
}
