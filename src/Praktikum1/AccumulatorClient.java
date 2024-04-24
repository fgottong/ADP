//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Praktikum1;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class AccumulatorClient {
    public AccumulatorClient() {
    }

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[1]);
//        int max = Integer.parseInt(args[2]);
        Random rand = new Random();
        Accumulator accu;
        ArrayList<Double> doubleary = new ArrayList<>();

        while (!StdIn.isEmpty()){
            doubleary.add(StdIn.readDouble());
        }

        if (Integer.parseInt(args[0]) == 0) {
            accu = new SimpleAccumulator();
        } else {
            double max = doubleary.stream().max(Comparator.naturalOrder()).get();
            accu = new VisualAccumulator(doubleary.size(), max);
        }

        for(double d: doubleary){
            accu.addDataValue(d);
        }

        //fillArray(N, (Accumulator)accu, rand, max);
        //System.out.println(((Accumulator)accu).mean());

        System.out.println(accu.toString());

    }

    private static void fillArray(int N, Accumulator accu, Random rand, int max) {
        NumberGenerator numGen = new NumberGenerator(N, (double)max);

        for(Number n: numGen.getAry()) {
            accu.addDataValue(n.doubleValue());
        }

    }
}
