package ch.unifr.algo2023.teacher.search;

import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends AbstractSortedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    @SuppressWarnings("unchecked")
    public BinarySearchST() {
        int initCapa = 100;
        keys = (Key[]) new Comparable[initCapa];
        vals = (Value[]) new Object[initCapa];
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    // a hack for counting # of compares
    long nrOfCalls = 0;
    double movingAvg = 0;
    int nrOfCompares = 0;

    @Override
    public void put(Key key, Value val) {
        // a hack for counting # of compares
        nrOfCompares = 0;
        nrOfCalls++;

        int i = rank(key);
        if (i < n) {
            // just for counting # of compares
            nrOfCompares++;
            if (keys[i].compareTo(key) == 0) {
                vals[i] = val;
                return;
            }
        }
        // check whether we have to increase the size
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        // shift all larger keys/values on to the right
        for (int j = n; j > i; j--) {
            nrOfCompares++;
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            nrOfCompares++;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[n - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0)
            return keys[i];
        if (i == 0)
            return null;
        else
            return keys[i - 1];

    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == n) {
            return null;
        } else {
            return keys[i];
        }
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
		LinkedQueue<Key> queue = new LinkedQueue<Key>();
        int rankHi = rank(hi);
        for (int i = rank(lo); i < rankHi; i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    @Override
    public int size() {
        return n;
    }

    @SuppressWarnings("unchecked")
    protected void resize(int maxCapa) {
        Key[] tempKeys = (Key[]) new Comparable[maxCapa];
        Value[] tempVals = (Value[]) new Object[maxCapa];

        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }
        keys = tempKeys;
        vals = tempVals;
    }

}
