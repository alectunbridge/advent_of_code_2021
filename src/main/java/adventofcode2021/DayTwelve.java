package adventofcode2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwelve {

    private final Map<String, List<String>> edges;

    public DayTwelve(List<String> input) {
        edges = new HashMap<>();
        for (String line :
                input) {
            String[] tokens = line.split("-");
            String startNode = tokens[0];
            String endNode = tokens[1];
            List<String> destinationNodes = edges.getOrDefault(startNode, new ArrayList<>());
            destinationNodes.add(endNode);
            edges.put(startNode, destinationNodes);
        }
    }

    public Map<String, List<String>> getEdges() {
        return edges;
    }
}
