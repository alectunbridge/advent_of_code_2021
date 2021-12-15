package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTenJoeAledTest {
    @Test
    void part1Example() {
        DayTenJoeAled dayTenJoeAled = new DayTenJoeAled(new ArrayList<>(List.of(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]")));

        assertThat(dayTenJoeAled.solvePart1()).isEqualTo(26397);
    }

    @Test
    void solvePart1() {
        DayTenJoeAled dayTenJoeAled = new DayTenJoeAled(Utils.readInputLinesFromFile("day_ten.txt"));
        assertThat(dayTenJoeAled.solvePart1()).isEqualTo(168417);
    }

    @Test
    void part2Example() {
        DayTenJoeAled dayTenJoeAled = new DayTenJoeAled(new ArrayList<>(Arrays.asList(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]")));

        assertThat(dayTenJoeAled.solvePart2()).isEqualTo(288957);
    }

    @Test
    void solutionPart2() {
        DayTenJoeAled dayTenJoeAled = new DayTenJoeAled(Utils.readInputLinesFromFile("day_ten.txt"));
        assertThat(dayTenJoeAled.solvePart2()).isEqualTo(2802519786L);
    }
}
