package util;

public class DisjointSetForest {
    private int[] set;
    private int[] rank;

    public DisjointSetForest(int topsNumber) {
        set = new int[topsNumber];
        rank = new int[topsNumber];

        for (int i = 0; i < topsNumber; i++) {
            set[i] = i;
        }
    }

    private int set(int x) {
        return x == set[x] ? x : (set[x] = set(set[x]));
    }

    public boolean union(int startTop, int endTop) {
        startTop--;
        endTop--;

        if ((startTop = set(startTop)) == (endTop = set(endTop))) {
            return false;
        }

        if (rank[startTop] < rank[endTop]) {
            set[startTop] = endTop;
        } else {
            set[endTop] = startTop;

            if (rank[startTop] == rank[endTop]) {
                rank[startTop]++;
            }

        }

        return true;
    }
}
