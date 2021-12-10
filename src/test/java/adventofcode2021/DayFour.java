package adventofcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DayFour {
    private final List<Integer> numbers;
    private List<Board> boards = new ArrayList<>();

    public DayFour(List<String> input) {
        numbers = Arrays.stream(input.get(0).split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 2; i < input.size(); i+=6) {
            int[][] boardNumbers = new int[5][5];
            for (int row = 0; row < 5; row++) {
                boardNumbers[row] = Arrays.stream(input.get(i+row).trim().split(" +")).mapToInt(Integer::parseInt).toArray();
            }
            boards.add(new Board(boardNumbers));
        }
    }

    public int solvePart1() {
        for (int number:numbers) {
            for (Board board:boards) {
                if(board.mark(number)) {
                    return board.sumUnMarkedNumbers() * number;
                }
            }

        }
        return 0;
    }

    public int solvePart2() {
        for (int number:numbers) {
            for (Iterator<Board> iterator = boards.iterator(); iterator.hasNext(); ) {
                Board board = iterator.next();
                if (board.mark(number)) {
                    if (boards.size() == 1) {
                        return board.sumUnMarkedNumbers() * number;
                    } else {
                        iterator.remove();
                    }
                }
            }

        }
        return 0;
    }
}
