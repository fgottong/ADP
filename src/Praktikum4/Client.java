package Praktikum4;
import java.util.*;

// 4 A 3.

public class Client {

    public static void main(String[] args) {
        int counterFive = 0;
        int doubler = 10000;
        int maxValue = 25000;


        //   Hash    Anzahl
        Map<Integer,Integer> goodHashMap = new HashMap<>();
        Map<Integer,Integer> badHashMap = new HashMap<>();


        while (counterFive<5) {
            counterFive ++;
            doubler = doubler * 2;
            double[] ary = prodNumbers(doubler,0,maxValue);
            long startBad = System.nanoTime();
            for (int i = 0; i < ary.length; i++) {
                DoubleClassBadHash dcbh = new DoubleClassBadHash(ary[i]);
                if(!badHashMap.containsKey(dcbh.hashCode())) {
                    badHashMap.put(dcbh.hashCode(), 0);
                }
                badHashMap.put(dcbh.hashCode(), badHashMap.get(dcbh.hashCode()) + 1);
            }
            long endBad = System.nanoTime();
            System.out.println("Timer for bad Hashing:  "+(endBad-startBad)+" ns");

            long startGood = System.nanoTime();
            for (int i = 0; i < ary.length; i++) {
                DoubleClassGoodHash dcgh = new DoubleClassGoodHash(ary[i]);
                if(!goodHashMap.containsKey(dcgh.hashCode())) {
                    goodHashMap.put(dcgh.hashCode(), 0);
                }
                goodHashMap.put(dcgh.hashCode(), goodHashMap.get(dcgh.hashCode()) + 1);

            }
            long endGood = System.nanoTime();
            System.out.println("Timer for good Hashing: "+(endGood-startGood)+" ns"+"\n");
        }


        System.out.printf("Good HashMap: %d\n",goodHashMap.size());
        System.out.printf("Bad HashMap: %d\n",badHashMap.size());


       // System.out.printf("GoodHashMap: %s\n",
       //         goodHashMap.entrySet().stream().map(e -> e.getKey()+": "+e.getValue()).collect(Collectors.joining("\n"))
       //         );
        System.out.printf("GoodHashMap: Size: %s maxCount: %s minCount: %s\n",
                goodHashMap.size(),
                goodHashMap.values().stream().mapToInt(Integer::intValue).max(),
                goodHashMap.values().stream().mapToInt(Integer::intValue).min()
//                integerStream.mapToInt(Integer::intValue).max();
        );
        System.out.printf("BadHashMap: Size: %s maxCount: %s minCount: %s\n",
                badHashMap.size(),
                badHashMap.values().stream().mapToInt(Integer::intValue).max(),
                badHashMap.values().stream().mapToInt(Integer::intValue).min()
//                integerStream.mapToInt(Integer::intValue).max();
        );

    }

    private static double[] prodNumbers(int N, double min, double max) {
        Random rand = new Random(12345);
        double ary[] = new double[N];
        for(int i = 0; i < N; ++i) {
            ary[i] = rand.nextDouble(min, max + 1.0);
        }
        return ary;

    }

}
