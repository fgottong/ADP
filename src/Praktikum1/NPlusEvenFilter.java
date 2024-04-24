package Praktikum1;

import edu.princeton.cs.algs4.StdIn; // Muss algs4.jar in den Project-structures -> Modules -> Dependencies hinzufügen. Und im der Umgebungsvariablen bis zur jar verknüpfen...

import java.util.InputMismatchException;


/**
 * Klasse, die aus einem Eingabestrom nur die
 * positiven ganzen geraden Zahlen filtert und diese auf der Konsole ausgibt.
 */
public class NPlusEvenFilter {

    public static void main(String[] args) {

        int zahl;

        while (!StdIn.isEmpty()){
            try {
                zahl = StdIn.readInt();
                if(zahl>=0 && zahl%2==0) System.out.printf("%3d\n",zahl);
            } catch (InputMismatchException ime) {
            // Wenn die Zahl kein integer ist mache nichts. Setze einfach mit for fort.
            }
        }
    }
}
