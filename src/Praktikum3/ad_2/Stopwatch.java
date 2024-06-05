package ad_2;

public class Stopwatch {

    private long start = 0;

    public Stopwatch(){
        start = System.nanoTime();
    }

    // Vergangene Zeit in Millisekunden
    public double elapsedTime() {
        long now = System.nanoTime();
        return ( now - start)/1.e6;
    }

}
