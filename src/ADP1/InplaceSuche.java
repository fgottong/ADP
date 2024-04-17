package ADP1;

import java.util.Arrays;
import java.util.Map;

public class InplaceSuche {

    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};

        int[] resultAry1 = {1, 61, 89, 75, 16};


        int[] ary3 = {99,1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] resultAry3 = null;
        int radius3 = 1;

        System.out.println(Arrays.toString(localMax(ary3,radius3)));

    }


    public static int[] localMax(int[] ary, int radius){

        if (ary.equals(null)||ary.length<1) return null;

        return _localMax(ary,radius,0,ary.length);
    }


    /**
     *
     * @param ary
     * @param radius
     * @return
     */
    private static int[] _localMax(int[] ary, int radius, int low, int high){
/**
 * 1. berechne die mitte
 * 2. betrachte die nachbarn
 * 2.2 merk dir den kleinsten nachbarn rechts .
 * 2.2 merk dir den kleinsten nabarn links.
 * 2.1 sind alle nachbarn links kleiner als der aktuelle wert
 * 2.2 sind alle nachbarn rechts kleiner
 * 3. vergleiche die Kleineren Nachbarn - rufe die methode für den kleineren nachbarn auf.
 */
        // Abbruchbedingung
        if (low > high || low == high) return null;


        int currentIndex = low + (int)Math.ceil((high-low)/2);
        int minimumLeft = Integer.MAX_VALUE;
        int minimumRight = Integer.MAX_VALUE;
        boolean allLeftMinor = true;
        boolean allRightMinor = true;

        // Nachbarn Links Betrachten
        for(int i= 1; i<=radius;i++){
            if(ary[currentIndex-i]<minimumLeft) minimumLeft=ary[currentIndex-i]; // merke dir den Kleinsten Linken nachbarn.
            if(ary[currentIndex-i]>ary[currentIndex]) allLeftMinor = false; // ist auf der linkenseite eine größer?
        }

        //Nachbarn Rechts Betrachten
        for(int i = 1; i<=radius;i++){
            if(ary[currentIndex+i]<minimumRight) minimumRight=ary[currentIndex+i]; // merke dir den Kleinsten Rechten nachbarn.
            if(ary[currentIndex+i]>ary[currentIndex]) allRightMinor = false; // ist auf der linkenseite eine größer?
        }

        //Erfolgsfall: der aktuelle Index ist ein Lokales Maximum, alle nachbarn im Radius sind kleiner.
        if(allLeftMinor && allRightMinor) return Arrays.copyOfRange(ary,currentIndex-radius,currentIndex+radius+1);

        //Fehlerfall: es gibt kein Locales maximum, da der verbebleibdende bereich kleiner als die nachbarschaft ist.
        if(Math.abs(high-low)<=2*radius) return null;

        // Rekursiver aufruf - einer der nachbarn war größer, untersuche die hälfte des arra
        if(minimumLeft<=minimumRight) {
            return _localMax(ary,radius,low,currentIndex);
        }else{
            return _localMax(ary,radius,currentIndex, high);
        }

    }

}
