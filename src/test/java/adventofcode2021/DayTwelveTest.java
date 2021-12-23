package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwelveTest {

    @Test
    void parse() {

        DayTwelve dayTwelve = new DayTwelve(List.of(
                "start-A",
                "start-b",
                "A-end",
                "A-c",
                "A-b",
                "b-d",
                "b-end"));

        assertThat(dayTwelve.getEdges()).hasSize(-1);
        // A -> [b,c,d]
    }
}
