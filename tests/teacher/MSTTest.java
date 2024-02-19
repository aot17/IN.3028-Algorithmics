package teacher;

import ch.unifr.algo2023.teacher.graph.*;
import ch.unifr.algo2023.teacher.tools.Stopwatch;

import java.io.IOException;

public class MSTTest {

    public static void main(String[] args) throws IOException {

        Stopwatch initsw = new Stopwatch();
        IGraphWithWeights graph = new GraphWithWeightsAdjList("src/ch/unifr/algo2023/teacher/data/mediumEWG.txt");
        int version = 1;

	//	IGraphWithWeights graph = new GraphWithWeightsAdjList(args[0]);
	//	int version = Integer.parseInt(args[1]);

        System.out.println("graph constructed - time used for this step: " + initsw.elapsedTime());
        System.out.println("Start with MST computation");

        Stopwatch sw = new Stopwatch();

        IMST mst = null;
        switch (version) {
            case 0:
                mst = new KruskalMST(graph);
                break;
            case 1:
                mst = new LazyPrimMST(graph);
                break;
            default:
                mst = new LazyPrimMST(graph);
                break;
        }

        System.out.println("MST computed - time used for this step: " + sw.elapsedTime());

        /*
         * System.out.println("Edges included in MST: "); for (IEdge edge :
         * mst.getEdges()) { System.out.println(edge); }
         */
        System.out.println("total weight: " + mst.getWeight());

    }

}
