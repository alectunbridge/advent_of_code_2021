package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DayTwoTest {

    @Test
    void testyBoi() {
        DayTwo dayTwo = new DayTwo();
        List<String> inputs = List.of(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");

        assertThat(dayTwo.process(inputs)).isEqualTo(150);


        //horizontal position of 15 and a depth of 10. (Multiplying these together produces 150
    }

    @Test
    void testyBoi2() throws Exception {
        DayTwo dayTwo = new DayTwo();

        assertThat(dayTwo.process(Utils.readInputLinesFromFile("day_two.txt"))).isEqualTo(50);

    }

    @Test
    void testyBoi3() {
        DayTwo dayTwo = new DayTwo();
        List<String> inputs = List.of(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");

        assertThat(dayTwo.processTwo(inputs)).isEqualTo(900);


        //horizontal position of 15 and a depth of 10. (Multiplying these together produces 150
    }

    @Test
    void testyBoi4() throws Exception {
        DayTwo dayTwo = new DayTwo();

        assertThat(dayTwo.processTwo(Utils.readInputLinesFromFile("day_two.txt"))).isEqualTo(2138382217);

    }
}
