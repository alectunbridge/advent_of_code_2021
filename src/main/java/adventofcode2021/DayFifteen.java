package adventofcode2021;

import java.util.*;
import java.util.stream.Collector;

public class DayFifteen {
    private final CoordDayFifteen END;
    private final int[][] grid;
    public static int GRID_SIZE;
    private Map<CoordDayFifteen, Integer> visitedPositions = new HashMap<>();

    public DayFifteen(String filename) {
        List<String> lines = Utils.readInputLinesFromFile(filename);
        GRID_SIZE = lines.size();
        grid = new int[GRID_SIZE][GRID_SIZE];
        for (int y = 0; y < grid.length; y++) {
            grid[y] = Arrays.stream(lines.get(y).split("")).mapToInt(Integer::parseInt).toArray();
        }
        END = new CoordDayFifteen(GRID_SIZE - 1, GRID_SIZE - 1);
    }

    public int solvePart1() {
        int riskLevel = 0;
        CoordDayFifteen currentPosition = new CoordDayFifteen(0, 0);
        makeNextMove(riskLevel, currentPosition);
        return visitedPositions.get(END);
    }

    private void makeNextMove(int riskLevel, CoordDayFifteen pos) {
        if (pos.equals(END)) {
            return;
        }
        makeSingleMove(riskLevel, pos.moveRight());
        makeSingleMove(riskLevel, pos.moveDown());
        makeSingleMove(riskLevel, pos.moveLeft());
        makeSingleMove(riskLevel, pos.moveUp());
    }

    private void makeSingleMove(int riskLevel, CoordDayFifteen newPosition) {
        if (isValid(newPosition)) {
            int newRiskLevel = riskLevel + grid[newPosition.y][newPosition.x];
            if(visitedPositions.get(END) != null && visitedPositions.get(END) < newRiskLevel ){
                return;
            }
            if (visitedPositions.get(newPosition) != null && visitedPositions.get(newPosition) < newRiskLevel) {
                return;
            }
            visitedPositions.put(newPosition, newRiskLevel);
            makeNextMove(newRiskLevel, newPosition);
        }
    }

    private boolean isValid(CoordDayFifteen position) {
        return position.x >= 0 && position.x < DayFifteen.GRID_SIZE && position.y >= 0 && position.y < DayFifteen.GRID_SIZE;
    }
}
