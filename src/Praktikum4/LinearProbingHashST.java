package Praktikum4;

public class LinearProbingHashST<Key,Val> implements STInterface<Key,Val> {
    private int N;
    private int M=16;
    private Key[] keys;
    private Val[] vals;
    public LinearProbingHashST(){
        keys = (Key[])new Object[M];
        vals = (Val[])new Object[M];
    }
    private int hash(Key key){return (key.hashCode()& 0x7fffffff)%M;}

    public Val get(Key key){
        int hash = hash(key);
        for (int i=hash; keys[i]!=null; i = (i+1)%M){
            if (keys[i].equals(key)) return vals[i];
        }
        return null;
    }
    public void put(Key key, Val val){
        if (N >= M/2) resize(2*M);
        int i;
        for (i = hash(key); keys[i] != null; i= (i+1)%M){
            if (keys[i].equals(key)) {vals[i]=val; return; }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    private void resize(int i) {
        //TODO
    }
}

//Sollten wir für alle Schlüssel denselben Hashcode vergeben, muss beim Einfügen immer die gesamte Liste, die zu diesem Hashcode
//gehört abgearbeitet werden -> Quadratisches Verhalten
// Rest siehe Notizen