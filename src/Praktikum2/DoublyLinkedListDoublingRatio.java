package Praktikum2;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoublyLinkedListDoublingRatio {

    private static void count ( int N, int t, double[] times){

        DoublyLinkedList<Integer> testList = new DoublyLinkedList<>();

        Stopwatch timer = new Stopwatch();

        int index=0;

        while (testList.size()<N){
            testList.add(index);
            index ++;
        }

        times[t] = timer.elapsedTime();

    }

    /**
     *
//     * @param args 1. Startanzahl der Elemente 2. Anzahl der Wiederholungen bzw. Verdoppelungen
     */
    public static void client(int M, int repeats) {
        int N = M; // Elemente Anzahl = Problemgröße
        int trials = repeats; // Anzahl der Versuche//Wiederholungen

        double[] times = new double[trials];

       count(N,0,times);

        for (int t = 1; t < trials; t++) {
            N += N;
            count(N, t, times);
            System.out.printf("\n %2d. Durchlauf: N=%d time=%1.3f time ratio=%1.3f\n",t, N, times[t], times[t] / times[t - 1]);

            writeResultsToCSV(t, N, times[t], times[t] / times[t - 1]);

        }
    }


    /**
     * Fabis methode, aber nicht schön, try-with resources fehlt...
     *
     * Benutzen mit:
     * values = Arrays.asList(String.valueOf(nodeCount),
     *                         String.valueOf(egdeCount),
     *                         String.valueOf(generationTime),
     *                         String.valueOf(ownKruskalDuration),
     *                         String.valueOf(gsKruskalDuration));
     *
     * saveDurationMeasurements(todayString + "_Messung_Laufzeit_Durchlauf" + run + ".csv", header, values);
     *
     * @param fileName
     * @param header
     * @param measuerments
     */
    private static void saveDurationMeasurements(String fileName, List<String> header, List<String> measuerments){

        String currentDirectory = System.getProperty("user.dir");
        //System.out.printf("Das aktuelle verzeichnis ist: " + currentDirectory);

        String filePath = currentDirectory+"/"+fileName;
        FileWriter writer = null;
        File measurementFile = null;
        try {
            measurementFile = new File(filePath);
            if (measurementFile.createNewFile()) {
                // Create new File
                writer = new FileWriter(filePath,true);
                writer.write(String.join("\t", header));
                writer.append("\n");
                writer.append(String.join("\t", measuerments));
                writer.append("\n");
                writer.close();
            } else {
                //File already exists
                writer = new FileWriter(filePath,true);
                writer.append(String.join("\t", measuerments));
                writer.append("\n");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static void writeResultsToCSV(int trial, int N, double time, double timeRatio) {
        String fileName = "results.csv";
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


