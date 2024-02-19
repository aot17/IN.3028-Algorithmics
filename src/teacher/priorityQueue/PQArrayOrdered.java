package ch.unifr.algo2023.teacher.priorityQueue;

public class PQArrayOrdered<T extends Comparable<? super T>> implements IPriorityQueueMin<T> {

    T[] itemHolder;
    int currentPosition;

    @SuppressWarnings("unchecked")
    public PQArrayOrdered(int initSize) {
        itemHolder = (T[]) new Comparable[initSize];
        currentPosition = 0;
    }

    @Override
    public void insert(T v) {
        if (currentPosition == itemHolder.length) {
            resize(2 * itemHolder.length);
        }
        // insert at the end
        int insPosV = currentPosition;
        // move it at the right position
        while (insPosV > 0) {
            if (v.compareTo(itemHolder[insPosV - 1]) > 0) {
                // move item at insPOsV-1 one unit to the right
                itemHolder[insPosV] = itemHolder[insPosV - 1];
                insPosV--;
            } else {
                break;
            }
        }
        itemHolder[insPosV] = v; // insert v now at insPosV
        currentPosition++;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        }
        return itemHolder[currentPosition - 1];
    }

    @Override
    public T delMin() {
        if (isEmpty()) {
            return null;
        }
        T item = itemHolder[currentPosition - 1];
        itemHolder[currentPosition - 1] = null; // no loitering
        currentPosition--; // update current position
        if (currentPosition > 0 && currentPosition == itemHolder.length / 4) {
            resize(itemHolder.length / 2);
        }
        return item;
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
