package ch.unifr.algo2023.teacher.graph;

import ch.unifr.algo2023.teacher.fundamentals.LinkedQueue;
import ch.unifr.algo2023.teacher.priorityQueue.HeapPQMin;
import ch.unifr.algo2023.teacher.unionFind.IUnionFind;
import ch.unifr.algo2023.teacher.unionFind.WeightedPathCompressionQuickUnion;

public class KruskalMST implements IMST {

    private final LinkedQueue<IEdge> mst;
    private double weight;

    public KruskalMST(IGraphWithWeights graph) {
        // initialize MST edge holder
        mst = new LinkedQueue<IEdge>();

        // compute solution
        int m = graph.numberOfEdges();
        HeapPQMin<IEdge> pq = new HeapPQMin<IEdge>(m);
        for (IEdge e : graph.allEdges()) {
            pq.insert(e);
        }

        final int n = graph.numberOfNodes();
        IUnionFind uf = new WeightedPathCompressionQuickUnion(n);
        while (!pq.isEmpty() && mst.size() < n - 1) {
            IEdge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.isConnected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
                weight += e.getWeight();
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
