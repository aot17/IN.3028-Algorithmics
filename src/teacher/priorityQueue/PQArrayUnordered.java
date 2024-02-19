package ch.unifr.algo2023.teacher.priorityQueue;

public class PQArrayUnordered<T extends Comparable<? super T>> implements IPriorityQueueMin<T> {

    T[] itemHolder;
    int currentPosition;

    public PQArrayUnordered(int initSize) {
        itemHolder = (T[]) new Comparable[initSize];
        currentPosition = 0;
    }

    @Override
    public void insert(T v) {
        if (currentPosition == itemHolder.length) {
            resize(2 * itemHolder.length);
        }
        itemHolder[currentPosition] = v;
        currentPosition++;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        }
        T min = itemHolder[0];
        for (int i = 1; i < currentPosition; i++) {
            T next = itemHolder[i];
            if (next.compareTo(min) < 0) {
                min = next;
            }
        }
        return min;
    }

    @Override
    public T delMin() {
        if (isEmpty()) {
            return null;
        }
        final int lastElPos = currentPosition - 1;
        T lastEl = itemHolder[lastElPos];
        for (int i = 0; i < lastElPos; i++) { //How to not loop twice
            if (itemHolder[i].compareTo(lastEl) < 0) {
                T newLastEl = itemHolder[i];
                itemHolder[i] = lastEl;
                itemHolder[lastElPos] = newLastEl;
                lastEl = newLastEl;
            }
        }

        // delete last element
        currentPosition--;
        itemHolder[currentPosition] = null;
        // resize if needed
        if (currentPosition > 0 && currentPosition == itemHolder.length / 4) {
            resize(itemHolder.length / 2);
        }
        return lastEl;
    }

    @Override
    public boolean isEmpty() {
        return currentPosition == 0;
    }

    @Override
    public int size() {
        return currentPosition;
    }

    protected void resize(int maxCapa) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[maxCapa];
        for (int i = 0; i < currentPosition; i++) {
            temp[i] = itemHolder[i];
        }
        itemHolder = temp;
    }
}
