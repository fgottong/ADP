package Praktikum2;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import java.text. SimpleDateFormat ;
import java.util.Date;

public class QuickUnionClient {

    public static void main(String[] args) {


        QuickUnion qu = new QuickUnion(10);

        System.out.printf("Initial Tree: ----------------\n%s\n------------------------------\n------------------------------\n", qu);


        qu.union(2, 1);
        qu.union(1, 3);
        qu.union(6, 9);
        qu.union(4, 7);
        qu.union(5, 8);
        qu.union(1, 5);
        qu.union(0, 1);
        qu.union(1, 8);
        qu.union(9, 1);
        qu.union(8, 2);
        qu.union(8, 3);
        qu.union(8, 4);

//        qu.compress();

        System.out.printf("After union: -----------------\n[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\n%s\n", qu);


        // BEFORE COMPRESSION

        /*
        * Wir:
        * After union: -----------------
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            [1, 3, 1, 8, 7, 8, 9, 7, 7, 8]
        * */

        /* Wendholt
        * After union: -----------------
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            [1, 3, 1, 8, 7, 8, 9, 7, 7, 8]
        * */


        // AFTER COMPRESSION

//        After union: -----------------
//        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//        [8, 8, 8, 8, 7, 8, 9, 7, 7, 8]
        System.out.println("\n\n");

        QuickUnion qu_worst = new QuickUnion(9);

        System.out.printf("Initial Worst Tree: ---------\n%s\n------------------------------\n------------------------------\n", qu_worst);


        qu_worst.union(0, 1);
        qu_worst.union(0, 2);
        qu_worst.union(0, 3);
        qu_worst.union(0, 4);
        qu_worst.union(0, 5);
        qu_worst.union(0, 6);
        qu_worst.union(0, 7);
        qu_worst.union(0, 8);

        //qu_worst.compress();

//        qu_worst.find(0);
//        qu_worst.find(1);
//        qu_worst.find(2);
//        qu_worst.find(3);
//        qu_worst.find(4);
//        qu_worst.find(5);
//        qu_worst.find(6);
//        qu_worst.find(7);
//        qu_worst.find(8);

        System.out.printf("After union: -----------------\n[0, 1, 2, 3, 4, 5, 6, 7, 8]\n%s\n", qu_worst);

        System.out.println("Laufzeitmessungen: ----------------------------------------");
        // FG: 2024-06-05:
        // Resultate werden in den Unterordner Results geschrieben.
        // Dort liegt auch ein Jupyter/Python Notebook für die Auswertung,
        int nodesCount = 100;
        int repeatitions = 12;
        doublingTest(nodesCount,repeatitions,false);
        doublingTest(nodesCount,repeatitions,true);

    }

    /**
     * Erzeugt eine Liste von Integer Paaren
     * Als Knoten für den Graphen für die Verdoppelungstest von QuickUnion.
     * @param amountOfNodes - Anzahl der Knoten die im Graphen enthalten sein sollen
     * @return Liste der Knotenpaare, also Kanten, welche den Graphen bilden
     */
    public static List<int[]> generateNodes(int amountOfNodes) {
        Random rand = new Random(336699); // Damit immer die Selben Knoten und Kanten erzeugt werden.
        List<int[]> nodeList = new ArrayList<>();
        int[] pair;
        for (int i = 0; i < amountOfNodes; i++) {
            pair = new int[]{rand.nextInt(0, amountOfNodes), rand.nextInt(0, amountOfNodes)};
            nodeList.add(pair);
        }
        return nodeList;
    }


    /**
     * Führt Verdoppelungstest für die QUickUnion Implementierungen durch.
     * Verglichen werden QU mit und ohne Kompression.
     *
     * @param N - initiale Anzahl der Knoten im Graphen
     * @param repeats - Anzahl der Wiederholungen//Verdoppelungen
     * @param compression - mit oder Ohne Kompression
     */
    public static void doublingTest(int N, int repeats, boolean compression) {

        double[] times = new double[repeats];

        count(N,0,times,compression,false);


        System.out.printf("\n Mit Kompression: %b\n",compression);
        for (int t = 1; t < repeats; t++) {
            N += N;
            count(N, t, times,compression,false);
            System.out.printf("\n %2d. Durchlauf: N=%d time=%1.3f time ratio=%1.3f\n", t, N, times[t], times[t] / times[t - 1]);
            writeResultsToCSV(t, N, times[t], times[t] / times[t - 1],compression);
        }


    }

    /**
     * Misst die Laufzeit für eine Gegebene Menge an Konten für die ausführung eine QuickUnion Durchlaufs über alle Paare
     *
     * @param N - Anzahl Knoten
     * @param t - Nummer des Durchlaufs
     * @param times - Ergebnis Array der Laufzeitmessung
     * @param compression - true: mit Kompression, false: ohne Kompression
     * @param verbose - true: Konsolenausgabe, false: keine Konsolenausgabe
     */
    public static void count(int N, int t, double[] times, boolean compression, boolean verbose) {
        QuickUnion qu;
        List<int[]> nodesList;
        double startTime ;
        double stopTime ;
        double currentRunTime;

        nodesList = generateNodes(N);

        if (verbose) {
            String output = nodesList.stream().map(x -> String.format("%2d - %2d", x[0], x[1])).collect(Collectors.joining("\n"));
            System.out.printf("Liste der Knoten ist : \n%s", output);
            System.out.println();
        }


        if (compression) {
            // Laufzeitmessung für Komprimierenden Quick Union
            qu = new QuickUnion(N);
            startTime = System.nanoTime();
            for (int[] pair : nodesList) {
                qu.unionCompressed(pair[0], pair[1]);
            }
            stopTime = System.nanoTime();
            currentRunTime = stopTime - startTime;


        } else {
            // Laufzeitmessung für normalen Quick Union
            qu = new QuickUnion(N);
            startTime = System.nanoTime();
            for (int[] pair : nodesList) {
                qu.union(pair[0], pair[1]);
            }
            stopTime = System.nanoTime();
            currentRunTime = stopTime - startTime;


        }

        times[t]=currentRunTime;

        if(verbose){
            System.out.printf("Laufzeit für %d Knoten " + (compression?"mit":"ohne") + " Kompression: %10.1f\n", N, currentRunTime);
        }


    }


    /**
     * Schreibt die Ergebnisse der Laufzeitmessung in eine CSV datei.
     *
     * @param trial - Durchlaufnummer
     * @param N - Anzahl der Knoten
     * @param time - Laufzeit
     * @param timeRatio - Laufzeitverhältniss
     * @param compression - true: Komprimierender Algorithmus, false: Normaler Quickunion
     */
    public static void writeResultsToCSV(int trial, int N, double time, double timeRatio, boolean compression) {
        //Zeitstempel der Datei
        SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        String todayString = df.format(new Date ());

        //Dateiname
        String fileName =todayString +"_results_QuickUnion_"+(compression?"with":"without")+"_compression.csv";

        //Unterordner
        String filePath="./Results/";
        fileName=filePath+fileName;


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            if (trial == 1) {
                // Write header only once
                bufferedWriter.write("Trial,N,Time,Time Ratio");
                bufferedWriter.newLine();
            }
            bufferedWriter.write(trial + "," + N + "," + time + "," + timeRatio);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Schade - beim Schreiben der Ergebnisdatei ist ein fehler aufgetreten...");
            System.err.println(e.getMessage());
        }
    }

}
