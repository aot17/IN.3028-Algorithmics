package ch.unifr.algo2023.students.search;

import ch.unifr.algo2023.students.fundamentals.LinkedQueue; //use your own linkedqueue or the one from the teacher package

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends AbstractSortedSymbolTable<Key, Value> implements ISortedSymbolTable<Key, Value> {

    //Todo: Implement all 13 methods for exercise 3.4

    private Node root; // root of BST

    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to left node/subtree and right node/subtree
        private int n; // # of nodes in subtree rooted at this node

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
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

    @Override
    public void deleteMin() {
    }

    @Override
    public void deleteMax() {
    }
}
