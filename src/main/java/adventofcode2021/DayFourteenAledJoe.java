package adventofcode2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayFourteenAledJoe {

	public int Solve(List<String> input) {

		String initialPolymer = input.get(0);


		Map<String, String> instructions = new HashMap();

		for (int i = 2; i < input.size(); i++) {
			String[] line = input.get(i).split(" -> ");
			instructions.put(line[0], line[1]);

		}


		for (int i = 0; i < 40; i++) {
			initialPolymer = enhancePolymer(initialPolymer, instructions);
		}

		String[] values = initialPolymer.split("");

		Map<String, Long> answers = Arrays.stream(values).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Long> list = answers.values().stream().sorted().collect(Collectors.toList());

		return (int) (list.get(list.size()-1) - list.get(0));

//		System.out.print(initialPolymer);
	}


	private String enhancePolymer(String initialPolymer, Map<String, String> instructions) {
		for (int i = 0; i < initialPolymer.length()-1; i++) {

			String firstPartDoNotAlter = initialPolymer.substring(0, i);
			String keyWindow = initialPolymer.substring(i, i + 2);
			String secondPartDoNotAlter = initialPolymer.substring(i + 2);

			String value = instructions.get(keyWindow);

			String newPolymer;

			if (value != null) {
				newPolymer = keyWindow.charAt(0) + value + keyWindow.charAt(1);
				initialPolymer = firstPartDoNotAlter + newPolymer + secondPartDoNotAlter;
				i++;
			}
		}
		return initialPolymer;
	}
}

//NCNBCHB
//NCNBCHB
