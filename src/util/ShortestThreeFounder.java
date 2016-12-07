package util;

import model.ArcGraphModel;

import java.util.ArrayList;
import java.util.Collections;

public class ShortestThreeFounder {
    public static final int WEIGHT_MATRIX_ROWS = 4;
    public static final int WEIGHT_MATRIX_COLUMNS = 4;

    public static void foundShortestThree() {
        RandomMatrixManager randomMatrixManager = RandomMatrixManager.getInstance();
        ArrayList<ArcGraphModel> result = new ArrayList<>();

        int[][] weightMatrix = randomMatrixManager.createRandomWeightMatrix(WEIGHT_MATRIX_ROWS, WEIGHT_MATRIX_COLUMNS);
        System.out.println(randomMatrixManager.weightMatrixToString(weightMatrix));

        ArrayList<ArcGraphModel> arcs = randomMatrixManager.weightMatrixToArcs(weightMatrix);
        arcs = randomMatrixManager.removeEqualArcs(arcs);
        Collections.sort(arcs, new ArcsSorter());

        DisjointSetForest disjointSetForest = new DisjointSetForest(arcs.size());

        for (ArcGraphModel arcGraphModel : arcs) {
            if (disjointSetForest.union(arcGraphModel.startTop, arcGraphModel.endTop)) {
                result.add(arcGraphModel);
            }
        }

        System.out.println("\nShortest three:\n" + result);
    }
}
