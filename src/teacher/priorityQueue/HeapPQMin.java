package ch.unifr.algo2023.teacher.priorityQueue;

import ch.unifr.algo2023.teacher.sort.GenericSort;

import java.util.Iterator;
import java.util.Random;

public class HeapPQMin<T extends Comparable<? super T>> implements IPriorityQueueMin<T>, Iterable<T> {

    T[] pq;
    int N; // amount of objects in tree
    final int minSize;

    @SuppressWarnings("unchecked")
    public HeapPQMin(int minSize) {
        pq = (T[]) new Comparable[minSize + 1];
        this.minSize = minSize;
        N = 0;
    }

    @Override
    public void insert(T v) {
        if (N + 1 == pq.length) {
            resize(2 * pq.length);
        }
        pq[++N] = v; //be aware: we start with 1! pq[0] is null.
        swim(N);
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        } else {
            return pq[1];
        }
    }

    @Override
    public T delMin() {
        if (isEmpty()) {
            return null;
        } else {
            T minEl = pq[1];
            exch(1, N--);
            pq[N + 1] = null; // avoid loitering
            sink(1);
            if (pq.length > minSize && N > 1 && N + 1 == pq.length / 4) {
                resize(Math.max(minSize, pq.length / 2));
            }
            return minEl;
        }
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private boolean larger(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && larger(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && larger(j, j + 1)) {
                j++;
            }
            if (!larger(k, j)) {
                break;
            }
            // continues if k > j
            exch(k, j);
            k = j;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 1;

            @Override
            public boolean hasNext() {
                return current <= N;
            }

            @Override
            public T next() {
                T currElement = pq[current];
                current += 1;
                return currElement;
            }
        };
    }

    protected void resize(int maxCapa) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[maxCapa + 1];
        for (int i = 1; i < pq.length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void assertHeapOrientation() {
        for (int i = 1; i < N / 2; i++) {
            assert GenericSort.less(pq[i], pq[i * 2]);
            assert GenericSort.less(pq[i], pq[i * 2 + 1]);
        }
    }


    public static void main(String[] args) {
        HeapPQMin<Integer> pq = new HeapPQMin<>(6);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            pq.insert(random.nextInt());
        }

        pq.assertHeapOrientation();
    }

}
