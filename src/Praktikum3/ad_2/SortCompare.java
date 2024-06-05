package ad_2;

import edu.princeton.cs.algs4.*;

import java.util.HashSet;
import java.util.Set;

public class SortCompare {

    private static double time(Sorter alg, Double[] a) throws ReflectionException {
        Stopwatch timer = new Stopwatch();
        SortClassWrapper.doSort(alg, a);
        return timer.elapsedTime();
    }

    private static Double[] genData(int length){
        Set<Double> controlSet = new HashSet<>();
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++) {
            double d = StdRandom.uniform();
            while (!controlSet.add(d)) {
                d = StdRandom.uniform();
            }
            a[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws ReflectionException {
        Sorter alg1 = Sorter.valueOf(args[0]);
        Sorter alg2 = Sorter.valueOf(args[1]);
        int N = Integer.parseInt(args[2]);
        int repeat = Integer.parseInt(args[3]);
        compare(alg1, alg2, N, repeat);
    }

    private static void compare(Sorter alg1, Sorter alg2, int length, int repeat) throws ReflectionException {
        for (int i = 1; i < repeat; i++) {
            Double[] data = genData(length);
            double t1 = time(alg1, data.clone());
            StdOut.printf("Sort of %s done in %.5f ms\n", alg1, t1);
            double t2 = time(alg2, data.clone());
            StdOut.printf("Sort of %s done in %.5f ms\n", alg2, t2);
            StdOut.printf("For %d random Doubles %s is %1.1f times faster than %s\n", length, alg1, t2 / t1, alg2);
        }
    }
}
