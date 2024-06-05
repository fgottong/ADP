package ad_2_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class TopM2 {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> minPQ = new MinPQ<>(M+1);
        while (!StdIn.isEmpty()) {
            minPQ.insert(new Transaction(StdIn.readLine()));
            if (minPQ.size() == M+1) minPQ.delMin();
        }
        Stack<Transaction> stack = new Stack<>();
        while (!minPQ.isEmpty()) stack.push(minPQ.delMin());
        for (Transaction t: stack) System.out.println(t);
    }
}
