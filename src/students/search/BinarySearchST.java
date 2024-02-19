package ch.unifr.algo2023.students.search;

import ch.unifr.algo2023.students.fundamentals.LinkedQueue; //use your own linkedqueue or the one from the teacher package

public class BinarySearchST<Key extends Comparable<Key>, Value> extends AbstractSortedSymbolTable<Key, Value> {

    //Todo: Implement all 11 methods for exercise 3.2

    private Key[] keys;
    private Value[] vals;
    private int n;

    @SuppressWarnings("unchecked")
    public BinarySearchST() {
        int initCapa = 100;
        keys = (Key[]) new Comparable[initCapa];
        vals = (Value[]) new Object[initCapa];
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
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
    public void delete(Key key) {
    }
}