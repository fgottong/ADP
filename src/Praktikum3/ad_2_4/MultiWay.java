package ad_2_4;

import edu.princeton.cs.algs4.In;

// Mehrwege Mischen von Daten aus sortierten Eingabeströmen
public class MultiWay {

    public static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ(N);
        for (int index = 0; index < N; index++){
            if (!streams[index].isEmpty()){
                pq.insert(index,streams[index].readString());
            }
        }

//        pq.draw("Start");
        int ct=0;
        while(!pq.isEmpty()) {
            System.out.printf("%s ", pq.minKey());
            int index = pq.delMin();

            if (!streams[index].isEmpty()) {
                pq.insert(index,streams[index].readString());
            }
//            if (ct <=5 ) {
//                pq.draw("Iteration " + ++ct);
//            }
        }
    }

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for (int i =0; i < N; i++){
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }

}
