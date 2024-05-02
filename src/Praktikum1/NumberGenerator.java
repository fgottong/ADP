package Praktikum1;

import java.util.Random;

public class NumberGenerator {

    public static void main(String[] args) {
        //NumberGenerator numGen = new NumberGenerator(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));


        //System.out.println(2);
        //for (Number n : numGen.getAry()){
        //    System.out.printf("%s ",n);
       // }
    prodNumbers(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
    }

    private static void prodNumbers(int N, double min, double max) {
        Random rand = new Random(12345);
        for(int i = 0; i < N; ++i) {
            if (rand.nextBoolean()) {
                //this.ary[i] = this.rand.nextDouble(min, max + 1.0);
                System.out.println(rand.nextDouble(min, max + 1.0));
            } else {
                //this.ary[i] = this.rand.nextInt((int)min, (int)max + 1);
                System.out.println(rand.nextInt((int)min, (int)max + 1));
            }
        }

    }
}