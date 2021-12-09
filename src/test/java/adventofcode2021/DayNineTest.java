package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayNineTest {

    DayNine dayNine = new DayNine();


    @Test
    void test1() {
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
    void testPartOne() {
        assertThat(dayNine.solve(Utils.readInputLinesFromFile("day_nine.txt"))).isEqualTo(0);
    }
}
