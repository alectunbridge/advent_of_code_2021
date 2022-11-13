package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayFifteenTest {


    @Test
    void part1Example() {
        DayFifteen dayFifteen = new DayFifteen("day_fifteen_example_part1.txt");
        assertThat(dayFifteen.solvePart1()).isEqualTo(40);
    }

    @Test
    void part1() {
        DayFifteen dayFifteen = new DayFifteen("day_fifteen.txt");
        assertThat(dayFifteen.solvePart1()).isEqualTo(498);
    }
}
