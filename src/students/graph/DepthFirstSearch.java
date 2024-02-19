package ch.unifr.algo2023.students.graph;

public class DepthFirstSearch {
    private boolean[] marked; // marked[v] = is there an s-v path?
    private int count; // number of vertices connected to s

    public DepthFirstSearch(Graph G, int s) {
        //..
        validateVertex(s);
        //..
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     *
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean marked(int v) {
        validateVertex(v);
		// ....
    }

    /**
     * Returns the number of vertices connected to the source vertex {@code s}.
     *
     * @return the number of vertices connected to the source vertex {@code s}
     */
    public int count() {
    }


	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}


    public static void main(String[] args) {
        // Test here your implementation
    }

}
