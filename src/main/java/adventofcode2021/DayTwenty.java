package adventofcode2021;

import java.util.List;

public class DayTwenty {

    private final String enhancer;
    private final char[][] floor;

    public DayTwenty(List<String> input) {
        this.enhancer = input.get(0);
        int floorSize = input.size() - 2;
        floor = new char[floorSize][floorSize];
        for (int rowIndex = 2; rowIndex < input.size(); rowIndex++) {
            floor[rowIndex - 2] = input.get(rowIndex).toCharArray();
        }
    }

    public String getEnhancer() {
        return enhancer;
    }

    public String getFloor() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : floor) {
            stringBuilder.append(new String(row));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getIndex(int row, int column) {
        return 0;
    }
}
