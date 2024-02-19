package ch.unifr.algo2023.students.graph;

public interface IGraph {
    int numberOfNodes();

    int numberOfEdges();

    void addEdge(int v, int w);

    boolean isEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int degree(int v);

    void deleteEdge(int v, int w);
}
