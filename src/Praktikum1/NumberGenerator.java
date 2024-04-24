package ADP1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * eine Klasse NumberGenerator, die N Zufallszahlen (int und double
 * Werte ) in einem vorgegebenen Intervall [min,max] generiert. N, min und max sollen dem
 * Programm beim Start übergeben werden. int und double Werte sollten ungefähr gleich
 * verteilt sein. NumberGenerator gibt die Zahlen durch Leerzeichen separiert auf der Konsole
 * aus.
 * Aufruf mit : ADP1.NumberGenerator N min max
 * BSP: ADP1.NumberGenerator 10 1 5
 */
public class NumberGenerator {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);

        String[] randomNumbers = new String[N];
        Random rand = new Random();


        for(int i=0; i < N ; i++){
            if(rand.nextBoolean()) {
                randomNumbers[i]=Double.toString(rand.nextDouble(min,max+1)) ;
            }else{
                randomNumbers[i]=Integer.toString(rand.nextInt(min,max+1));
            }
        }


//        StringBuilder outputString = new StringBuilder();
//
//        for(double d: randomNumbers){
//            outputString.append( d );
//            outputString.append(" ");
//        }
//        System.out.println(outputString);


        System.out.println(String.join(" ", randomNumbers));
    }

}
