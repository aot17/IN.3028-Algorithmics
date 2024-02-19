package ch.unifr.algo2023.teacher.search;


import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;

public class SeparateChainingHashST<Key, Value> extends AbstractSymbolTable<Key, Value> {

    private int m; // hash table size
    private int n; // size of symbol table, i.e. how many elements do we have stored?
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(997); // prime number!, also: this() will call the constructor function of the class, i.e. the fct below wiht m = 997
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m]; // init the array
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        //System.out.println(key + ", hash:" + key.hashCode());
        return (key.hashCode() & Integer.MAX_VALUE) % m;  // integer.max_value = 2^31 = (bin) 01111111111111111111111111111111
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value val) {
        int hash = hash(key);
        int sizeBefore = st[hash].size();
        st[hash].put(key, val);

        // check if the SequentialSearchST at st[hash] became bigger, or we just updated a value
        if (st[hash].size() > sizeBefore) {
            n++;
        }

        // resizing if needed
        if (size() / m >= 8) {
            resize(m * 2);
        }
    }

    @Override
    public void delete(Key key) {
        int hash = hash(key);
        int sizeBefore = st[hash].size();
        st[hash].delete(key);
        if (st[hash].size() < sizeBefore) {
            n--;
        }
        // resizing if needed
        if (size() / m <= 2) {
            resize(m / 2);
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        LinkedQueue<Key> queue = new LinkedQueue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

    protected void resize(int maxCapa) {
        // make a new symbol table with adjusted capacity
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(maxCapa);
        for (Key key : keys()) {
            temp.put(key, get(key));
        }
        // update to temp symbol table
        m = temp.m;
        st = temp.st;
    }

}
