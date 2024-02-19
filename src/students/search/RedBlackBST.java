package ch.unifr.algo2023.students.search;

import ch.unifr.algo2023.students.fundamentals.LinkedQueue; // use your own or use this

public class RedBlackBST<Key extends Comparable<Key>, Value> extends AbstractSortedSymbolTable<Key, Value> implements ISortedSymbolTable<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // root of BST

    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to left node/subtree and right node/subtree
        private int n; // # of nodes in subtree rooted at this node
        boolean color; // color of parent link

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        //TODO for Ex. 3.7
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    @Override
    public Value get(Key key) { //same as for BinarySearchTree
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.val;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        //TODO for Ex. 3.7
    }

    @Override
    public Key min() { //same as for BinarySearchTree
        if (root == null) {
            return null;
        } else {
            return min(root).key;
        }

    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    @Override
    public Key max() { //same as for BinarySearchTree
        if (root == null) {
            return null;
        } else {
            return max(root).key;
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    @Override
    public Key floor(Key key) { //same as for BinarySearchTree
        Node node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {
            Node t = floor(node.right, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
    }

    @Override
    public Key ceiling(Key key) { //same as for BinarySearchTree
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            Node t = ceiling(node.left, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return size(node.left);
            } else if (cmp < 0) {
                return rank(node.left, key);
            } else {
                return 1 + size(node.left) + rank(node.right, key);
            }
        }
    }

    @Override
    public Key select(int k) { //same as for BinarySearchTree
        if (k < 0 || k >= size()) {
            return null;
        } else {
            Node node = select(root, k);
            return node.key;
        }

    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        } else {
            int t = size(node.left);
            if (k == t) {
                return node;
            } else if (k < t) {
                return select(node.left, k);
            } else {
                return select(node.right, k - t - 1);
            }
        }
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) { //same as for BinarySearchTree
        LinkedQueue<Key> queue = new LinkedQueue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, LinkedQueue<Key> queue, Key lo, Key hi) {
        if (node == null) {
            return;
        }
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0) {
            keys(node.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.add(node.key);
        }
        if (cmphi > 0) {
            keys(node.right, queue, lo, hi);
        }
    }

    @Override
    public void deleteMin() {
        //TODO for Ex. 3.7
    }

    @Override
    public void deleteMax() {
        //TODO for Ex. 3.7
    }

    @Override
    public void delete(Key key) {
        //TODO for Ex. 3.7
    }

}

