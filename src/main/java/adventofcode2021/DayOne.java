/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package adventofcode2021;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayOne {

    public int findNumberIncreased(List<String> input) {
        List<Integer> ints = convertStringsToIntegers(input);
        return (int) IntStream
            .range(1, ints.size())
            .filter(i -> ints.get(i) > ints.get(i - 1))
            .count();
    }

    public int findNumberIncreasedWindow(List<String> input) {
        List<Integer> ints = convertStringsToIntegers(input);
        return (int) IntStream
            .range(3, ints.size())
            .filter(i -> ints.get(i - 3) < ints.get(i))
            .count();
    }

    private List<Integer> convertStringsToIntegers(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
