package adventofcode2021;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwelveTest {

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

        Map<String,Set<String>> expectedEdges = Map.of(
                "start", Set.of("A", "b"),
                "A", Set.of("end","c", "b"),
                "b", Set.of("d", "end", "A"),
                "c", Set.of("A"),
                "d", Set.of("b"));
        assertThat(dayTwelve.getEdges()).containsExactlyInAnyOrderEntriesOf(expectedEdges);
    }
}
