package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTenTest {
    @Test
    void part1Example() {
        DayTen dayTen = new DayTen(new ArrayList<>(List.of(
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

        assertThat(dayTen.solvePart1()).isEqualTo(26397);
    }

    @Test
    void solvePart1() {
        DayTen dayTen = new DayTen(Utils.readInputLinesFromFile("day_ten.txt"));
        assertThat(dayTen.solvePart1()).isEqualTo(168417);
    }

    @Test
    void part2Example() {
        DayTen dayTen = new DayTen(new ArrayList<>(Arrays.asList(
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

        assertThat(dayTen.solvePart2()).isEqualTo(288957);
    }

    @Test
    void solutionPart2() {
        DayTen dayTen = new DayTen(Utils.readInputLinesFromFile("day_ten.txt"));
        assertThat(dayTen.solvePart2()).isEqualTo(2802519786L);
    }
}