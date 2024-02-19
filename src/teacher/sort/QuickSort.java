package ch.unifr.algo2023.teacher.sort;

import ch.unifr.algo2023.teacher.tools.Shuffle;

public class QuickSort {

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        int N = array.length;

        Shuffle.shuffle(array); // Shuffles the array, eliminates dependence on input
        sort(array, 0, N - 1);
        assert GenericSort.isSorted(array);
    }

    private static <T extends Comparable<? super T>> void sort(T[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(array, lo, hi);
        // System.out.println("lo=" + lo + "\t hi=" + hi + "\t j=" + j);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);

    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (GenericSort.less(array[++i], array[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (GenericSort.less(array[lo], array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            GenericSort.exch(array, i, j);
        }

        GenericSort.exch(array, lo, j);
        return j;
    }

}
