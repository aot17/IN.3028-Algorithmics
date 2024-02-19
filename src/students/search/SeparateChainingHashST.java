package ch.unifr.algo2023.students.search;

public class SeparateChainingHashST<Key, Value> extends AbstractSymbolTable<Key, Value> {

    private int m; // hash table size
    private int n; // size of symbol table
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    //Todo: Implement the following methods

    private int hash(Key key){
        return 0;
    }

    @Override
    public void put(Key key, Value val) {
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    protected void resize(int maxCapacity) {}
}
