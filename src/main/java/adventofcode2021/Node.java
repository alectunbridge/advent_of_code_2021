package adventofcode2021;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private int distance = Integer.MAX_VALUE;
    private HashMap<Node, Integer> neighbours = new HashMap<>();

    public int getDistance(){
        return distance;
    }

    Map<Node,Integer> getNeighbours(){
        return neighbours;
    }
    void addNeighbour(Node node, int distance){
        neighbours.put(node, distance);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
