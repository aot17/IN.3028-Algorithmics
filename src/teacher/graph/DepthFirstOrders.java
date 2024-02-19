package ch.unifr.algo2023.teacher.graph;

import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;
import ch.unifr.algo2023.teacher.fundamentals.LinkedStack;

public class DepthFirstOrders {

    boolean[] marked;

    private LinkedQueue<Integer> preOrder;
    private LinkedQueue<Integer> postOrder;
    private LinkedStack<Integer> reversePostOrder;

    public DepthFirstOrders(IDiGraph graph) {

        marked = new boolean[graph.numberOfNodes()];
        preOrder = new LinkedQueue<Integer>();
        postOrder = new LinkedQueue<Integer>();
        reversePostOrder = new LinkedStack<Integer>();

        for (int v = 0; v < graph.numberOfNodes(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(IDiGraph graph, int v) {
        preOrder.enqueue(v);
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        postOrder.enqueue(v);
        reversePostOrder.push(v); // push onto ordering stack
    }

    public Iterable<Integer> getPreOrder() {
        return preOrder;
    }

    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

    public Iterable<Integer> getReversePostOrder() {
        return reversePostOrder;
    }
}
