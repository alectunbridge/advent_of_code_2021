package adventofcode2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Board {
    private final int[][] boardNumbers;
    private List<Set<Integer>> rows = new ArrayList<>();
    private List<Set<Integer>> columns = new ArrayList<>();


    public Board(int[][] boardNumbers) {
        IntStream.range(0,5).forEach(i -> {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        });

        this.boardNumbers = boardNumbers;
        for (int row = 0; row < boardNumbers.length; row++) {
            for (int column = 0; column < boardNumbers[row].length; column++) {
                rows.get(row).add(boardNumbers[row][column]);
                columns.get(column).add(boardNumbers[row][column]);
            }
        }
    }

    public boolean mark(int number) {
        boolean foundWinner = false;
        for ( Set<Integer> row:rows) {
            row.remove(number);
            if(row.isEmpty()) {
                foundWinner = true;
            }
        }
        for ( Set<Integer> column:columns) {
            column.remove(number);
            if(column.isEmpty()){
                foundWinner = true;
            }
        }
        return foundWinner;
    }

    public int sumUnMarkedNumbers() {
        return rows.stream().flatMap(Set::stream).mapToInt(Integer::intValue).sum();
    }
}
