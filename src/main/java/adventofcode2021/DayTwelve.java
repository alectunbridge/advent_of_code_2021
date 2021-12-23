package adventofcode2021;

import java.util.*;

public class DayTwelve {

    private final Map<String, Set<String>> edges;

    public DayTwelve(List<String> input) {
        edges = new HashMap<>();
        for (String line :
                input) {
            String[] tokens = line.split("-");
            String startNode = tokens[0];
            String endNode = tokens[1];
            Set<String> destinationNodesForwards = edges.getOrDefault(startNode, new TreeSet<>());
            destinationNodesForwards.add(endNode);
            edges.put(startNode, destinationNodesForwards);

            if(!"start".equals(startNode) && !"end".equals(endNode)){
                Set<String> destinationNodesBackwards = edges.getOrDefault(endNode, new TreeSet<>());
                destinationNodesBackwards.add(startNode);
                edges.put(endNode,destinationNodesBackwards);
            }
        }
    }

    public Map<String, Set<String>> getEdges() {
        return edges;
    }
}
