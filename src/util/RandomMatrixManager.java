package util;

import com.sun.istack.internal.NotNull;
import model.ArcGraphModel;

import java.util.ArrayList;

public class RandomMatrixManager {
    public static final int WEIGHT_MATRIX_RANGE = 500;

    private static RandomMatrixManager instance;

    private RandomMatrixManager() {

    }

    public static RandomMatrixManager getInstance() {
        if (instance == null) {
            instance = new RandomMatrixManager();
        }

        return instance;
    }

    /**
     * This method create random weight matrix.
     *
     * @param rows    - rows number in weight matrix
     * @param columns - columns number in weight matrix
     * @return - random weight matrix
     */
    public int[][] createRandomWeightMatrix(int rows, int columns) {
        //initialize random weight matrix
        int[][] randomWeightMatrix = new int[rows][columns];

        //filling random weight matrix
        for (int i = 0; i < randomWeightMatrix.length; i++) {
            for (int j = 0; j < randomWeightMatrix.length; j++) {
                randomWeightMatrix[i][j] = (int) (Math.random() * WEIGHT_MATRIX_RANGE) + 1;
            }
        }

        //reset the main diagonal
        for (int i = 0; i < randomWeightMatrix.length; i++) {
            for (int j = 0; j < randomWeightMatrix.length; j++) {
                if (i == j) {
                    randomWeightMatrix[i][j] = 0;
                }
            }
        }

        //make that rows == columns
        for (int i = 0; i < randomWeightMatrix.length; i++) {
            for (int j = 0; j < randomWeightMatrix.length; j++) {
                randomWeightMatrix[j][i] = randomWeightMatrix[i][j];
            }
        }

        return randomWeightMatrix;
    }

    /**
     * This method cast weight matrix to string.
     *
     * @param weightMatrix - weight matrix
     * @return weight matrix to string
     */
    public String weightMatrixToString(@NotNull int[][] weightMatrix) {
        String weightMatrixToString = "WeightMatrix:";

        for (int i = 0; i < weightMatrix.length; i++) {
            String row = "\n";
            for (int j = 0; j < weightMatrix.length; j++) {
                row += " " + weightMatrix[i][j];
            }
            weightMatrixToString += row;
        }

        return weightMatrixToString;
    }

    /**
     * This method cast weight matrix to list with arcs.
     *
     * @param weightMatrix - weight matrix
     * @return list with arcs
     */
    public ArrayList<ArcGraphModel> weightMatrixToArcs(int[][] weightMatrix) {
        ArrayList<ArcGraphModel> arcs = new ArrayList<>();

        for (int i = 1; i <= weightMatrix.length; i++) {
            for (int j = 1; j <= weightMatrix.length; j++) {
                if (i != j) {
                    arcs.add(new ArcGraphModel(i, j, weightMatrix[i - 1][j - 1]));
                }
            }
        }

        return arcs;
    }

    /**
     * This method remove equal arcs in list with arcs.
     *
     * @param arcs - list with arcs
     * @return - list with unique arcs
     */
    public ArrayList<ArcGraphModel> removeEqualArcs(ArrayList<ArcGraphModel> arcs) {
        //delete equals arcs
        for (int i = 0; i < arcs.size(); i++) {
            ArcGraphModel firstAgm = arcs.get(i);
            for (int j = i + 1; j < arcs.size() - 1; j++) {
                ArcGraphModel secondAgm = arcs.get(j);
                if (firstAgm.compareTo(secondAgm) == 0) {
                    arcs.remove(j);
                    j--;
                }
            }
        }
        arcs.remove(arcs.size() - 1);

        return arcs;
    }
}
