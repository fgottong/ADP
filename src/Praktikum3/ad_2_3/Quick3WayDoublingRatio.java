package ad_2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashSet;
import java.util.Set;

public class Quick3WayDoublingRatio {

    public static void main(String[] args) {
        int N = 1000;
        int[] steps = {320,160, 80, 40, 20, 10, 5};
        int repeat = Integer.parseInt(args[0]);
        StdOut.printf("%7s %3s %5s %5s %3s\n", "N", "k", "ttl", "vrg", "rt");
        for (int kk : steps) {
            N=1000;
            double prevTime = timeRandomInput(N, kk, repeat);
            StdOut.printf("%7d %3d %5.1f %5.1f %3.1f\n", N, kk, prevTime, prevTime / repeat, 0.0);
            for (N=2000; N <= 3000000; N += N) {
                double totalTime = timeRandomInput(N, kk, repeat);
                StdOut.printf("%7d %3d %5.1f %5.1f %3.1f\n", N, kk, totalTime, totalTime / repeat,totalTime/prevTime);
                prevTime=totalTime;
            }
        }
    }


    private static double timeRandomInput(int N, int k, int repeat) {
        Integer[] a = generateData(N, k);
        double time = 0.0;
        for (int i = 0; i < repeat; i++) {
            time += timeTrial(a);
        }
        return time;
    }

    private static double timeTrial(Integer[] a) {
        Stopwatch timer = new Stopwatch();
        Quick3Way.sort(a);
        return timer.elapsedTime();
    }

    private static Integer[] generateData(int n, int k) {
        Integer[] a = new Integer[n];
        int MAX = 1000;
        Set<Integer> control = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int val = StdRandom.uniform(0, MAX);
            while (!control.add(val)) {
                val = StdRandom.uniform(0, MAX);
            }
            a[i] = val;
        }
        for (int i = k; i < n; i++) {
            //a[i] = a[StdRandom.uniform(k)]; // nicht gleichverteilt, wähle zufällig einen Schlüssel aus dem Bereich (0..k-1)
            //a[i] = a[i%k]; // gleichverteilt
        }
        return a;
    }
}
