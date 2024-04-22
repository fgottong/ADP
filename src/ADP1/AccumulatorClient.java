package ADP1;


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
    wir brauchen eine psvm welche die Argumente Zählt und auswertet
    Wir brauchen eine Faktor um zwei verschiedene Klassen zurück zu geben.
    Wir brauchen den SimpleAccumulator - copy paste aus den folien
    WIr bruachen den VisualAccumulator - copy paste aus den folien ?

     */
    public static void main(String[] args) {
        int accuType = Integer.parseInt(args[0]); // Lies beim Programmaufruf welcher Accumulator typ benutz werden soll
        AccumulatorFactory af = new AccumulatorFactory();


    }

}
