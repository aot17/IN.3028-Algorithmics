package ch.unifr.algo2023.students.unionFind;

public class QuickUnion extends UnionFindAbstract {

    // id[index] are representing rooted trees, root = representative for the
    // component

    public QuickUnion(int nrOfNodes) {
	super(nrOfNodes);
    }

    @Override
    public int find(int p) {
	// "go up the tree"
	while (p != id[p]) {
	    p = id[p];
	}
	return p;
    }

    @Override
    public void union(int p, int q) {
	int pRoot = find(p);
	int qRoot = find(q);

	if (pRoot != qRoot) {
	    // merge
	    id[pRoot] = qRoot;
	    countComponents--;
	}
    }

}
