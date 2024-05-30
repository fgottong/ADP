package Praktikum2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListClient {
//    a. Fügen Sie Elemente am Ende, am Anfang und in der Mitte der Liste ein.
//    b. Ändern Sie einen Wert an einem Index.
//    c. Löschen Sie Elemente am Anfang, am Ende und in der Mitte der Liste.
//    d. Löschen Sie die Liste vollständig (mit clear).
//    e. Iterieren Sie über die Liste und geben Sie die enthaltenen Elemente aus.
//    f.
//    Erzeugen Sie einen Stream auf der Liste und geben Sie die enthaltenen Elemente aus.
//    g. Wandeln Sie den Inhalt der Liste in ein Array um.


    public static void main(String[] args) {
        //A
        DoublyLinkedList<String> test = new DoublyLinkedList<>();

        test.add(0, "First");
        test.add(test.size(), "Last");

        System.out.println("=".repeat(25)+"2.A a. TEST LIST PRINTED (Elements at first and last place):"+"=".repeat(25));
        System.out.println(test.toString());

        //B
        System.out.println("=".repeat(25)+"b. CHANGING VALUE AT SET INDEX:"+"=".repeat(25));
        test.add(test.size()/2, "Mid");
        System.out.println("BEFORE: " + test.toString());
        test.set(test.indexOf("Mid"), "NewMid");
        System.out.println("AFTER: " + test.toString());

        //C
        System.out.println("=".repeat(25)+"c. DELETING VALUE AT FIRST, LAST AND MID INDEX:"+"=".repeat(25));
        test.add(1, "First Succ");
        test.add(2, "Mid Pre");
        test.add(4, "Mid Succ");
        test.add(5, "Last Succ");
        System.out.println("CURRENT LIST: " + test.toString());
        test.remove(0);
        test.remove(test.size()/2);
        test.remove(test.size()-1);
        //test.remove(test.size()); // Erwarte INdexOut Expe...
        System.out.println("AFTER REMOVAL: " + test.toString());

        //D
        System.out.println("=".repeat(25)+"d. CLEAR LIST:"+"=".repeat(25));
        test.clear();
        System.out.println(test.toString());

        //E
        System.out.println("=".repeat(25)+"e. ITERATING THROUGH LIST:"+"=".repeat(25));
        test.add(0, "First");
        test.add(test.size(), "Last");
        test.add(1, "Mid");
        test.add(1, "First Succ");
        test.add(2, "Mid Pre");
        test.add(4, "Mid Succ");
        test.add(5, "Last Succ");
        System.out.println("CURRENT LIST: " + test.toString());
        System.out.println("ITERATING THROUGH LIST:");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).toString());
        }

        //F
        System.out.println("=".repeat(25)+"f. STREAMING LIST:"+"=".repeat(25));
        System.out.println(test.stream().toString());



        //    g. Wandeln Sie den Inhalt der Liste in ein Array um.
        System.out.println("=".repeat(25)+"g. Liste zu Array:"+"=".repeat(25));

        String output = Arrays.stream(test.toArray()).map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("%s",output);

        System.out.println();



        //    h. Wandeln Sie eine Menge und eine ArrayList in eine DoublyLinkedList um. (Dazu
        //    benötigen wir den verallgemeinerten Kopier-Konstruktor!)
        Set<Integer> testMenge = Set.of(1,2,3,4,5,7,8,9,0);
        List<String> testAryList = Arrays.asList("Karl","Susi","Heinz","moin moin","Beste","Abgabe","ever");
        DoublyLinkedList<Integer> mengenListe = new DoublyLinkedList<>(testMenge);
        DoublyLinkedList<String> listFromAryList = new DoublyLinkedList<>(testAryList);

        System.out.println("=".repeat(25)+"h. Menge zu Liste:"+"=".repeat(25));
        System.out.printf("Orginal Menge: %s\n",testMenge);
        System.out.printf("Resultierende liste: \n");
        System.out.printf("%s\n",mengenListe);

        System.out.println("=".repeat(25)+"AryList zu Liste:"+"=".repeat(25));
        System.out.printf("Orginal Menge: %s\n",testAryList.stream().collect(Collectors.joining("; ")));
        System.out.printf("Resultierende liste: \n");
        System.out.printf("%s\n",listFromAryList);

        //2.A.2
        System.out.println("=".repeat(25)+"2.A2 1. VERDOPPLUNGSTEST MIT GEWICHTETEN ZEITEN:"+"=".repeat(25));
        //String[] params = new String[] {"1000","12","LinkedList"};
        //DoublyLinkedListDoublingRatio.main(params);
        DoublyLinkedListDoublingRatio.client(1000, 9,"DoublyLinkedList");
    }





}





