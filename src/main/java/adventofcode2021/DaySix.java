package adventofcode2021;

import java.util.*;

public class DaySix {

	public long solve(String testInputs, int numOfDays) {

		List<Long> agesList = new ArrayList<>(Collections.nCopies(9, 0L));
		Arrays.stream(testInputs.split(",")).map(Integer::parseInt).forEach(age -> agesList.set(age,agesList.get(age)+1));

		for (int j = 0; j < numOfDays; j++) {
			long zeroAgeFish = agesList.remove(0);
			agesList.set(6,agesList.get(6) + zeroAgeFish);
			agesList.add(zeroAgeFish);
		}

		return agesList.stream().mapToLong(Long::valueOf).sum();
	}
}
