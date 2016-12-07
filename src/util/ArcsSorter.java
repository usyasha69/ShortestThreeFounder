package util;

import model.ArcGraphModel;

import java.util.Comparator;

public class ArcsSorter implements Comparator<ArcGraphModel> {

    @Override
    public int compare(ArcGraphModel o1, ArcGraphModel o2) {

        return o1.weight - o2.weight;
    }
}
