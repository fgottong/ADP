package Praktikum3.ad_2_5;

import Praktikum3.ad_2_4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class BottomK {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> minPQ = new MinPQ<>(M+1); // Hier Ändern
        while (!StdIn.isEmpty()) {
            minPQ.insert(new Transaction(StdIn.readLine()));
            if (minPQ.size() > M) minPQ.delMin();
        }
        Stack<Transaction> stack = new Stack<>();
        while (!minPQ.isEmpty()) stack.push(minPQ.delMin());
        for (Transaction t: stack) System.out.println(t);
    }
}

// java Praktikum1.NumberGenerator 100 0 5 | java Praktikum3.ad_2_5.BottomK 10