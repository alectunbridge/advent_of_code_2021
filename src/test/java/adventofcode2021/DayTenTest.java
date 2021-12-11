package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTenTest {
    @Test
    void part1Example() {
        DayTen dayTen = new DayTen(List.of(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]"));

        assertThat(dayTen.solvePart1()).isEqualTo(26397);
    }

    @Test
    void solvePart1() {
        DayTen dayTen = new DayTen(Utils.readInputLinesFromFile("day_ten.txt"));
        assertThat(dayTen.solvePart1()).isEqualTo(168417);
    }
}