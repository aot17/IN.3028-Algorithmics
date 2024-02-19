package ch.unifr.algo2023.students.graph;

public class KosarajuSharirSCC implements IStronglyConnectedComponents {

    private boolean[] marked; // already reached vertices
    private int[] id; // strong component identifiers
    private int count; // number of strong components

    public KosarajuSharirSCC(IDiGraph graph) {
        //TODO initialization
    }

    private void dfs(IDiGraph graph, int v) {
        //TODO
    }

    @Override
    public boolean connected(int v, int w) {
        //TODO
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int getConnectedCompID(int v) {
        //TODO
    }

}
