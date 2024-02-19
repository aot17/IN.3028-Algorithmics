package ch.unifr.algo2023.students.graph;

import java.io.IOException;

public class Graph implements IGraph {
//    private final int n;
//    private int m;
//    private final LinkedList<Integer>[] adjLists;

    public Graph(int numberOfNodes) {
    }

    public Graph(String inputPath) throws IOException {
    }


    @Override
    public int numberOfNodes() {
        return 0;
    }

    @Override
    public int numberOfEdges() {
        return 0;
    }

    @Override
    public void addEdge(int v, int w) {
    }

    @Override
    public boolean isEdge(int v, int w) {
        return false;
    }

    @Override
    public void deleteEdge(int v, int w) {
    }

    @Override
    public int degree(int v) {return -1;}

    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
}
