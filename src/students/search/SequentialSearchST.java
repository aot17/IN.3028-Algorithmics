package ch.unifr.algo2023.students.search;

import ch.unifr.algo2023.students.fundamentals.LinkedQueue; //use your own linkedqueue or the one from the teacher package

public class SequentialSearchST<Key, Value> extends AbstractSymbolTable<Key, Value> {

    private int n; // number of key-value pairs
    private Node first; // the linked list of key-value pairs

    private class Node {
        // linked-list node
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
        this.first = null;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    public void delete(Key key) {
    }

    private Node delete(Node x, Key key) {
        return null;
    }
}
