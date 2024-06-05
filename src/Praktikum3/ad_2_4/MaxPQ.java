package ad_2_4;


public class MaxPQ<Key extends Comparable<Key>> extends ArrayPQ<Key> {

    public MaxPQ(){
        this(10);
    }
    public MaxPQ(int max){
        super(max);
    }

    public MaxPQ(Key[] a){
       super(a);
    }

    public Key max(){
        if (isEmpty()) throw new EmptyPQException();
        Key max = (Key)intern[0];
        for (int i =1; i < size() ; i++) {
            if (less(max,get(i))) max = get(i);
        }
        return max;
    }

    public Key delMax(){
        if (isEmpty()) throw new EmptyPQException();
        int max = 0;
        for (int i =1; i < size() ; i++) {
            if (less(get(max),get(i))) max = i;
        }
        exch(intern,max,size()-1);
        return pop();
    }

}

