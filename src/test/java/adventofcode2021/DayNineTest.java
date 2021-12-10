package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayNineTest {

    DayNine dayNine = new DayNine();


    @Test
    void examplePart1() {
        List<String> inputs = List.of(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
        );
        assertThat(dayNine.solve(inputs)).isEqualTo(15);
    }

    @Test
    void solutionPart1() {
        assertThat(dayNine.solve(Utils.readInputLinesFromFile("day_nine.txt"))).isEqualTo(452);
    }

    @Test
    void examplePart2() {
        List<String> inputs = List.of(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
        );
        List<Integer> result = dayNine.solve2(inputs);
        assertThat(result).containsExactlyInAnyOrder(14,9,9);
        assertThat(result.stream().mapToInt(i->i).reduce(1,(a, b)->a*b)).isEqualTo(1134);
    }

    @Test
    void solvePart2() {
        assertThat(dayNine.solve2(Utils.readInputLinesFromFile("day_nine.txt"))
                .stream().mapToInt(i->i).reduce(1,(a, b)->a*b)).isEqualTo(0);
    }
}
