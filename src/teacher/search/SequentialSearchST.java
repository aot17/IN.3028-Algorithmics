package ch.unifr.algo2023.teacher.search;

import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;

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
        n = 0;
    }

    @Override
    public Value get(Key key) {
        // search for key, return associated value
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val; // search hit
            }
        }
        return null; // search miss
    }

    @Override
    public void put(Key key, Value val) {
        // search for key. Update value if found; grow table if new
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first); // search miss: add new node in front
        n++;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
		LinkedQueue<Key> queue = new LinkedQueue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        first = delete(first, key);
    }
    // [n1]->[n2]->[n4]

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

}
