package ADP1;

import edu.princeton.cs.algs4.Accumulator;

/**
 * Liefert einen Simple oder einen Visual Accumulator zurück
 */
public class AccumulatorFactory {
    public static Accumulator getInstance(int type, int[] args){
        switch (type) {
            case 0:
                return new SimpleAccumulator();
            case 1:
                return new VisualAccumulator();
            default:
                throw new IllegalArgumentException("Unbekannter Accumulatortyp");
        }

    }

}
