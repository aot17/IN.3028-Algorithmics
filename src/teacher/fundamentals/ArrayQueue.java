package ch.unifr.algo2023.teacher.fundamentals;

import java.util.Iterator;

/*
* This queue implementation resizes itself automatically
*/
public class ArrayQueue<T> implements IQueue<T> {
    private T[] array;
    private int count;
    private int oldestElem;
    private int youngestElem;

    // Checks whether the queue is stable at all times.
    private void assertClassInvariant() {
        assert array != null;
        assert 0 <= count && count <= array.length;
        assert count != 0 || oldestElem == youngestElem;

        int counter = 0;
        boolean b0 = false; // these booleans are used to check if resp. last/first positions are found
        boolean b1 = false; // exactly once.

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                counter++;

            if (count != 0) {
                if (array[i] == null && array[(i + 1) % array.length] != null) {
                    assert !b0;
                    b0 = true;
                    assert (i + 1) % array.length == oldestElem;
                }
                if (array[i] != null && array[(i + 1) % array.length] == null) {
                    assert !b1;
                    b1 = true;
                    assert (i + 1) % array.length == youngestElem;
                }
            }
        }

        assert count == 0 || count == array.length || (b0 && b1);

        assert counter == count;
    }

    // Controls the check above, turn this off (i.e. comment) for production.
    private void assertClassInvariantController(){
        assertClassInvariant();
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        array = (T[]) new Object[4]; // Starts the array with size 4 ...
        count = 0;
        oldestElem = 0;
        youngestElem = 0;
    }

    @Override
    public void enqueue(T elem) {

        // Resizing the array
        if (count == array.length) {
            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Object[array.length * 2]; // ... and doubles it, whenever it reaches the end

            for (int i = 0; i < count; i++) {
                tmp[i] = array[(oldestElem + i) % array.length];
            }

            array = tmp;
            youngestElem = count;
            oldestElem = 0;
        }

        // Adding element
        array[youngestElem] = elem;
        youngestElem = (youngestElem + 1) % array.length;
        count++;

        assertClassInvariantController();
    }

    @Override
    public T dequeue() {
        if (count == 0) {
            return null;
        }
        // Removing element
        T elem = array[oldestElem];
        array[oldestElem] = null;
        oldestElem = (oldestElem + 1) % array.length;
        count--;

        assertClassInvariantController();

        return elem;
    }

    @Override
    public T peek() {
        if(count == 0) return null;
        return array[oldestElem];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int posIter = 0;

            @Override
            public boolean hasNext() {
                return posIter < count;
            }

            @Override
            public T next() {
                T item = array[posIter];
                posIter++;
                return item;
            }
        };
    }
}