package ch.unifr.algo2023.students.graph;

//assumption: simple graph without loops, but do not check this

public interface IGraphWithWeights {

    int numberOfNodes(); // number of nodes

    int numberOfEdges(); // number of edges

    void addEdge(IEdge e); // add edge

    boolean isEdge(int v, int w); // asks if edge with end nodes v,w exists

    int degree(int v); // degree of node v

    Iterable<IEdge> adj(int v); // edges incident to v

    Iterable<IEdge> allEdges(); // all edges of this graph

}
