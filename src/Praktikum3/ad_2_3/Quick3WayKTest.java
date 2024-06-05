package Praktikum3.ad_2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashSet;
import java.util.Set;

public class Quick3WayKTest {

    public static void main(String[] args) {
        int N  = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int repeat = Integer.parseInt(args[2]);
        StdOut.printf("%10s %10s %10s %9s %11s\n","Quick3Way","N","kk","total(ms)", "average(ms)");
        for (int kk=k ; kk >0; kk-=10) {
           double totalTime = timeRandomInput(N,kk,repeat);
            StdOut.printf("%10s %10d %10d %9.1f %9.1f\n","Quick3Way",
                    N,kk,totalTime,totalTime/repeat);
        }
    }


    private static double timeRandomInput(int N, int k, int repeat){
        Integer[] a = generateData(N,k);
        double time=0.0;
        for (int i=0; i< repeat; i++) {
            time+=time(a);
        }
        return time;
    }

    private static double time(Integer[] a){
        Stopwatch timer = new Stopwatch();
        Quick3Way.sort(a);
        return timer.elapsedTime();
    }

    private static Integer[] generateData(int n, int k) {
        Integer[] a = new Integer[n];
        int MAX= 1000;
        Set<Integer> control = new HashSet<>();
        for (int i =0; i < k; i++){
            int val = StdRandom.uniform(0,MAX);
            while (!control.add(val)) {
                val = StdRandom.uniform(0,MAX);
            }
            a[i]=val;
        }
        for (int i=k; i <n; i++){
            a[i]=a[StdRandom.uniform(k)];
        }
        return a;
    }
}
