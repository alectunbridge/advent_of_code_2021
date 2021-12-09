package adventofcode2021;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayNine {

    private int[][] grid;

    public int solve(List<String> inputs) {
        grid = new int[inputs.size()][inputs.size()];

        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i);
            String[] row = line.split("");
            grid[i] = Arrays.stream(row).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> lowPoints = new ArrayList<>();
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
                lowPoints.add(grid[row][column]);
            }
        }
        return lowPoints.stream().reduce(0, Integer::sum) + lowPoints.size();
    }
}
