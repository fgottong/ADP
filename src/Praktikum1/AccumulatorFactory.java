//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Praktikum1;

import edu.princeton.cs.algs4.Accumulator;

public class AccumulatorFactory {
    public AccumulatorFactory() {
    }

    public static Accumulator getInstance(int type) {
        return switch (type) {
            case 0 -> new SimpleAccumulator();
            case 1 ->  new VisualAccumulator(0, 0.0);
            default -> throw new IllegalArgumentException("Unbekannter Accumulatortyp");
        };

    }
}