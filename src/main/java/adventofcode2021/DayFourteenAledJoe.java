package adventofcode2021;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayFourteenAledJoe {
	static long counter = 0;
	private Map<String, String> cache = new HashMap<>();

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
		String polymerToReturn = initialPolymer;
		for (int i = 0; i < polymerToReturn.length()-1; i++) {
			System.out.println(counter);

			String firstPartDoNotAlter = polymerToReturn.substring(0, i);
			String keyWindow = polymerToReturn.substring(i, i + 2);
			String secondPartDoNotAlter = polymerToReturn.substring(i + 2);

			String value = instructions.get(keyWindow);

			String newPolymer;

			if (value != null) {
				newPolymer = keyWindow.charAt(0) + value + keyWindow.charAt(1);
				polymerToReturn = firstPartDoNotAlter + newPolymer + secondPartDoNotAlter;
				i++;
			}
			counter++;
		}
		cache.put(initialPolymer,polymerToReturn);
		return polymerToReturn;
	}
}

//NCNBCHB
//NCNBCHB
