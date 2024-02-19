package ch.unifr.algo2023.teacher.graph;


import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;
import ch.unifr.algo2023.teacher.priorityQueue.HeapPQMin;

public class LazyPrimMST implements IMST {

    private final LinkedQueue<IEdge> mst;
    private double weight;

    public LazyPrimMST(IGraphWithWeights graph) {
        int n = graph.numberOfNodes(), m = graph.numberOfEdges();

        // initialize MST edge holder, marked, priority queue
        mst = new LinkedQueue<IEdge>();
        boolean[] marked = new boolean[n];
        HeapPQMin<IEdge> pq = new HeapPQMin<IEdge>(m);

        // start with node 0, set marked and add adjacent edges
        marked[0] = true;
        for (IEdge edge : graph.adj(0)) {
            pq.insert(edge);
        }

        // apply algirhtm
        while (!pq.isEmpty() && mst.size() < n - 1) {
            IEdge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {
                continue; // skip this edge as both end points in T
            }
            mst.enqueue(e);
            weight += e.getWeight();
            int unmarkedNode = marked[v] ? w : v; // size = i > 5 ? "big" : "small";
            // mark unmarked node and add adjacent edges with end node not in T
            marked[unmarkedNode] = true;
            for (IEdge edge : graph.adj(unmarkedNode)) {
                int otherNode = edge.other(unmarkedNode);
                if (!marked[otherNode]) {
                    pq.insert(edge);
                }
            }
        }
    }

    @Override
    public Iterable<IEdge> getEdges() {
        return mst;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
