package adventofcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFour {
	public int solveBingo(List<String> input) {

		List<Integer> numbers = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		List<String> drawn = new ArrayList<>();
		int answer = 0;
		int sumOfLine = 0;

		List<Board> boards = new ArrayList<>();

		Board board = null;
		for (String inputLine: input) {


			if (inputLine.length() < 50 ) {
				if (inputLine.equals("")) {
					if (board != null) {
						boards.add(board);
					}
					board = new Board();
				} else {
					board.addLine(inputLine);
				}
			}
		}
		boards.add(board);


		for (Integer num: numbers) {

			for (Board b : boards) {
				if (!b.hasWon) {
					boolean winner = b.call(num);
					if (winner) {
						System.out.println(b.answer() * num);
					}
				}
			}
		}

		System.out.println("sdas");
		return 0;
	}

	class Board {
		List<List<Integer>> lines = new ArrayList<>();

		boolean hasWon = false;
		void addLine(String input) {
			lines.add(Arrays.stream(input.split(" ")).filter(s -> !"".equals(s)).map(Integer::parseInt).collect(Collectors.toList()));
			if (lines.size() == 5) {
				for (int i = 0; i < 5; i++) {
					List<Integer> column = new ArrayList<>();
					column.add(lines.get(0).get(i));
					column.add(lines.get(1).get(i));
					column.add(lines.get(2).get(i));
					column.add(lines.get(3).get(i));
					column.add(lines.get(4).get(i));
					lines.add(column);
				}
			}
		}

		boolean call(Integer num) {
			for (List<Integer> aLine : lines) {
				aLine.remove(num);
				if (aLine.isEmpty()) {
					hasWon = true;
					return true;
				}
			}
			return false;
		}

		public Integer answer() {
			int total = 0;
			for (int i = 0; i < 5; i++) {
				List<Integer> aLine = lines.get(i);
				for (Integer value : aLine) {
					total += value;
				}
			}
			return total;
		}
	}
}


