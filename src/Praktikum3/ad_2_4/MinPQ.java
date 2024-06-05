package ad_2_4;

public class MinPQ<Key extends Comparable<Key>> extends ArrayPQ<Key> {

    public MinPQ(){
        this(10);
    }
    public MinPQ(int max){
        super(max);
    }
    public MinPQ(Key[] a){
        super(a);
    }

    public Key min(){
        if (isEmpty()) throw new EmptyPQException();
        Key min = get(0);
        for (int i =1; i < size() ; i++) {
            if (less(get(i),min)) min = get(i);
        }
        return min;
    }

    public Key delMin(){
        if (isEmpty()) throw new EmptyPQException();
        int min = 0;
        for (int i =1; i < size() ; i++) {
            if (less(get(i),get(min))) min = i;
        }
        exch(intern,min,size()-1);
        return pop();
    }
}

