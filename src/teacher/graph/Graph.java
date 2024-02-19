package ch.unifr.algo2023.teacher.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Graph implements IGraph {
    private final int n; //number of nodes/vertices
    private int m; //number of edges
    private final LinkedList<Integer>[] adjLists;

    @SuppressWarnings("unchecked")
    public Graph(int numberOfNodes) {
        this.n = numberOfNodes;
        adjLists = new LinkedList[n];
        for (int v = 0; v < n; v++) {
            adjLists[v] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public Graph(String inputPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader((inputPath)));
        this.n = Integer.parseInt(reader.readLine());
        adjLists = new LinkedList[n];
        for (int v = 0; v < n; v++) {
            adjLists[v] = new LinkedList<>();
        }

        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            addEdge(v, w);
        }
        reader.close();
    }


    @Override
    public int numberOfNodes() {
        return n;
    }

    @Override
    public int numberOfEdges() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        adjLists[v].add(w);
        adjLists[w].add(v);
        m++;
    }

    @Override
    public boolean isEdge(int v, int w) {
        return (adjLists[v].contains(w));
    }

    @Override
    public void deleteEdge(int v, int w) {
        adjLists[v].remove((Integer) w); // Casting allows => remove(Object o) instead of remove(int index)
        adjLists[w].remove((Integer) v);
        m--;
    }

    @Override
    public int degree(int v) {
        return adjLists[v].size();
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adjLists[v];
    }
}

