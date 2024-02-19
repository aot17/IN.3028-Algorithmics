package ch.unifr.algo2023.teacher.search;

import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends AbstractSortedSymbolTable<Key, Value> {

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
    public Value get(Key key) {
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
        // return get(root, key); (recursive version)
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        // change key's value to val if key in subtree rooted at node
        // otherwise, add new node to subtree associating key with val
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Key min() {
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
    public Key max() {
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
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    //floor: largest key smaller than or equal to given key
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key); //G.compareTo(E) = 2
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
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    //smallest key larger than or equal to given key
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
    public Key select(int k) {
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
    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedQueue<Key> queue = new LinkedQueue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, LinkedQueue<Key> queue, Key lo, Key hi) {
        if (node == null) {
            return;
        }
        int cmplo = lo.compareTo(node.key);
        if (cmplo < 0) {
            keys(node.left, queue, lo, hi);
        }
        int cmphi = hi.compareTo(node.key);
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(node.key);
        }
        if (cmphi > 0) {
            keys(node.right, queue, lo, hi);
        }
    }

    @Override
    public void deleteMin() {
        if (!isEmpty()) {
            root = deleteMin(root);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            node.n = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else { // found key in node
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {// nodes has two children
                Node t = node;
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
        }
        // at the end (after reconnecting), update n
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

}
