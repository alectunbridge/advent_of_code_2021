package adventofcode2021;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DayFourteenAledJoe {
	static long counter = 0;
	private TreeMap<String, String> instructions;

	public int Solve(List<String> input) {

		String initialPolymer = input.get(0);


		instructions = new TreeMap<>(Comparator.comparingInt(String::length).reversed().thenComparing(String::compareTo));
//		instructions = new TreeMap<>();

		for (int i = 2; i < input.size(); i++) {
			String[] line = input.get(i).split(" -> ");
            String key = line[0];
            String value = line[0].charAt(0) + line[1] + line[0].charAt(1);
            instructions.put(key, value);

		}


		for (int i = 0; i < 40; i++) {
			initialPolymer = enhancePolymer(initialPolymer);
			System.out.println(initialPolymer);
		}

		String[] values = initialPolymer.split("");

		Map<String, Long> answers = Arrays.stream(values).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Long> list = answers.values().stream().sorted().collect(Collectors.toList());

		return (int) (list.get(list.size()-1) - list.get(0));
	}


	private String enhancePolymer(String polymer) {
		String enhancedPolymer = polymer;
		for (int i = 0; i < enhancedPolymer.length()-1;) {
//			System.out.println(counter);

            Map.Entry<String,String> value = replacePolymer(enhancedPolymer,i);
			if (value!=null) {
				enhancedPolymer = enhancedPolymer.substring(0, i) + value.getValue() + enhancedPolymer.substring(i + value.getKey().length());
                i += value.getValue().length()-1;
            } else {
                i++;
            }

			counter++;
		}
		instructions.put(polymer,enhancedPolymer);
		return enhancedPolymer;
	}

	private Map.Entry<String,String> replacePolymer(String polymer,int index) {
        Set<Map.Entry<String, String>> entries = instructions.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if(polymer.startsWith(entry.getKey(),index)){
                return entry;
            }
        }
		return null;
	}
}

//NCNBCHB
//NCNBCHB
