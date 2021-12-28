package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class DayTwentyFiveTest {

    @Test
    void movingEastwards() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive(List.of("...>>>>>..."));
        assertThat(dayTwentyFive).hasToString("...>>>>>...");
        dayTwentyFive.step();
        assertThat(dayTwentyFive).hasToString("...>>>>.>..");
        dayTwentyFive.step();
        assertThat(dayTwentyFive).hasToString("...>>>.>.>.");
    }

    @Test
    void movingSouthwards() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive(List.of(
                "..........",
                ".>v....v..",
                ".......>..",
                ".........."
        ));
        dayTwentyFive.step();
        assertThat(dayTwentyFive).hasToString(
                "..........\n" +
                        ".>........\n" +
                        "..v....v>.\n" +
                        ".........."
        );
    }

    @Test
    void solvePartOneExample() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive(List.of(
                "v...>>.vv>",
                ".vv>>.vv..",
                ">>.>v>...v",
                ">>v>>.>.v.",
                "v>v.vv.v..",
                ">.>>..v...",
                ".vv..>.>v.",
                "v.v..>>v.v",
                "....v..v.>"
        ));
        int stepCount = dayTwentyFive.getNumberOfStepsToStasis();
        assertThat(stepCount).isEqualTo(58);
    }

    @Test
    void solvePartOne() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive(Utils.readInputLinesFromFile("day_twenty_five.txt"));
        assertThat(dayTwentyFive.getNumberOfStepsToStasis()).isEqualTo(0);
    }
}
