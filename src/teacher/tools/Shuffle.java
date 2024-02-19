package ch.unifr.algo2023.teacher.tools;

import java.util.Random;

// This is a Fisher–Yates shuffle
// https://en.wikipedia.org/wiki/Fisher–Yates_shuffle

public class Shuffle {

    private static Random random; // pseudo-random number generator
    private static long seed; // pseudo-random number generator seed

    // static initializer
    static {
        seed = System.currentTimeMillis(); // as in Java 1.4
        random = new Random(seed);
    }

    // don't instantiate
    private Shuffle() {
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i); // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i); // between i and n-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int uniform(int n) {
        return random.nextInt(n);
    }

}
