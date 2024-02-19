package ch.unifr.algo2023.students.unionFind;

public interface IUnionFind {

    // connected component identifier for node p
    int find(int p);

    // return true if node p and node q are in the
    // same component and false, otherwise
    boolean isConnected(int p, int q);

    // merge the connected components containing p and q as required
    void union(int p, int q);

    // number of connected components
    int count();

}
