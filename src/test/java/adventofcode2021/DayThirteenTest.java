package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayThirteenTest {

    @Test
    void part1Example() {
        DayThirteen dayThirteen = new DayThirteen(Utils.readInputLinesFromFile("day_thirteen_part1_example.txt"));
        assertThat(dayThirteen.solvePart1()).isEqualTo(16);
    }

    @Test
    void part1() {
        DayThirteen dayThirteen = new DayThirteen(Utils.readInputLinesFromFile("day_thirteen.txt"));
        assertThat(dayThirteen.solvePart1()).isEqualTo(Integer.MAX_VALUE);//706
    }

    @Test
    void part2() {
        DayThirteen dayThirteen = new DayThirteen(Utils.readInputLinesFromFile("day_thirteen.txt"));
        dayThirteen.solvePart2();
    }
}