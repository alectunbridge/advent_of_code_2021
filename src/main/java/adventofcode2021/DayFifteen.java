package adventofcode2021;

import java.util.*;
import java.util.stream.Collectors;

public class DayFifteen {
    public static CoordDayFifteen[][] grid;
    public static int GRID_SIZE;
    private CoordDayFifteen endNode;
    private CoordDayFifteen startNode;


    public DayFifteen(List<String> lines) {

        GRID_SIZE = lines.size();
        grid = new CoordDayFifteen[GRID_SIZE][GRID_SIZE];
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                int risk = Integer.parseInt(String.valueOf(lines.get(y).charAt(x)));
                CoordDayFifteen node = new CoordDayFifteen(x, y, risk);
                if (x == 0 && y == 0) {
                    node.setDistance(0);
                    startNode = node;
                }
                if (x == GRID_SIZE - 1 && y == GRID_SIZE - 1) {
                    endNode = node;
                }
                grid[y][x] = node;
            }
        }
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                int neighbourX = x+1;
                int neighourY = y;
                if(isValid(neighbourX,neighourY)){
                    CoordDayFifteen neighbour = grid[neighourY][neighbourX];
                    grid[y][x].addNeighbour(neighbour, neighbour.risk);
                }

                neighbourX = x;
                neighourY = y+1;
                if(isValid(neighbourX,neighourY)){
                    CoordDayFifteen neighbour = grid[neighourY][neighbourX];
                    grid[y][x].addNeighbour(neighbour, neighbour.risk);
                }

                neighbourX = x-1;
                neighourY = y;
                if(isValid(neighbourX,neighourY)){
                    CoordDayFifteen neighbour = grid[neighourY][neighbourX];
                    grid[y][x].addNeighbour(neighbour, neighbour.risk);
                }

                neighbourX = x;
                neighourY = y-1;
                if(isValid(neighbourX,neighourY)){
                    CoordDayFifteen neighbour = grid[neighourY][neighbourX];
                    grid[y][x].addNeighbour(neighbour, neighbour.risk);
                }
            }

        }
    }



    public DayFifteen(String filename) {
        this(Utils.readInputLinesFromFile(filename));
    }



    public int solvePart1() {
        Set<Node> graph = Arrays.stream(grid).flatMap(Arrays::stream).collect(Collectors.toSet());
        findShortestPaths(graph, startNode);
        for (Node node : graph) {

            if (node.equals(endNode)) {
                return node.getDistance();
            }
        }
        return Integer.MAX_VALUE;
    }

    private void findShortestPaths(Set<Node> graph, Node startNode) {
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unSettledNodes = new HashSet<>();
        unSettledNodes.add(startNode);

        while (!unSettledNodes.isEmpty()) {
            Node currentNode = findClosestNode(unSettledNodes);
            unSettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> edge : currentNode.getNeighbours().entrySet()) {
                Node neighbour = edge.getKey();
                Integer edgeLength = edge.getValue();
                if (!settledNodes.contains(neighbour)) {
                    int newDistance = currentNode.getDistance() + edgeLength;
                    if (newDistance < neighbour.getDistance()) {
                        neighbour.setDistance(newDistance);
                        unSettledNodes.add(neighbour);
                    }
                }
            }
            settledNodes.add(currentNode);
        }

    }

    private Node findClosestNode(Set<Node> nodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: nodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE;
    }



    public static int[][] expandGrid(int[][] grid, int factor) {
        int[][] result = new int[grid.length*factor][grid.length*factor];


        for (int y = 0; y < factor; y++) {
            for (int x = 0; x < factor; x++) {
                for(int row=0; row<grid.length;row++){
                    for(int column=0; column<grid.length;column++){
                        int newValue = incrementValue(grid[row][column],x+y);
                        result[y*grid.length+row][x*grid.length+column] = newValue;
                    }
                }
            }
        }
        return result;
    }



    private static int incrementValue(int value, int addition) {
        for (int count = 0; count < addition; count++) {
            value++;
            if(value==10){
                value = 1;
            }
        }
        return value;
    }
}
