package Praktikum3.ad_2_5;

import Praktikum3.ad_2_4.MaxPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

// THIS!!!1!
// java -cp . Praktikum1.NumberGenerator 100 0 50 | java -classpath ".;algs4.jar" Praktikum3.ad_2_5.BottomK 10

public class BottomK {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPQ<Double> maxPQ = new MaxPQ<>(M+1); // Hier Ändern
        while (!StdIn.isEmpty()) {
            maxPQ.insert( Double.parseDouble(StdIn.readLine()));
            if (maxPQ.size() > M) maxPQ.delMax();
        }
        Stack<Double> stack = new Stack<>();
        while (!maxPQ.isEmpty()) stack.push(maxPQ.delMax());
        for (Double t: stack) System.out.println(t);
    }
}

// java Praktikum1.NumberGenerator 100 0 5 | java Praktikum3.ad_2_5.BottomK 10