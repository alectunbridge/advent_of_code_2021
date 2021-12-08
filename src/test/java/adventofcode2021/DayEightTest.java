package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayEightTest {
    private DayEight dayEight = new DayEight();

    @Test
    void partOneExample() {
        assertThat(dayEight.solve(List.of("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe")))
                .isEqualTo(2);
    }

    @Test
    void partOneSolution() {
        assertThat(dayEight.solve(Utils.readInputLinesFromFile("day_eight.txt"))).isEqualTo(409);
    }

    @Test
    void partTwoExample1() {
        assertThat(dayEight.solvePart2(List.of("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf")))
                .isEqualTo(5353);
    }

    @Test
    void partTwoExample2() {
        List<String> longerExampleInput = List.of(
                "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe",
                "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc",
                "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg",
                "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb",
                "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea",
                "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb",
                "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe",
                "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef",
                "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb",
                "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce");
        assertThat(dayEight.solvePart2(longerExampleInput)).isEqualTo(61229);
    }

    @Test
    void partTwoSolution() {
        assertThat(dayEight.solvePart2(Utils.readInputLinesFromFile("day_eight.txt"))).isEqualTo(0);
    }
}
