package ch.unifr.algo2023.students.graph;

public interface IMST {

    Iterable<IEdge> getEdges(); // to iterate over all edges

    double getWeight(); // weight of MST
}
