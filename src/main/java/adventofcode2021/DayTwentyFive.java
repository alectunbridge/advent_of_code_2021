package adventofcode2021;

import java.util.Arrays;
import java.util.List;

public class DayTwentyFive {
    private char[][] grid;

    public DayTwentyFive(List<String> input) {
        this.grid = new char[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            grid[i] = row.toCharArray();
        }
    }

    int getNumberOfStepsToStasis() {
        String previousState = "";
        String newState = toString();
        int stepCount = 0;
        do{
            previousState = newState;
            step();
            newState =toString();
            System.out.println(newState);
            stepCount++;
        } while (!previousState.equals(newState));
        return stepCount;
    }

    public void step() {
        char[][] newGrid = new char[grid.length][grid[0].length];
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                newGrid[i][j] = '.';
            }
        }
        //move east
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '>') {
                    int newColumnPosition = (column + 1) % grid[0].length;
                    if (grid[row][newColumnPosition] == '.') {
                        newGrid[row][newColumnPosition] = '>';
                    } else {
                        newGrid[row][column] = '>';
                    }
                }
            }
        }
        //move south
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 'v') {
                    int newRowPosition = (row + 1) % grid.length;
                    if (grid[newRowPosition][column] != 'v' && newGrid[newRowPosition][column] == '.') {
                        newGrid[newRowPosition][column] = 'v';
                    } else {
                        newGrid[row][column] = 'v';
                    }
                }
            }
        }
        grid = newGrid;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char[] row : grid) {
            result.append(row);
            result.append("\n");
        }
        return result.toString().trim();
    }
}
