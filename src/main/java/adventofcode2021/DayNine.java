package adventofcode2021;


import java.util.*;
import java.util.stream.Collectors;

public class DayNine {

    private int[][] grid;
    private List<Coordinate> lowPoints;
    private Set<Coordinate> seenCoordinates = new HashSet<>();

    public int solve(List<String> inputs) {
        grid = new int[inputs.size()][inputs.size()];

        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i);
            String[] row = line.split("");
            grid[i] = Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
        }

        lowPoints = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int currentHeight = grid[row][column];
                if (row != 0) {
                    if (grid[row - 1][column] <= currentHeight) {
                        continue;
                    }
                }
                if (column != 0) {
                    if (grid[row][column - 1] <= currentHeight) {
                        continue;
                    }
                }
                if (column != grid[row].length-1) {
                    if (grid[row][column+1] <= currentHeight) {
                        continue;
                    }
                }
                if (row != grid.length-1) {
                    if (grid[row+1][column] <= currentHeight) {
                        continue;
                    }
                }
                Coordinate lowPoint = new Coordinate(row, column, grid[row][column]);
                lowPoints.add(lowPoint);
            }
        }
        return lowPoints.stream().mapToInt(Coordinate::getHeight).sum() + lowPoints.size();
    }

    public List<Integer> solve2(List<String> inputs) {
        solve(inputs);
        for(Coordinate coordinate : lowPoints) {
            int area = getArea(coordinate.getRow(), coordinate.getColumn());
            coordinate.setArea(area);
        }
        return lowPoints.stream().mapToInt(Coordinate::getArea).boxed().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    }

    private int getArea(int row, int column) {
        Coordinate coordinate = new Coordinate(row, column);
        if(seenCoordinates.contains(coordinate)) {
            return 0;
        }
        if(row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || grid[row][column] == 9) {
            return 0;
        }
        seenCoordinates.add(new Coordinate(row, column));
        return 1 + getArea(row, column - 1) + getArea(row, column + 1) + getArea(row - 1, column) + getArea(row + 1, column);
    }
}
