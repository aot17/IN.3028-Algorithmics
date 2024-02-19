package ch.unifr.algo2023.students.search;

public interface ISymbolTable<Key, Value> {

    void put(Key key, Value val);

    Value get(Key key);

    boolean contains(Key key);

    void delete(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
