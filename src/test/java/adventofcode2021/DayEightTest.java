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
        assertThat(dayEight.solve(Utils.readInputLinesFromFile("day_eight.txt"))).isEqualTo(0);
    }

    /*
    a
    c/f?
    e/g?

    we know:
    1
    4
    7
    8
    3 = 5 segments including those from 1 (cf)
    6 = 6 segments not including those from 1 (cf)
    9 = 6 segments include those from 4 (bcdf)
    0 = by deduction
    5 = 5 segments including those from 4-1 (bd)
    2 = by deduction

    1 2*    c  f
    7 3*  a c  f
    4 4*   bcd f
    2 5-  a cde g
    5 5-  ab d fg
    3 5-  a cd fg
    0 6-  abc efg
    9 6-  abcd fg
    6 6-  ab defg
    8 7*  abcdefg
     */
}
