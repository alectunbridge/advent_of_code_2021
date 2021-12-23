package adventofcode2021;


import java.util.*;

public class DayTwelve {

    private static final List<List<String>> PATHS = new ArrayList<>();
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

            if (!"start".equals(startNode) && !"end".equals(endNode)) {
                Set<String> destinationNodesBackwards = edges.getOrDefault(endNode, new TreeSet<>());
                destinationNodesBackwards.add(startNode);
                edges.put(endNode, destinationNodesBackwards);
            }
        }
    }

    public Map<String, Set<String>> getEdges() {
        return edges;
    }

    public List<List<String>> findPaths() {
        List<String> path = new ArrayList<>();
        path.add("start");
        findLeaf(path);
        return PATHS;
    }

    public void findLeaf(List<String> visitedNodes) {
        String currentNode = visitedNodes.get(visitedNodes.size() - 1);
        if (currentNode.equals("end")) {
            PATHS.add(visitedNodes);
            return;
        }
        Set<String> children = edges.get(currentNode);
        for (String childNode : children) {
            boolean smallCave = childNode.toLowerCase().equals(childNode);
            if( smallCave && visitedNodes.contains(childNode)){
                continue;
            }
            List<String> newVisitedNodeList = new ArrayList<>();
            newVisitedNodeList.addAll(visitedNodes);
            newVisitedNodeList.add(childNode);
            findLeaf(newVisitedNodeList);
        }

    }
}
