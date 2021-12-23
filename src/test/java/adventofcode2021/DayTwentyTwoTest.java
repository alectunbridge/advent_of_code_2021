package adventofcode2021;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyTwoTest {

    @Test
    void name() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(Utils.readInputLinesFromFile("day_twenty_two_large_example.txt"));

        assertThat(dayTwentyTwo.countLitCubes()).isZero();

        dayTwentyTwo.followInstructions();

        assertThat(dayTwentyTwo.countLitCubes()).isEqualTo(2758514936282235L);
    }
}
