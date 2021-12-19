package adventofcode2021;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayElevenTest {
    @Test
    void createBoard() {
        DayEleven dayEleven = new DayEleven(
                List.of(
                        "11111",
                        "19991",
                        "19191",
                        "19991",
                        "11111"
                )
        );

        assertThat(dayEleven).asString().isEqualTo(
                "11111\n"+
                "19991\n"+
                "19191\n"+
                "19991\n"+
                "11111\n"
        );
    }



}