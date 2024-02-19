package ch.unifr.algo2023.teacher.graph;

public class KosarajuSharirSCC implements IStronglyConnectedComponents {

    private boolean[] marked; // already reached vertices
    private int[] id; // strong component identifiers
    private int count; // number of strong components

    public KosarajuSharirSCC(IDiGraph graph) {
        int nrNodes = graph.numberOfNodes();
        marked = new boolean[nrNodes];
        id = new int[nrNodes];
        DepthFirstOrders orders = new DepthFirstOrders(graph.reverse());
        for (int s : orders.getReversePostOrder()) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(IDiGraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int getConnectedCompID(int v) {
        return id[v];
    }

}
