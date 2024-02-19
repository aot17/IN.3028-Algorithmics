package ch.unifr.algo2023.students.unionFind;


public abstract class UnionFindAbstract implements IUnionFind {

    int[] id; // gives the id of the representative node of the
    // connected component the given node (id=index) correspond to
    int countComponents; // total number of components

    public UnionFindAbstract(int nrOfNodes) {
        // initialize array
        this.id = new int[nrOfNodes];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        // init number of comp.
        this.countComponents = nrOfNodes;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);

    }

    @Override
    public int count() {
        return countComponents;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("*** " + countComponents + " components *** " + "\t");
        for (int i = 0; i < id.length; i++) {
            sb.append(id[i] + "\t");
        }
        return sb.toString();
    }

}
