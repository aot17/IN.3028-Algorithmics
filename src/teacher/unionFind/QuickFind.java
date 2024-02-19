package ch.unifr.algo2023.students.unionFind;

public class QuickFind extends UnionFindAbstract {

    public QuickFind(int nrOfNodes) {
	super(nrOfNodes);
    }

    @Override
    public int find(int p) {
	return id[p];
    }

    @Override
    public void union(int p, int q) {
	int pID = find(p);
	int qID = find(q);

	// if different IDs -> merge, else nothing to do
	if (qID != pID) {
	    for (int i = 0; i < id.length; i++) {
		if (id[i] == pID) {
		    id[i] = qID;
		}
	    }
	    countComponents--;
	}
    }
}
