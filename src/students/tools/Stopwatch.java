package ch.unifr.algo2023.students.tools;
//from textbook

public class Stopwatch {

    private final long start;

    public static void main(String[] args) throws InterruptedException {
        //How to use it
        Stopwatch watch = new Stopwatch();

        Thread.sleep(4000);
        double stop1 = watch.elapsedTime();

        Thread.sleep(4000);
        double stop2 = watch.elapsedTime();

    }

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
