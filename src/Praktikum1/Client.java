package Praktikum1;


import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

/**
 * Clientklasse AccumulatorClient, die die Daten für die in der
 * Vorlesung gezeigten Klassen SimpleAccumulator und VisualAccumulator aus einem
 * Eingabestrom einliest und an den Akkumulator übergibt. Wird das Programm
 * AccumulatorClient mit 0 aufgerufen, dann wird ein SimpleAccumulator erzeugt, mit
 * einer anderen Zahl im ersten Programmargument wird ein VisualAccumulator erzeugt.
 * Dann muss im 2’ten und 3’ten Programmargument noch die Anzahl der Daten und der
 * maximale Wert angegeben werden. Alternativ berechnen Sie die Werte der x-Achse und den
 * maximalen Wert, indem Sie die Werte von StdIn lesen und in einer Liste zwischenspeichern.
 */
public class AccumulatorClient {

    /* Notizen
    Wir brauchen eine psvm welche die Argumente Zählt und auswertet
    Wir brauchen eine Faktory um zwei verschiedene Klassen zurück zu geben.
    Wir brauchen den SimpleAccumulator - copy paste aus den Folien
    Wir bruachen den VisualAccumulator - copy paste aus den Folien ?

     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[1]);   // Wieviele Zahlen sollen generiert werden.
        int max = Integer.parseInt(args[2]);

        Random rand = new Random();

        // Create new Accumulator based on user's input
        Accumulator accu;
        if (Integer.parseInt(args[0]) == 0) {
            accu = new SimpleAccumulator();
        }
        else {
            accu = new VisualAccumulator(0, 0);
        }

        // Fill accumulator with random numbers
        for (int i =0; i < N; i++) {
            accu.addDataValue(rand.nextDouble(max));
        }


    }


}
