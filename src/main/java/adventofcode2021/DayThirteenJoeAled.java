package adventofcode2021;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayThirteenJoeAled {


	public int Solve(List<String> input) {


		List<List<Character>> grid = initialiseGrid(findGridSize(input));

		for (List<Character> line: grid) {
			StringBuilder sb = new StringBuilder();
			for (Character character : line) {
				sb.append(character);
			}

			System.out.println(sb);
		}
		return 0;
	}

	private List<List<Character>> initialiseGrid(Pair<Integer, Integer> gridSize) {
		List<List<Character>> row = new ArrayList<>();
		for (int i = 0; i < gridSize.getFirst(); i++) {
			List<Character> column = new ArrayList<>(gridSize.getSecond());
			populateWithDots(column);
			row.add(i, column);
		}
		return row;

	}

	private void populateWithDots(List<Character> column) {
		for (int i = 0; i < column.size(); i++) {
			column.add('.');
		}
	}


	private Pair<Integer, Integer> findGridSize(List<String> input) {
		int highestX = 0;
		int highestY = 0;
		for (String coord : input) {
			if (coord.isEmpty()) {
				break;
			}
			List<Integer> currentCoords = Arrays.stream(coord.split(",")).map(Integer::parseInt).collect(Collectors.toList());
			if (currentCoords.get(0) > highestX) {
				highestX = currentCoords.get(0);
			}
			if (currentCoords.get(1) > highestY) {
				highestY = currentCoords.get(1);
			}
		}
		return Pair.create(highestX, highestY);
	}
}
