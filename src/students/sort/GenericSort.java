package ch.unifr.algo2023.students.sort;

public class GenericSort {

    public static <T> void sort(T[] array) {
        // empty, use this class as static
    }

    protected static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected static <T extends Comparable<? super T>> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected static <T extends Comparable<? super T>> boolean isSorted(T[] array) {
        return isSorted(array, 0, array.length - 1);
    }

    // is the array sorted from a[lo] to a[hi] (both included)
    public static <T extends Comparable<? super T>> boolean isSorted(T[] array, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
