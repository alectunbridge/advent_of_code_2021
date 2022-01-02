package adventofcode2021;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DayTwentyFourTest {

    @Test
    void part1Example1() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "inp x",
                "mul x -1"
        ));
        dayTwentyFour.execute(2);
        assertThat(dayTwentyFour.getRegister("x")).isEqualTo(-2);
    }

    @Test
    void part1Example2() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "inp z",
                "inp x",
                "mul z 3",
                "eql z x"
        ));
        dayTwentyFour.execute(1, 3);
        assertThat(dayTwentyFour.getRegister("z")).isEqualTo(1);
        dayTwentyFour.execute(2, 3);
        assertThat(dayTwentyFour.getRegister("z")).isEqualTo(0);

    }

    @Test
    void part1Example3() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "inp w",
                "add z w",
                "mod z 2",
                "div w 2",
                "add y w",
                "mod y 2",
                "div w 2",
                "add x w",
                "mod x 2",
                "div w 2",
                "mod w 2"
        ));
        dayTwentyFour.execute(0b1010);
        assertThat(dayTwentyFour.getRegister("w")).isEqualTo(1);
        assertThat(dayTwentyFour.getRegister("x")).isEqualTo(0);
        assertThat(dayTwentyFour.getRegister("y")).isEqualTo(1);
        assertThat(dayTwentyFour.getRegister("z")).isEqualTo(0);
    }

    @Test
    void invalidDivideInstruction() {
        /*
        attempting to execute div with b=0
         */

        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "div 1 0"
        ));

        assertThatThrownBy(dayTwentyFour::execute)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid division operation: div 1 0");
    }

    @Test
    void invalidModuloInstructions() {
        /*
        attempting to execute mod with a<0 or b<=0 will
         */

        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "inp x",
                "inp y",
                "mod x y"
        ));
        assertThatThrownBy(() -> dayTwentyFour.execute(-1, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid modulo operation: mod x y");

        assertThatThrownBy(() -> dayTwentyFour.execute(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid modulo operation: mod x y");
    }

    @Test
    void partOneBigExampleFirstTwoDigits() {
        //a 15-23
        //b  9-17
        //c  6-14
        //d  5-13
        //e 11-19
        //f 14-22
        //g 17-25

        //h  6-14
        //i  7-15
        //j 14-22
        //k  7-15
        //l  8-16
        //m 14-22
        //n  4-12

//        DayTwentyFour dayTwentyFour = new DayTwentyFour(Utils.readInputLinesFromFile("day_twenty_four.txt"));
        DayTwentyFour dayTwentyFour = new DayTwentyFour(List.of(
                "inp w",
                "mul x 0",
                "add x z",
                "mod x 26",
                "div z 1",
                "add x 13",
                "eql x w",
                "eql x 0",
                "mul y 0",
                "add y 25",
                "mul y x",
                "add y 1",
                "mul z y",
                "mul y 0",
                "add y w",
                "add y 14",
                "mul y x",
                "add z y",
                "inp w",
                "mul x 0",
                "add x z",
                "mod x 26",
                "div z 1",
                "add x 12",
                "eql x w",
                "eql x 0",
                "mul y 0",
                "add y 25",
                "mul y x",
                "add y 1",
                "mul z y",
                "mul y 0",
                "add y w",
                "add y 8",
                "mul y x",
                "add z y"
        ));
        int numbersTested = 0;
        for (long testNumber = 11L; testNumber <= 99L; testNumber++) {
            String testNumberAsString = Long.toString(testNumber);
            if (testNumberAsString.contains("0")) {
                continue;
            }
            dayTwentyFour.reset();

            Integer[] digits = Arrays.stream(testNumberAsString.split("")).map(Integer::valueOf).collect(Collectors.toList()).toArray(new Integer[0]);

            dayTwentyFour.execute(digits);
            System.out.println(dayTwentyFour.getRegister("z"));

            if (numbersTested % 1_000_000 == 0) {
//                System.out.println("" +testNumber + LocalDateTime.now());
                numbersTested = 1;
            }
            numbersTested++;
        }
    }

    @Test
    void generatePossibleZValues() {
        Map<Long,String> inputZValues = new HashMap<>();
        inputZValues.put(0L,"");
        for (int digitIndex = 0; digitIndex < 14; digitIndex++) {
            inputZValues = DayTwentyFour.generateUniqueZValues(inputZValues, digitIndex);
            System.out.println(LocalDateTime.now() + " " + inputZValues.size() + " " + inputZValues.containsKey(0L));
        }
        assertThat(Long.parseLong(inputZValues.get(0L))).isEqualTo(93499629698999L);
    }

    @Test
    void toJava() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(Utils.readInputLinesFromFile("day_twenty_four.txt"));
        System.out.println(dayTwentyFour.translateToJava());
    }

    @Test
    void skunkIt() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour(Lists.emptyList());
        assertThat(dayTwentyFour.skunkWerks(1, 3, 5, 7, 9, 2, 4, 6, 8, 9, 9, 9, 9, 9)).isEqualTo(0);

    }

}
