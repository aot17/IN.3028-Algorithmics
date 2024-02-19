package students;

import ch.unifr.algo2023.students.graph.*;
import org.junit.Test;

import java.io.IOException;

public class GraphTest {
    @Test
    public void Test0() throws IOException {
        Graph g = new Graph("./data/testG.txt"); //this start at src/ch/unifr.....

        assert g.numberOfNodes() == 4;
        System.out.println(g.numberOfEdges());
        assert g.numberOfEdges() == 5;
        assert g.degree(1) == 3;
        assert g.degree(0) == 2;
        g.addEdge(0,3);
        assert g.isEdge(0,3);
        assert g.degree(0) == 3;

        System.out.print("Adjacent node of node 2: ");
        for(int a : g.adj(2)){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("Adjacent nodes should be {0, 1, 3}.");

    }

    @Test
    public void Test1() throws IOException {
        /*This test is for when the deleteEdge() method has already been implemented*/

        Graph g = new Graph("./data/testG.txt");

        assert g.numberOfNodes() == 4;
        assert g.numberOfEdges() == 5;
        assert g.degree(1) == 3;
        assert g.degree(0) == 2;
        g.addEdge(0,3);
        assert g.isEdge(0,3);
        assert g.degree(0) == 3;
        g.deleteEdge(0,1);
        g.deleteEdge(0, 2);
        assert g.degree(0) == 1;
        assert g.numberOfEdges() == 4;

        System.out.print("Adjacent node of node 2: ");
        for(int a : g.adj(2)){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("Adjacent nodes should be {1, 3}");

    }
}
