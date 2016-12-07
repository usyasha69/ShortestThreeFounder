package model;

public class ArcGraphModel implements Comparable<ArcGraphModel> {
    public int startTop;
    public int endTop;
    public int weight;

    public ArcGraphModel(int startTop, int endTop, int weight) {
        this.startTop = startTop;
        this.endTop = endTop;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "model.ArcGraphModel{" +
                "startTop=" + startTop +
                ", endTop=" + endTop +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(ArcGraphModel o) {
        int result = o.startTop - endTop;

        if (result == 0) {
            result = o.endTop - startTop;
        }

        if (result == 0) {
            result = o.weight - weight;
        }

        return result;
    }
}
