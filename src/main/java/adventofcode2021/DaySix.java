package adventofcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DaySix {

	public int solvePart1(String testInputs, int numOfDays) {

		List<Integer> ages;

		ages = Arrays.stream(testInputs.split(",")).map(Integer::parseInt).collect(Collectors.toList());

		for (int j = 0; j < numOfDays; j++) {

			List<Integer> newFish = new ArrayList<>();
			for (int i = 0; i < ages.size(); i++) {
				Integer fish = ages.get(i);


				if (fish != 0) {
					ages.set(i, ages.get(i) - 1);
				} else {
					ages.set(i, 6);
					newFish.add(8);
				}

			}
			ages.addAll(newFish);
		}

		return ages.size();
	}
}
