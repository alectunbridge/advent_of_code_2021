package adventofcode2021;

import java.util.Arrays;
import java.util.List;

public class DayEleven {

    private final int[][] board;

    public DayEleven(List<String> input) {
        board= new int[input.size()][input.get(0).length()];
        for (int row = 0; row < input.size(); row++) {
            String[] columns = input.get(row).split("");
            for (int column = 0; column < columns.length; column++) {
                board[row][column] = Integer.parseInt(columns[column]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                sb.append(board[row][column]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
