package adventofcode2021;

import com.google.common.base.Functions;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.*;
import java.util.stream.Collectors;

public class DaySix {

	public long solvePart1(String testInputs, int numOfDays) {

		long[] ageCounts = new long[9];
		Arrays.fill(ageCounts,0);
		Arrays.stream(testInputs.split(",")).map(Integer::parseInt).forEach(age -> ageCounts[age] += 1);

		List<Long> agesList = new ArrayList<>();
		for (int i = 0; i < ageCounts.length; i++) {
			long age = ageCounts[i];
			agesList.add(age);
		}

		for (int j = 0; j < numOfDays; j++) {
			long zeroAgeFish = agesList.remove(0);
			agesList.set(6,agesList.get(6) + zeroAgeFish);
			agesList.add(zeroAgeFish);
		}

		return agesList.stream().mapToLong(Long::valueOf).sum();
	}
}
