package Praktikum2;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoublyLinkedListDoublingRatio {

    /**
     * Für den Bestimmten Listentype, werden N elemente in eine Leere Liste eingefügt.
     * Dabei wird die Laufzeit gemessen.
     * Die Laufzeitmessung wird in das Array times eingetragen.
     *
     * @param N
     * @param t
     * @param times
     * @param listType
     */
    private static void count(int N, int t, double[] times,String listType) {

        AbstractList<Integer> testList = (listType.equals("DoublyLinkedList"))? new DoublyLinkedList<>():new LinkedList<Integer>();

        //DoublyLinkedList<Integer> testList = new DoublyLinkedList<>();



        int index = 0;

        while (testList.size() < N) {
            testList.add(index);
            index++;
        }
        Stopwatch timer = new Stopwatch();

        for(int i: testList){}

        times[t] = timer.elapsedTime();

    }

    /**
     * Führt für die Angebene Problemgröße (N) und anzahl der Wdh (repeats) Laufzeitmessungen an Listen durch.
     * 1. Argument: Problemgröße N (Anzahl der Elemente)
     * 2. Argument: Anzahl der wiederholungen und Verdoppelungen
     * 3. Argument: ListenType: Entweder "DoublyLinkedList" für die EigenImplementierung der DLL,
     *              Oder anderes Argument, führt immer zur Java LinkedList.
     *
     *
     * @param args 1. Startanzahl der Elemente 2. Anzahl der Wiederholungen bzw. Verdoppelungen 3. Listen Type
     */
    public static void client(int M, int repeats, String listType) {
        int N = M; // Elemente Anzahl = Problemgröße
        int trials = repeats; // Anzahl der Versuche//Wiederholungen

        double[] times = new double[trials];

        count(N, 0, times, listType);

        System.out.printf("\n Listen Typ: %s\n",listType);
        for (int t = 1; t < trials; t++) {
            N += N;
            count(N, t, times,listType);
            System.out.printf("\n %2d. Durchlauf: N=%d time=%1.3f time ratio=%1.3f\n", t, N, times[t], times[t] / times[t - 1]);

            writeResultsToCSV(t, N, times[t], times[t] / times[t - 1],listType);

        }
    }

    public static void main(String[] args) {

        if (args.length == 2) {
            client(Integer.parseInt(args[0]), Integer.parseInt(args[0]),"DoublyLinkedList");
        } else if (args.length == 3) {
            client(Integer.parseInt(args[0]), Integer.parseInt(args[0]), args[3]);
        }

    }


    /**
     * Fabis methode, aber nicht schön, try-with resources fehlt...
     * <p>
     * Benutzen mit:
     * values = Arrays.asList(String.valueOf(nodeCount),
     * String.valueOf(egdeCount),
     * String.valueOf(generationTime),
     * String.valueOf(ownKruskalDuration),
     * String.valueOf(gsKruskalDuration));
     * <p>
     * saveDurationMeasurements(todayString + "_Messung_Laufzeit_Durchlauf" + run + ".csv", header, values);
     *
     * @param fileName
     * @param header
     * @param measuerments
     */
    private static void saveDurationMeasurements(String fileName, List<String> header, List<String> measuerments) {

        String currentDirectory = System.getProperty("user.dir");
        //System.out.printf("Das aktuelle verzeichnis ist: " + currentDirectory);

        String filePath = currentDirectory + "/" + fileName;
        FileWriter writer = null;
        File measurementFile = null;
        try {
            measurementFile = new File(filePath);
            if (measurementFile.createNewFile()) {
                // Create new File
                writer = new FileWriter(filePath, true);
                writer.write(String.join("\t", header));
                writer.append("\n");
                writer.append(String.join("\t", measuerments));
                writer.append("\n");
                writer.close();
            } else {
                //File already exists
                writer = new FileWriter(filePath, true);
                writer.append(String.join("\t", measuerments));
                writer.append("\n");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static void writeResultsToCSV(int trial, int N, double time, double timeRatio, String listType) {
        String fileName = "results_"+listType+".csv";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            if (trial == 1) {
                // Write header only once
                bufferedWriter.write("Trial,N,Time,Time Ratio");
                bufferedWriter.newLine();
            }
            bufferedWriter.write(trial + "," + N + "," + time + "," + timeRatio);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


