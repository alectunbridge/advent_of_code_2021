package adventofcode2021;

import java.util.Arrays;
import java.util.List;

public class DayEleven {

    private final int[][] board;
    private int flashCount;

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

    public void step() {
        for (int row = 0; row < board.length; row++) {
            for( int column = 0; column < board[row].length; column++) {
                board[row][column] += 1;
            }
        }
        for (int row = 0; row < board.length; row++) {
            for( int column = 0; column < board[row].length; column++) {
                if(board[row][column] > 9) {
                    flash(row, column);
                }
            }
        }
    }

    private void flash(int row, int column) {
        flashCount++;
        board[row][column] = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            for(int j = column - 1; j <= column + 1; j++) {
                try{
                    if(board[i][j] != 0) {
                        board[i][j] += 1;
                    }
                    if (board[i][j] > 9) {
                        flash(i, j);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    }

    public int getFlashCount() {
        return flashCount;
    }
}
