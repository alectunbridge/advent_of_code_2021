package adventofcode2021;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class DayFiveTest {
    @Test
    void part1Example() {
        DayFive dayFive = new DayFive(List.of(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
        ));
        assertThat(dayFive.solvePart1()).isEqualTo(5);
    }

    @Test
    void part1Solution() {
        DayFive dayFive = new DayFive(Utils.readInputLinesFromFile("day_five.txt"));
        assertThat(dayFive.solvePart1()).isEqualTo(0);
    }
}
