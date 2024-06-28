package Praktikum4;

public class DoubleClassBadHash {
    private double instanzVariable;

    public DoubleClassBadHash(double instanzVariable) {
        this.instanzVariable = instanzVariable;
    }

    public double getZahl(){
        return instanzVariable;
    }

    // 4 A 3.
    @Override
    public int hashCode() {

        // Ziel: eine schlechte Hash-Verteilung erreichen. BSP aus Skript 3.4 - Seite 8 => Modulares Hashing mit 10^k
        int k;
        k = (int) Math.floor(Math.log(instanzVariable)/Math.log(10)); // Bestimme 10er-Potzen der Zahl
        return (int) (instanzVariable % Math.pow(10,k));
    }


}
