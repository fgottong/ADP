//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Praktikum1;

import edu.princeton.cs.algs4.Accumulator;
import java.util.Random;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);
        Random rand = new Random();
        Accumulator accu;
        if (Integer.parseInt(args[0]) == 0) {
            accu = new SimpleAccumulator();
        } else {
            accu = new VisualAccumulator(0, 0.0);
        }

        fillArray(N, (Accumulator)accu, rand, max);
        System.out.println(((Accumulator)accu).mean());
        System.out.println(((Accumulator)accu).toString());
    }

    private static void fillArray(int N, Accumulator accu, Random rand, int max) {
        NumberGenerator numGen = new NumberGenerator(N, (double)max);
        
        for(Double d: numGen.getAry()) {
            accu.addDataValue(d);
        }

    }
}
