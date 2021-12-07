package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DaySevenTest {
    @Test
    void part1Example() {
        DaySeven daySeven = new DaySeven();
        assertThat(daySeven.solve(List.of("16,1,2,0,4,2,7,1,2,14".split(",")))).isEqualTo(37);
    }

    @Test
    void part1Solution() throws IOException, URISyntaxException {
        DaySeven daySeven = new DaySeven();
        assertThat(daySeven.solve(List.of(Utils.readInputLinesFromFile("day_seven.txt").get(0).split(",")))).isEqualTo(328187);
    }
}
