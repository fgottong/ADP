package Praktikum2;

public class QuickUnionClient {

    public static void main(String[] args) {


        QuickUnion qu = new QuickUnion(10);

        System.out.printf("Initial Tree: ----------------\n%s\n------------------------------\n------------------------------\n",qu);


        qu.union( 2 ,1);
        qu.union( 1 ,3);
        qu.union( 6, 9);
        qu.union( 4 ,7);
        qu.union( 5 ,8);
        qu.union( 1 ,5);
        qu.union( 0 ,1);
        qu.union( 1 ,8);
        qu.union( 9, 1);
        qu.union( 8, 2);
        qu.union( 8, 3);
        qu.union( 8, 4);

//        qu.compress();

        System.out.printf("After union: -----------------\n[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\n%s\n",qu);


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

        System.out.printf("Initial Worst Tree: ---------\n%s\n------------------------------\n------------------------------\n",qu_worst);


        qu_worst.union( 0 ,1);
        qu_worst.union( 0 ,2);
        qu_worst.union( 0, 3);
        qu_worst.union( 0 ,4);
        qu_worst.union( 0 ,5);
        qu_worst.union( 0 ,6);
        qu_worst.union( 0 ,7);
        qu_worst.union( 0 ,8);

        qu_worst.compress();

//        qu_worst.find(0);
//        qu_worst.find(1);
//        qu_worst.find(2);
//        qu_worst.find(3);
//        qu_worst.find(4);
//        qu_worst.find(5);
//        qu_worst.find(6);
//        qu_worst.find(7);
//        qu_worst.find(8);

        System.out.printf("After union: -----------------\n[0, 1, 2, 3, 4, 5, 6, 7, 8]\n%s\n",qu_worst);


    }
}
