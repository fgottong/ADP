package ad_2_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;


public class TopM {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M+1); // 1 Element mehr als M für das Entfernen des kleinsten
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size()>M) pq.delMin();  // nur die M-größten Element sind in der PQ
        }
        Stack<Transaction> stack = new Stack<>(); // Sortieren mit einem Stack
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t: stack) StdOut.println(t);
    }
}
