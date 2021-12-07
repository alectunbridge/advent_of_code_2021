package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DaySevenTest {

    public static final List<String> EXAMPLE_INPUT = List.of("16,1,2,0,4,2,7,1,2,14".split(","));
    public static final List<String> INPUT = List.of(Utils.readInputLinesFromFile("day_seven.txt").get(0).split(","));

    private DaySeven daySeven = new DaySeven();

    @Test
    void part1Example() {
        assertThat(daySeven.solve(EXAMPLE_INPUT)).isEqualTo(37);
    }

    @Test
    void part1Solution() {
        assertThat(daySeven.solve(INPUT)).isEqualTo(328187);
    }

    @Test
    void part2Example() {
        assertThat(daySeven.solvePart2(EXAMPLE_INPUT)).isEqualTo(168);
    }

    @Test
    void part2Solution() {
        assertThat(daySeven.solvePart2(INPUT)).isEqualTo(91257582);
    }
}
