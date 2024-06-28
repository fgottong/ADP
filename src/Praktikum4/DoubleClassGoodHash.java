package Praktikum4;

public class DoubleClassGoodHash {
    private double instanzVariable;

    public DoubleClassGoodHash(double instanzVariable) {
        this.instanzVariable = instanzVariable;
    }

    public double getZahl(){
        return instanzVariable;
    }

    // 4 A 3.
    @Override
    public int hashCode() {
       return Double.hashCode(instanzVariable);
    }

}